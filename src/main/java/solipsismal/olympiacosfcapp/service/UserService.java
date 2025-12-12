package solipsismal.olympiacosfcapp.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import solipsismal.olympiacosfcapp.core.exceptions.PlayerNotFoundException;
import solipsismal.olympiacosfcapp.core.exceptions.UserNotFoundException;
import solipsismal.olympiacosfcapp.dto.UserDTO;
import solipsismal.olympiacosfcapp.dto.UserUpdateDTO;
import solipsismal.olympiacosfcapp.filters.Paginated;
import solipsismal.olympiacosfcapp.model.Player;
import solipsismal.olympiacosfcapp.model.User;
import solipsismal.olympiacosfcapp.repository.PlayerRepository;
import solipsismal.olympiacosfcapp.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO getUserProfile(String username) throws UserNotFoundException {
        return userRepository.findByUsername(username)
                .map(UserDTO::new)
                .orElseThrow(() -> new UserNotFoundException(username));
    }

    @Override
    @Transactional
    public UserDTO updateUserProfile(String username, UserUpdateDTO dto)
            throws UserNotFoundException, PlayerNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        if (dto.getFirstname() != null && !dto.getFirstname().isBlank()) {
            user.setFirstname(dto.getFirstname().trim());
        }

        if (dto.getLastname() != null && !dto.getLastname().isBlank()) {
            user.setLastname(dto.getLastname().trim());
        }

        if (dto.getDateOfBirth() != null) {
            user.setDateOfBirth(dto.getDateOfBirth());
        }

        if (dto.getFavoriteLegend() != null && !dto.getFavoriteLegend().isBlank()) {
            user.setFavoriteLegend(dto.getFavoriteLegend().trim());
        }

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        if (dto.getSupportedPlayerId() != null && !dto.getSupportedPlayerId().isBlank()) {
            String newPlayerId = dto.getSupportedPlayerId();
            Player newPlayer = playerRepository.findById(newPlayerId)
                    .orElseThrow(PlayerNotFoundException::new);

            Player oldPlayer = user.getSupportedPlayer();

            boolean isSamePlayer = oldPlayer != null && oldPlayer.getId().equals(newPlayer.getId());

            if (!isSamePlayer) {
                if (oldPlayer != null) {
                    oldPlayer.removeFan();
                    playerRepository.save(oldPlayer);
                }
                newPlayer.addFan();
                playerRepository.save(newPlayer);
            }
            user.setSupportedPlayer(newPlayer);
        } else {
            Player oldPlayer = user.getSupportedPlayer();
            if (oldPlayer != null) {
                oldPlayer.removeFan();
                playerRepository.save(oldPlayer);
            }
            user.setSupportedPlayer(null);
        }
        return new UserDTO(userRepository.save(user));
    }

    @Override
    public Paginated<UserDTO> getPaginatedUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<User> usersPage = userRepository.findAll(pageable);
        return Paginated.fromPage(usersPage.map(UserDTO::new));
    }
}
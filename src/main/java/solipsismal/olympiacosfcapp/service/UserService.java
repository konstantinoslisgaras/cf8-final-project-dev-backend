package solipsismal.olympiacosfcapp.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import solipsismal.olympiacosfcapp.core.exceptions.PlayerNotFoundException;
import solipsismal.olympiacosfcapp.core.exceptions.UserNotFoundException;
import solipsismal.olympiacosfcapp.dto.UserDTO;
import solipsismal.olympiacosfcapp.dto.UserUpdateDTO;
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

        if (dto.getSupportedPlayerId() != null) {
            Player player = playerRepository.findById(dto.getSupportedPlayerId())
                    .orElseThrow(PlayerNotFoundException::new);
            user.setSupportedPlayer(player);
        }

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        if (dto.getSupportedPlayerId() != null && !dto.getSupportedPlayerId().isBlank()) {
            Player oldPlayer = user.getSupportedPlayer();
            Player newPlayer = playerRepository.findById(dto.getSupportedPlayerId())
                    .orElseThrow(PlayerNotFoundException::new);

            if (oldPlayer != null && !oldPlayer.getId().equals(newPlayer.getId())) {
                oldPlayer.removeFan();
                playerRepository.save(oldPlayer);
            }

            newPlayer.addFan();
            playerRepository.save(newPlayer);
            user.setSupportedPlayer(newPlayer);
        }

        return new UserDTO(userRepository.save(user));
    }
}
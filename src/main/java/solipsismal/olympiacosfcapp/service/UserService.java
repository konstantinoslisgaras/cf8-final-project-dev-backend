package solipsismal.olympiacosfcapp.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import solipsismal.olympiacosfcapp.core.exceptions.UserNotFoundException;
import solipsismal.olympiacosfcapp.dto.UserDTO;
import solipsismal.olympiacosfcapp.dto.UserUpdateDTO;
import solipsismal.olympiacosfcapp.model.User;
import solipsismal.olympiacosfcapp.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
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
            throws UserNotFoundException {

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

        if (dto.getFavoritePlayer() != null && !dto.getFavoritePlayer().isBlank()) {
            user.setFavoritePlayer(dto.getFavoritePlayer().trim());
        }

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        return new UserDTO(userRepository.save(user));
    }
}
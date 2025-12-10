package solipsismal.olympiacosfcapp.authentication;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import solipsismal.olympiacosfcapp.core.enums.Role;
import solipsismal.olympiacosfcapp.core.exceptions.PlayerNotFoundException;
import solipsismal.olympiacosfcapp.core.exceptions.UserAlreadyExistsException;
import solipsismal.olympiacosfcapp.dto.AuthenticationRequestDTO;
import solipsismal.olympiacosfcapp.dto.AuthenticationResponseDTO;
import solipsismal.olympiacosfcapp.dto.UserRegisterRequestDTO;
import solipsismal.olympiacosfcapp.dto.UserRegisterResponseDTO;
import solipsismal.olympiacosfcapp.model.Player;
import solipsismal.olympiacosfcapp.model.User;
import solipsismal.olympiacosfcapp.repository.PlayerRepository;
import solipsismal.olympiacosfcapp.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserRegisterResponseDTO register(UserRegisterRequestDTO userRegisterRequestDTO) throws PlayerNotFoundException {

        if (userRepository.findByUsername(userRegisterRequestDTO.username()).isPresent()) {
            throw new UserAlreadyExistsException("Username", "User with username: " + userRegisterRequestDTO.username() + " already exists.");
        }

        if (userRepository.findByEmail(userRegisterRequestDTO.email()).isPresent()) {
            throw new UserAlreadyExistsException("Email", "User with email: " + userRegisterRequestDTO.email() + " already exists.");
        }

        Player player = playerRepository.findById(userRegisterRequestDTO.supportedPlayerId()).orElseThrow(PlayerNotFoundException::new);
        player.addFan();
        playerRepository.save(player);

        User user = User.builder()
                .username(userRegisterRequestDTO.username())
                .password(passwordEncoder.encode(userRegisterRequestDTO.password()))
                .firstname(userRegisterRequestDTO.firstname())
                .lastname(userRegisterRequestDTO.lastname())
                .email(userRegisterRequestDTO.email())
                .dateOfBirth(userRegisterRequestDTO.dateOfBirth())
                .favoriteLegend(userRegisterRequestDTO.favoriteLegend())
                .supportedPlayer(player)
                .genderType(userRegisterRequestDTO.genderType())
                .isOlympiacosFan(userRegisterRequestDTO.isOlympiacosFan() != null ? userRegisterRequestDTO.isOlympiacosFan() : true)
                .role(Role.USER)
                .build();

        User savedUser = userRepository.save(user);
        String token = jwtService.generateToken(savedUser.getUsername(), savedUser.getRole().name());

        return new UserRegisterResponseDTO(
                savedUser.getUsername(),
                savedUser.getFirstname(),
                token
        );
    }

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.username(), dto.password()));

        User user = (User) authentication.getPrincipal();
        String token = jwtService.generateToken(user.getUsername(), user.getRole().name());
        return new AuthenticationResponseDTO(user.getFirstname(), user.getLastname(), token);
    }
}

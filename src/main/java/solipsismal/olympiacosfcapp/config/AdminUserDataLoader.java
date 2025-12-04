package solipsismal.olympiacosfcapp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import solipsismal.olympiacosfcapp.core.enums.Role;
import solipsismal.olympiacosfcapp.model.User;
import solipsismal.olympiacosfcapp.repository.UserRepository;

@Component
@Order(1) // run before other data loaders if needed
public class AdminUserDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminUserDataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (userRepository.findByUsername("admin7").isEmpty()) {
            User admin7 = new User();
            admin7.setUsername("admin7");
            admin7.setPassword(passwordEncoder.encode("1234567QWEqwe!@#"));
            admin7.setFirstname("SUPER");
            admin7.setLastname("ADMIN");
            admin7.setEmail("konstantinoslisgaras@gmail.com");
            admin7.setRole(Role.SUPER_ADMIN);
            userRepository.save(admin7);
        }
        if (userRepository.findByUsername("user7").isEmpty()) {
            User user7 = new User();
            user7.setUsername("user7");
            user7.setPassword(passwordEncoder.encode("1234567QWEqwe!@#"));
            user7.setFirstname("USER");
            user7.setLastname("USER");
            user7.setEmail("konstantinoslisgaras@googlemail.com");
            user7.setRole(Role.USER);
            userRepository.save(user7);
        }
    }
}
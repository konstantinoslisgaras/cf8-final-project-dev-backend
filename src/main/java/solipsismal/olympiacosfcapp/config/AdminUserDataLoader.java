package solipsismal.olympiacosfcapp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import solipsismal.olympiacosfcapp.core.enums.GenderType;
import solipsismal.olympiacosfcapp.core.enums.Role;
import solipsismal.olympiacosfcapp.model.User;
import solipsismal.olympiacosfcapp.repository.UserRepository;

import java.time.LocalDate;

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
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("1234567QWEqwe!@#"));
            admin.setFirstname("SUPER");
            admin.setLastname("ADMIN");
            admin.setEmail("konstantinoslisgaras@gmail.com");
            admin.setDateOfBirth(LocalDate.parse("1991-11-14"));
            admin.setGenderType(GenderType.PREFER_NOT_TO_DISCLOSE);
            admin.setFavoritePlayer("Giovanni Silva de Oliveira");
            admin.setRole(Role.SUPER_ADMIN);
            userRepository.save(admin);
        }
        if (userRepository.findByUsername("user").isEmpty()) {
            User user1 = new User();
            user1.setUsername("user1");
            user1.setPassword(passwordEncoder.encode("1234567QWEqwe!@#"));
            user1.setFirstname("USER1");
            user1.setLastname("USER1");
            user1.setEmail("konstantinoslisgaras@googlemail.com");
            user1.setDateOfBirth(LocalDate.parse("1991-11-14"));
            user1.setGenderType(GenderType.MALE);
            user1.setFavoritePlayer("Rivaldo");
            user1.setRole(Role.USER);
            userRepository.save(user1);
        }
    }
}
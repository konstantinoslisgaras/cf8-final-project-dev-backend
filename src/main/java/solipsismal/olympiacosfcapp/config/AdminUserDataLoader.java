package solipsismal.olympiacosfcapp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import solipsismal.olympiacosfcapp.core.enums.GenderType;
import solipsismal.olympiacosfcapp.core.enums.Role;
import solipsismal.olympiacosfcapp.core.exceptions.PlayerNotFoundException;
import solipsismal.olympiacosfcapp.model.Player;
import solipsismal.olympiacosfcapp.model.User;
import solipsismal.olympiacosfcapp.repository.PlayerRepository;
import solipsismal.olympiacosfcapp.repository.UserRepository;

import java.time.LocalDate;

@Component
@Order(9)
public class AdminUserDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PlayerRepository playerRepository;

    public AdminUserDataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder, PlayerRepository playerRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.playerRepository = playerRepository;
    }

    @Override
    public void run(String... args) throws PlayerNotFoundException {
        if (userRepository.findByUsername("admin").isEmpty()) {
            Player supportedPlayer = playerRepository.findById("PL53859301").orElseThrow(PlayerNotFoundException::new);
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("1234567QWEqwe!@#"));
            admin.setFirstname("Admin");
            admin.setLastname("Super");
            admin.setEmail("konstantinoslisgaras@gmail.com");
            admin.setDateOfBirth(LocalDate.parse("1991-11-14"));
            admin.setGenderType(GenderType.PREFER_NOT_TO_DISCLOSE);
            admin.setSupportedPlayer(supportedPlayer);
            admin.setFavoriteLegend("Giovanni Silva de Oliveira");
            admin.setIsOlympiacosFan(true);
            admin.setRole(Role.SUPER_ADMIN);
            supportedPlayer.addFan();
            playerRepository.save(supportedPlayer);

            userRepository.save(admin);
        }

        if (userRepository.findByUsername("user").isEmpty()) {
            Player supportedPlayer1 = playerRepository.findById("PL52329655").orElseThrow(PlayerNotFoundException::new);
            User user1 = new User();
            user1.setUsername("user");
            user1.setPassword(passwordEncoder.encode("1234567QWEqwe!@#"));
            user1.setFirstname("User");
            user1.setLastname("User");
            user1.setEmail("konstantinoslisgaras@googlemail.com");
            user1.setDateOfBirth(LocalDate.parse("1991-11-14"));
            user1.setGenderType(GenderType.MALE);
            user1.setSupportedPlayer(supportedPlayer1);
            user1.setFavoriteLegend("Rivaldo");
            user1.setIsOlympiacosFan(true);
            user1.setRole(Role.USER);
            supportedPlayer1.addFan();
            playerRepository.save(supportedPlayer1);

            userRepository.save(user1);
        }

        String[] firstNames = {"Kostas", "Konstantinos", "Athina", "Giannis", "George", "Dimitris", "Dimitrios", "Spiros", "Aggelos", "Eleni", "Stefanos", "Aggeliki", "Maria", "Christos", "Christina", "Nikos", "Antonis", "Katerina", "Anna", "Tasos", "Ioannis", "Dimitra", "Manolis", "Despoina", "Georgia", "Mairi", "Charis", "Panagiotis", "Panagiota", "Michalis", "Efi"};
        String[] lastNames = {"K.", "L.", "A.", "S.", "T.", "B.", "M.", "N.", "P.", "D.", "R.", "E.", "I.", "G."};
        @SuppressWarnings("SpellCheckingInspection") String[] legendNames = {"Predrag Đorđević", "Giorgos Sideris", "Nikos Anastopoulos", "Stelios Giannakopoulos", "Vassilis Karapialis", "Alexis Alexandris", "Christian Karembeu", "Riváldo", "Grigoris Georgatos", "Georgios Anatolakis", "Kyriakos Karataidis", "Nikos Sarganis", "Andreas Mouratis", "Thanasis Bebis", "Julio Losada", "Dudu Cearense", "Avraam Papadopoulos", "Kostas Fortounis", "Refik Šabanadžović", "Ilias Poursanidis", "Nery Alberto Castillo", "Luciano Galleti", "Antonis Nikopolidis"};
        String[] playerIds = {"PL53859301", "PL90113428", "PL32095644", "PL82542910", "PL14949263", "PL52873291", "PL98302943", "PL72029451", "PL38993810", "PL89234201", "PL80563144", "PL69802341", "PL29757340", "PL52329655", "PL68034151", "PL13945570", "PL72352901", "PL25297542", "PL84249033", "PL40914528", "PL93532714", "PL04579343", "PL25943256", "PL15687065", "PL47229603", "PL38616402", "PL94345107", "PL47639319", "PL60495429"};

        for (int i = 1; i <= 1000; i++) {
            String username = "user" + i;
            if (userRepository.findByUsername(username).isPresent()) continue;

            String firstname = firstNames[(int)(Math.random() * firstNames.length)];
            String lastname = lastNames[(int)(Math.random() * lastNames.length)];
            String email = username + "@example.com";
            LocalDate dob = LocalDate.of(1970 + (int)(Math.random() * 35), 1 + (int)(Math.random() * 12), 1 + (int)(Math.random() * 28));
            GenderType gender = GenderType.values()[(int)(Math.random() * GenderType.values().length)];
            Player supportedPlayer = playerRepository.findById(playerIds[(int)(Math.random() * playerIds.length)])
                    .orElseThrow(() -> new RuntimeException("Player not found"));
            String favoriteLegend = legendNames[(int)(Math.random() * legendNames.length)];

            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode("1234567QWEqwe!@#"));
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setEmail(email);
            user.setDateOfBirth(dob);
            user.setGenderType(gender);
            user.setSupportedPlayer(supportedPlayer);
            user.setFavoriteLegend(favoriteLegend);
            user.setIsOlympiacosFan(true);
            user.setRole(Role.USER);
            supportedPlayer.addFan();
            playerRepository.save(supportedPlayer);

            userRepository.save(user);
        }
    }
}
package solipsismal.olympiacosfcapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OlympiacosFcApplication {

	public static void main(String[] args) {
		welcomeMessage();
		SpringApplication.run(OlympiacosFcApplication.class, args);
	}

	static void welcomeMessage() {
		System.out.println();
		System.out.println("=".repeat(100));
		System.out.println("Welcome to my app. I am solipsismal.");
		System.out.println("This app provides 2025 season stats for the greatest club in the world.");
		System.out.println("Forza Olympiacos! Forza Thrylos!");
		System.out.println("=".repeat(100));
	}

	// TO DO: edit profile in superadmin also- flyway
}
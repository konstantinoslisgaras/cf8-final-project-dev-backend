package solipsismal.olympiacosfcapp.dto;

import lombok.*;
import solipsismal.olympiacosfcapp.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate dateOfBirth;
    private String genderType;
    private String supportedPlayerId;
    private String supportedPlayerName;
    private String favoriteLegend;
    private boolean isOlympiacosFan;
    private String role;
    private String memberSince;
    private boolean isActive;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.dateOfBirth = user.getDateOfBirth();
        this.genderType = user.getGenderType().toString();
        this.supportedPlayerId = user.getSupportedPlayer().getId();
        this.supportedPlayerName = user.getSupportedPlayer().getLastname();
        this.favoriteLegend = user.getFavoriteLegend();
        this.isOlympiacosFan = user.getIsOlympiacosFan();
        this.role = user.getRole().toString();
        this.memberSince = formatMemberSince(user.getCreatedAt());
        this.isActive = user.getIsActive();
    }

    private String formatMemberSince(LocalDateTime createdAt) {
        if (createdAt == null) return null;
        return createdAt.toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}

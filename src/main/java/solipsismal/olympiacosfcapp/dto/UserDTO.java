package solipsismal.olympiacosfcapp.dto;

import lombok.*;
import solipsismal.olympiacosfcapp.core.enums.GenderType;
import solipsismal.olympiacosfcapp.model.User;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate dateOfBirth;
    private String genderType;
    private String favoritePlayer;

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.dateOfBirth = user.getDateOfBirth();
        this.genderType = user.getGenderType().toString();
        this.favoritePlayer = user.getFavoritePlayer();
    }
}

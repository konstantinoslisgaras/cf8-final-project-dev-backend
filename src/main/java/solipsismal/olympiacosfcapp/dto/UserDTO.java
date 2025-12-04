package solipsismal.olympiacosfcapp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.model.User;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class UserDTO {
    private Long id;
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String favoritePlayer;

    public UserDTO(User user) {
        this.id = user.getId();
        this.password = user.getPassword();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.dateOfBirth = user.getDateOfBirth();
        this.favoritePlayer = user.getFavoritePlayer();
    }
}

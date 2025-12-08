package solipsismal.olympiacosfcapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class UserUpdateDTO {

    @Length(min = 2, max = 30, message = "First name must be between 2 and 30 characters.")
    private String firstname;

    @Length(min = 2, max = 30, message = "Last name must be between 2 and 30 characters.")
    private String lastname;

    @Pattern(regexp = "^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?\\d)(?=.*?[@#$!%&*]).{8,}$",
            message = "Invalid Password")
    private String password;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @Length(max = 30, message = "Favorite player name must have a maximum of 100 characters.")
    private String favoritePlayer;
}
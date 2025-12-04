package solipsismal.olympiacosfcapp.dto;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "First name is required")
    @Length(min = 2, max = 30, message = "First name must be between 2 and 30 characters.")
    private Integer firstname;

    @NotBlank(message = "Last name is required")
    @Length(min = 2, max = 30, message = "Last name must be between 2 and 30 characters.")
    private String lastname;

    @Pattern(regexp = "^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?\\d)(?=.*?[@#$!%&*]).{8,}$",
            message = "Invalid Password")
    private String password;

    private LocalDate dateOfBirth;

    @Length(max = 30, message = "Favorite player name must have a maximum of 100 characters.")
    private String favoritePlayer;
}
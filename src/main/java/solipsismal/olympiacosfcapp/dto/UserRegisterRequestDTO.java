package solipsismal.olympiacosfcapp.dto;

import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import solipsismal.olympiacosfcapp.core.enums.GenderType;

import java.time.LocalDate;

@Builder
public record UserRegisterRequestDTO(

        @NotBlank(message = "Username is required")
        @Schema(example = "username")
        String username,

        @Pattern(regexp = "^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?\\d)(?=.*?[@#$!%&*]).{8,}$",
                message = "Invalid Password")
        @Schema(example = "123QWEqwe!@#")
        String password,

        @NotBlank(message = "First name is required")
        @Schema(example = "Kappa")
        String firstname,

        @NotBlank(message = "Last name is required")
        @Schema(example = "Lambda")
        String lastname,

        @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
                message = "Invalid Email")
        @Schema(example = "kappalambda@gmail.com")
        String email,

        @Schema(example = "1991-11-14")
        LocalDate dateOfBirth,

        @Schema(example = "MALE")
        GenderType genderType,

        @NotBlank(message = "Supported player is required")
        @Schema(example = "PL53859301")
        String supportedPlayerId,

        @Schema(example = "Giovanni Silva De Oliveira")
        String favoriteLegend,

        @Schema(example = "true")
        Boolean isOlympiacosFan
) {}
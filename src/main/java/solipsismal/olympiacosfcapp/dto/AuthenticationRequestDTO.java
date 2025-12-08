package solipsismal.olympiacosfcapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record AuthenticationRequestDTO(
        @NotNull
        @Schema(example = "admin")
        String username,

        @NotNull
        @Schema(example = "1234567QWEqwe!@#")
        String password) {
}

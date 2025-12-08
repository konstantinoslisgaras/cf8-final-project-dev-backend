package solipsismal.olympiacosfcapp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionPositionUpdateDTO {

    @NotBlank(message = "Competition ID is required.")
    private String competitionId;

    @NotNull(message = "Position is required.")
    @Min(value = 1, message = "Position must be at least 1.")
    @Max(value = 50, message = "Position must not be more than 50.")
    private Integer position;
}

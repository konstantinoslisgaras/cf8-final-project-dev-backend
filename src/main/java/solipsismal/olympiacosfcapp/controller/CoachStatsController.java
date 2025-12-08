package solipsismal.olympiacosfcapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solipsismal.olympiacosfcapp.core.exceptions.CoachStatsNotFoundException;
import solipsismal.olympiacosfcapp.dto.CoachStatsDTO;
import solipsismal.olympiacosfcapp.mapper.CoachStatsMapper;
import solipsismal.olympiacosfcapp.model.Coach;
import solipsismal.olympiacosfcapp.repository.CoachRepository;

@RestController
@RequestMapping("/api/statistics")
@RequiredArgsConstructor
public class CoachStatsController {

    private final CoachRepository coachRepository;

    @GetMapping("/coach/{coachStatsId}")
    @Operation(
            summary = "Get coach stats by id.",
            description = "Retrieves a coach's stats by their id."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Coach stats found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CoachStatsDTO.class))
    )
    @ApiResponse(responseCode = "404", description = "Coach stats not Found")
    public CoachStatsDTO getCoachStatsById(@PathVariable String coachStatsId) throws CoachStatsNotFoundException {
        Coach coach = coachRepository.findByCoachStatsId(coachStatsId).orElseThrow(CoachStatsNotFoundException::new);
        return CoachStatsMapper.toDTO(coach);
    }
}
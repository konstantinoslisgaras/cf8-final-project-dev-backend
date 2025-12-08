package solipsismal.olympiacosfcapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import solipsismal.olympiacosfcapp.core.exceptions.CoachStatsNotFoundException;
import solipsismal.olympiacosfcapp.core.exceptions.CompetitionNotFoundException;
import solipsismal.olympiacosfcapp.dto.CompetitionDTO;
import solipsismal.olympiacosfcapp.dto.CompetitionPositionUpdateDTO;
import solipsismal.olympiacosfcapp.service.CompetitionService;

import java.util.List;

@RestController
@RequestMapping("/api/super-admin")
@RequiredArgsConstructor
public class SuperAdminController {

    private final CompetitionService competitionService;

    @GetMapping("/competitions")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<List<CompetitionDTO>> getAllCompetitions() {
        List<CompetitionDTO> competitions = competitionService.findAll();
        return ResponseEntity.ok(competitions);
    }

    @PutMapping("/competitions/position")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<CompetitionDTO> updateCompetitionPosition(@Valid @RequestBody CompetitionPositionUpdateDTO updateDTO)
            throws CompetitionNotFoundException {
        CompetitionDTO updatedCompetition = competitionService.updateCompetitionPosition(updateDTO);
        return ResponseEntity.ok(updatedCompetition);
    }
}
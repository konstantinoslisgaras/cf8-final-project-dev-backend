package solipsismal.olympiacosfcapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import solipsismal.olympiacosfcapp.core.exceptions.CompetitionNotFoundException;
import solipsismal.olympiacosfcapp.core.exceptions.UserNotFoundException;
import solipsismal.olympiacosfcapp.dto.CompetitionDTO;
import solipsismal.olympiacosfcapp.dto.CompetitionPositionUpdateDTO;
import solipsismal.olympiacosfcapp.dto.UserDTO;
import solipsismal.olympiacosfcapp.filters.Paginated;
import solipsismal.olympiacosfcapp.model.User;
import solipsismal.olympiacosfcapp.repository.UserRepository;
import solipsismal.olympiacosfcapp.service.CompetitionService;
import solipsismal.olympiacosfcapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/super-admin")
@RequiredArgsConstructor
public class SuperAdminController {

    private final CompetitionService competitionService;
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/competitions")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<List<CompetitionDTO>> getAllCompetitions() {
        List<CompetitionDTO> competitions = competitionService.findActive();
        return ResponseEntity.ok(competitions);
    }

    @PutMapping("/competitions/position")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<CompetitionDTO> updateCompetitionPosition(@Valid @RequestBody CompetitionPositionUpdateDTO updateDTO)
            throws CompetitionNotFoundException {
        CompetitionDTO updatedCompetition = competitionService.updateCompetitionPosition(updateDTO);
        return ResponseEntity.ok(updatedCompetition);
    }

    @GetMapping("/users/{username}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        try {
            UserDTO user = userService.getUserProfile(username);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/users/count")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public Integer getTotalUsers() {
        return Math.toIntExact(userRepository.count());
    }

    @GetMapping("/users/paginated")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<Paginated<UserDTO>> getPaginatedUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Paginated<UserDTO> paginatedUsers = userService.getPaginatedUsers(page, size);
        return ResponseEntity.ok(paginatedUsers);
    }
}
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
import solipsismal.olympiacosfcapp.core.exceptions.PlayerNotFoundException;
import solipsismal.olympiacosfcapp.dto.PlayerDTO;
import solipsismal.olympiacosfcapp.dto.PlayerListDTO;
import solipsismal.olympiacosfcapp.model.Player;
import solipsismal.olympiacosfcapp.repository.PlayerRepository;
import solipsismal.olympiacosfcapp.service.PlayerService;
import solipsismal.olympiacosfcapp.service.UserService;


import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final PlayerService playerService;

    @GetMapping("/players/{playerId}")
    @Operation(
            summary = "Get player by id.",
            description = "Retrieves a player's information by their id."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Player found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PlayerDTO.class))
    )
    @ApiResponse(responseCode = "404", description = "Player not Found")
    public PlayerDTO getPlayerById(@PathVariable String playerId) throws PlayerNotFoundException {
        Player player = playerRepository.findById(playerId).orElseThrow(PlayerNotFoundException::new);
        return new PlayerDTO(player);
    }

    @GetMapping("/auth/register")
    public List<PlayerListDTO> getPlayerList() {
        return playerService.getPlayerList();
    }
}
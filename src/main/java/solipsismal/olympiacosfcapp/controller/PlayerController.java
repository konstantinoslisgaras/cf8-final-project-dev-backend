package solipsismal.olympiacosfcapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solipsismal.olympiacosfcapp.core.exceptions.PlayerNotFoundException;
import solipsismal.olympiacosfcapp.dto.PlayerDTO;
import solipsismal.olympiacosfcapp.model.Player;
import solipsismal.olympiacosfcapp.repository.PlayerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerRepository playerRepository;

    @GetMapping("/fullteam")
    public List<PlayerDTO> getSquad() {
        return playerRepository.findAllByOrderByPositionAscShirtNumberAsc()
                .stream()
                .map(PlayerDTO::new)
                .toList();
    }

    @GetMapping("/id/{id}")
    public PlayerDTO getPlayerById(@PathVariable String id) throws PlayerNotFoundException {
        Player player = playerRepository.findById(id).orElseThrow(PlayerNotFoundException::new);
        return new PlayerDTO(player);
    }

    @GetMapping("/lastname/{lastname}")
    public PlayerDTO getPlayerByLastname(@PathVariable String lastname) throws PlayerNotFoundException {
        Player player = playerRepository.findByLastname(lastname).orElseThrow(() -> new PlayerNotFoundException(lastname));
        return new PlayerDTO(player);
    }
}

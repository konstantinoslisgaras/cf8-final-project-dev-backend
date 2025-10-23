package solipsismal.olympiacosfcapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solipsismal.olympiacosfcapp.dto.PlayerDTO;
import solipsismal.olympiacosfcapp.model.Player;
import solipsismal.olympiacosfcapp.repository.MatchRepository;
import solipsismal.olympiacosfcapp.repository.PlayerMatchRepository;
import solipsismal.olympiacosfcapp.repository.PlayerRepository;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;
    private final PlayerMatchRepository playerMatchRepository;

    @GetMapping("/squad")
    public List<PlayerDTO> findAllByOrderByPositionAscByShirtNumberAsc() {
        return playerRepository.findAllByOrderByPositionAscByShirtNumberAsc()
                .stream()
                .map(PlayerDTO::new)
                .toList();
    }

    @GetMapping("/players/{id}")
    public PlayerDTO getPlayer(@PathVariable String id) {
        Player player = playerRepository.findById(id).orElseThrow();
        return new PlayerDTO(player);
    }
}

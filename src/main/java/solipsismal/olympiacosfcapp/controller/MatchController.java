package solipsismal.olympiacosfcapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solipsismal.olympiacosfcapp.core.exceptions.MatchNotFoundException;
import solipsismal.olympiacosfcapp.dto.MatchFullDTO;
import solipsismal.olympiacosfcapp.dto.MatchBasicDTO;
import solipsismal.olympiacosfcapp.model.Match;
import solipsismal.olympiacosfcapp.repository.MatchRepository;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchRepository matchRepository;

    @GetMapping()
    public List<MatchBasicDTO> getMatches() {
        return matchRepository.findAllByOrderByMatchNumber()
                .stream()
                .map(MatchBasicDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public MatchFullDTO getMatchById(@PathVariable String id) throws MatchNotFoundException {
        Match match = matchRepository.findById(id).orElseThrow(MatchNotFoundException::new);
        return new MatchFullDTO(match);
    }
}
package solipsismal.olympiacosfcapp.service;

import org.springframework.stereotype.Service;
import solipsismal.olympiacosfcapp.dto.MatchBasicDTO;
import solipsismal.olympiacosfcapp.model.Match;
import solipsismal.olympiacosfcapp.repository.MatchRepository;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MatchService implements IMatchService{

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Optional<MatchBasicDTO> getPreviousMatch() {
        LocalDateTime now = LocalDateTime.now();
        return matchRepository.findPreviousMatch(now)
                .map(MatchBasicDTO::new);
    }

    @Override
    public Optional<MatchBasicDTO> getNextMatch() {
        LocalDateTime now = LocalDateTime.now();
        return matchRepository.findNextMatch(now)
                .map(MatchBasicDTO::new);
    }

    @Override
    public Map<String, Integer> getCurrentStreak() {
        List<String> results = matchRepository.findAllByOrderByMatchNumberDesc()
                .stream()
                .map(Match::getResult)
                .filter(Objects::nonNull)
                .toList();

        Map<String, Integer> map = new HashMap<>();
        String streakResult;
        int streakNumber = 0;

        for (int i = 0; i < results.size() - 1; i++) {
            streakResult = results.get(i);
            streakNumber += 1;
            if (!Objects.equals(results.get(i), results.get(i + 1))) {
                map.put(streakResult, streakNumber);
                break;
            }
        }
        return map;
    }
}
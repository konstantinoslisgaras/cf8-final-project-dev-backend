package solipsismal.olympiacosfcapp.service;

import solipsismal.olympiacosfcapp.dto.MatchBasicDTO;

import java.util.Map;
import java.util.Optional;

public interface IMatchService {
    Optional<MatchBasicDTO> getPreviousMatch();
    Optional<MatchBasicDTO> getNextMatch();
    Map<String, Integer> getCurrentStreak();
}

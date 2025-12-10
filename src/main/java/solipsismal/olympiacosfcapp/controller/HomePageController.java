package solipsismal.olympiacosfcapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solipsismal.olympiacosfcapp.dto.CompetitionDTO;
import solipsismal.olympiacosfcapp.dto.MatchBasicDTO;
import solipsismal.olympiacosfcapp.service.CompetitionService;
import solipsismal.olympiacosfcapp.service.MatchService;
import solipsismal.olympiacosfcapp.service.PlayerStatsService;

import java.util.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomePageController {

    private final MatchService matchService;
    private final PlayerStatsService playerStatsService;
    private final CompetitionService competitionService;

    @GetMapping("/homepage")
    public Map<String, Object> getHomepageData() {
        Map<String, Object> homePageData = new HashMap<>();

        // Latest match
        Optional<MatchBasicDTO> previousMatch = matchService.getPreviousMatch();
        homePageData.put("previousMatch", previousMatch);

        // Next match
        Optional<MatchBasicDTO> nextMatch = matchService.getNextMatch();
        homePageData.put("nextMatch", nextMatch);

        // Player stat leaders
        homePageData.put("topScorer", Objects.requireNonNull(playerStatsService.getTopScorer().orElse(null)));
        homePageData.put("top5Scorers", Objects.requireNonNull(playerStatsService.getTop5Scorers()));
        homePageData.put("assistLeader", Objects.requireNonNull(playerStatsService.getAssistsLeader().orElse(null)));
        homePageData.put("top5Assists", Objects.requireNonNull(playerStatsService.getTop5AssistsLeaders()));
        homePageData.put("mostYellowCards", Objects.requireNonNull(playerStatsService.getPlayerWithMostYellowCards().orElse(null)));
        homePageData.put("top5MostYellowCards", Objects.requireNonNull(playerStatsService.getTop5PlayersWithMostYellowCards()));
        homePageData.put("mostRedCards", Objects.requireNonNull(playerStatsService.getPlayerWithMostRedCards().orElse(null)));
        homePageData.put("top5MostRedCards", Objects.requireNonNull(playerStatsService.findTop5ByRedCardsGreaterThanOrderByRedCardsDesc()));
        homePageData.put("minutesPlayedLeader", Objects.requireNonNull(playerStatsService.getMinutesPlayedLeader().orElse(null)));
        homePageData.put("top5MinutesPlayedLeaders", Objects.requireNonNull(playerStatsService.getTop5MinutesPlayedLeaders()));
        homePageData.put("matchesPlayedLeader", Objects.requireNonNull(playerStatsService.getMatchesPlayedLeader().orElse(null)));
        homePageData.put("top5MatchesPlayedLeaders", Objects.requireNonNull(playerStatsService.getTop5MatchesPlayedLeaders()));
        homePageData.put("mostWins", Objects.requireNonNull(playerStatsService.getPlayerWithMostWins().orElse(null)));
        homePageData.put("top5MostWins", Objects.requireNonNull(playerStatsService.getTop5PlayersWithMostWins()));

        // Competition stats
        List<CompetitionDTO> competitionStatus = competitionService.findActive();
        homePageData.put("competitionsStatus", competitionStatus);

        // Current streak
        homePageData.put("currentStreak", Objects.requireNonNull(matchService.getCurrentStreak()));

        return homePageData;
    }
}
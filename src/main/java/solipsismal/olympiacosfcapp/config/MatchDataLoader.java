package solipsismal.olympiacosfcapp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import static solipsismal.olympiacosfcapp.core.enums.Day.*;
import static solipsismal.olympiacosfcapp.core.enums.Ground.*;

import solipsismal.olympiacosfcapp.core.exceptions.OpponentNotFoundException;
import solipsismal.olympiacosfcapp.model.*;
import solipsismal.olympiacosfcapp.repository.*;

@Component
@Order(7)
public class MatchDataLoader implements CommandLineRunner {

    private final MatchRepository matchRepository;
    private final OlympiacosRepository olympiacosRepository;
    private final OpponentRepository opponentRepository;
    private final CompetitionRepository competitionRepository;
    private final CoachRepository coachRepository;
    private final SeasonRepository seasonRepository;
    private final TeamStatsRepository teamStatsRepository;

    public MatchDataLoader(MatchRepository matchRepository, OlympiacosRepository olympiacosRepository,
                           OpponentRepository opponentRepository, CompetitionRepository competitionRepository,
                           CoachRepository coachRepository, SeasonRepository seasonRepository, TeamStatsRepository teamStatsRepository) {
        this.matchRepository = matchRepository;
        this.olympiacosRepository = olympiacosRepository;
        this.opponentRepository = opponentRepository;
        this.competitionRepository = competitionRepository;
        this.coachRepository = coachRepository;
        this.seasonRepository = seasonRepository;
        this.teamStatsRepository = teamStatsRepository;
    }

    @Override
    public void run(String... args) throws OpponentNotFoundException {
        // Static Data
        Season season2526 = seasonRepository.findById("SE20252026").orElseThrow();
        Olympiacos olympiacos = olympiacosRepository.findById("OL00000007").orElseThrow();
        Coach mendilibar = coachRepository.findByLastname("Mendilibar").orElseThrow();

        // Competitions
        Competition superLeagueGreece = competitionRepository.findByCompetitionName("Super League Greece").orElseThrow();
        Competition championsLeague = competitionRepository.findByCompetitionName("Champions League").orElseThrow();
        Competition greekFootballCup = competitionRepository.findByCompetitionName("Greek Football Cup").orElseThrow();

        // Team and Season Stats
        TeamStats season2526TotalTeamStats = new TeamStats("TS20252026");
        teamStatsRepository.save(season2526TotalTeamStats);
        season2526.setTeamStats(season2526TotalTeamStats);
        seasonRepository.save(season2526);

        // Matches
        // Match 1 | OLYMPIACOS F.C. - Asteras 2:0 | 23/08/2025
        TeamStats teamStats01230825 = new TeamStats("TS01230825",
                2, 2, 0, 0, 0, 1, 0, 0, 1);
        Match match01230825 = new Match("MA01230825",
                olympiacos, opponentRepository.findByOpponentName("Asteras Tripolis").orElseThrow(OpponentNotFoundException::new),
                2, 0,
                "23/08/2025", SATURDAY, superLeagueGreece, HOME,
                1, "Super League MatchDay: 01, Round 1", mendilibar, season2526, teamStats01230825);
        saveMatchAndUpdateTotalStats(match01230825, teamStats01230825, season2526TotalTeamStats);

        // Match 2 | NFC Volos - OLYMPIACOS F.C. 0:2 | 30/08/2025
        TeamStats teamStats02300825 = new TeamStats("TS02300825",
                2, 2, 0, 0, 0, 1, 0, 0, 1);
        Match match02300825 = new Match("MA02300825",
                olympiacos, opponentRepository.findByOpponentName("NFC Volos").orElseThrow(OpponentNotFoundException::new),
                2, 0,
                "30/08/2025", SATURDAY, superLeagueGreece, AWAY,
                2, "Super League MatchDay: 02, Round 1", mendilibar, season2526, teamStats02300825);
        saveMatchAndUpdateTotalStats(match02300825, teamStats02300825, season2526TotalTeamStats);

        // Match 3 | OLYMPIACOS F.C. - Panserraikos FC 5:0 | 13/09/2025
        TeamStats teamStats03130925 = new TeamStats("TS03130925",
                5, 5, 0, 0, 0, 1, 0, 0, 1);
        Match match03130925 = new Match("MA03130925",
                olympiacos, opponentRepository.findByOpponentName("Panserraikos FC").orElseThrow(OpponentNotFoundException::new),
                5, 0,
                "13/09/2025", SATURDAY, superLeagueGreece, HOME,
                3, "Super League MatchDay: 03, Round 1", mendilibar, season2526, teamStats03130925);
        saveMatchAndUpdateTotalStats(match03130925, teamStats03130925, season2526TotalTeamStats);

        // Match 4 | OLYMPIACOS F.C. - Pafos FC 0:0 | 17/09/2025
        TeamStats teamStats04170925 = new TeamStats("TS04170925",
                0, 0, 0, 3, 0, 0, 1, 0, 1);
        Match match04170925 = new Match("MA04170925",
                olympiacos, opponentRepository.findByOpponentName("Pafos FC").orElseThrow(OpponentNotFoundException::new),
                0, 0,
                "17/09/2025", WEDNESDAY, championsLeague, HOME,
                4, "Champions League League Phase MatchDay: 01", mendilibar, season2526, teamStats04170925);
        saveMatchAndUpdateTotalStats(match04170925, teamStats04170925, season2526TotalTeamStats);

        // Match 5 | Panathinaikos - OLYMPIACOS F.C 1:1 | 21/09/2025
        TeamStats teamStats05210925 = new TeamStats("TS05210925",
                1, 1, 1, 4, 0, 0, 1, 0, 1);
        Match match05210925 = new Match("MA05210925",
                olympiacos, opponentRepository.findByOpponentName("Panathinaikos").orElseThrow(OpponentNotFoundException::new),
                1, 1,
                "21/09/2025", SUNDAY, superLeagueGreece, AWAY,
                5, "Super League MatchDay: 04, Round 1", mendilibar, season2526, teamStats05210925);
        saveMatchAndUpdateTotalStats(match05210925, teamStats05210925, season2526TotalTeamStats);

        // Match 6 | Asteras Tripolis - OLYMPIACOS F.C. 1:2 | 24/09/2025
        TeamStats teamStats06240925 = new TeamStats("TS06240925",
                2, 0, 1, 5, 0, 1, 0, 0, 1);
        Match match06240925 = new Match("MA06240925",
                olympiacos, opponentRepository.findByOpponentName("Asteras Tripolis").orElseThrow(OpponentNotFoundException::new),
                2, 1,
                "24/09/2025", WEDNESDAY, greekFootballCup, AWAY,
                6, "Greek Football Cup League Phase MatchDay: 01", mendilibar, season2526,teamStats06240925);
        saveMatchAndUpdateTotalStats(match06240925, teamStats06240925, season2526TotalTeamStats);

        // Match 7 | OLYMPIACOS F.C. - Levadiakos 3:2 | 27/09/2025
        TeamStats teamStats07270925 = new TeamStats("TS07270925",
                3, 2, 2, 2, 0, 1, 0, 0, 1);
        Match match07270925 = new Match("MA07270925",
                olympiacos, opponentRepository.findByOpponentName("Levadiakos").orElseThrow(OpponentNotFoundException::new),
                3, 2,
                "27/09/2025", SATURDAY, superLeagueGreece, HOME,
                7, "Super League MatchDay: 05, Round 1", mendilibar, season2526,teamStats07270925);
        saveMatchAndUpdateTotalStats(match07270925, teamStats07270925, season2526TotalTeamStats);

        // Match 8 | Arsenal FC - OLYMPIACOS F.C. 2:0 | 01/10/2025
        TeamStats teamStats08011025 = new TeamStats("TS08011025",
                0, 0, 2, 2, 0, 0, 0, 1, 1);
        Match match08011025 = new Match("MA08011025",
                olympiacos, opponentRepository.findByOpponentName("Arsenal FC").orElseThrow(OpponentNotFoundException::new),
                0, 2,
                "01/10/2025", WEDNESDAY, championsLeague, AWAY,
                8, "Champions League League Phase MatchDay: 02", mendilibar, season2526, teamStats08011025);
        saveMatchAndUpdateTotalStats(match08011025, teamStats08011025, season2526TotalTeamStats);

        // Match 9 | PAOK FC - OLYMPIACOS F.C. 2:1 | 05/10/2025
        TeamStats teamStats09051025 = new TeamStats("TS09051025",
                1, 1, 2, 3, 0, 0, 0, 1, 1);
        Match match09051025 = new Match("MA09051025",
                olympiacos, opponentRepository.findByOpponentName("PAOK FC").orElseThrow(OpponentNotFoundException::new),
                1, 2,
                "05/10/2025", SUNDAY, superLeagueGreece, AWAY,
                9, "Super League MatchDay: 06, Round 1", mendilibar, season2526, teamStats09051025);
        saveMatchAndUpdateTotalStats(match09051025, teamStats09051025, season2526TotalTeamStats);

        // Match 10 | AE Larissa - OLYMPIACOS F.C. 0:2 | 18/10/2025
        TeamStats teamStats10181025 = new TeamStats("TS10181025",
                2, 1, 0, 1, 0, 1, 0, 0, 1);
        Match match10181025 = new Match("MA10181025",
                olympiacos, opponentRepository.findByOpponentName("AE Larissa").orElseThrow(OpponentNotFoundException::new),
                2, 0,
                "18/10/2025", SATURDAY, superLeagueGreece, AWAY,
                10, "Super League MatchDay: 07, Round 1", mendilibar, season2526, teamStats10181025);
        saveMatchAndUpdateTotalStats(match10181025, teamStats10181025, season2526TotalTeamStats);

        // Match 11 | FC Barcelona - OLYMPIACOS F.C. 6:1 | 21/10/2025
        TeamStats teamStats11211025 = new TeamStats("TS11211025",
                1, 0, 6, 4, 1, 0, 0, 1, 1);
        Match match11211025 = new Match("MA11211025",
                olympiacos, opponentRepository.findByOpponentName("FC Barcelona").orElseThrow(OpponentNotFoundException::new),
                1, 6,
                "21/10/2025", TUESDAY, championsLeague, AWAY,
                11, "Champions League League Phase MatchDay: 03", mendilibar, season2526, teamStats11211025);
        saveMatchAndUpdateTotalStats(match11211025, teamStats11211025, season2526TotalTeamStats);
    }

    private void saveMatchAndUpdateTotalStats(Match match, TeamStats teamStats, TeamStats teamTotals) {
        matchRepository.save(match);
        teamTotals.addStats(teamStats);
        teamStatsRepository.save(teamTotals);
    }
}
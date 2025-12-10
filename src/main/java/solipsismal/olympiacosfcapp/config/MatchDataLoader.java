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
    private final ITeamStatsRepository teamStatsRepository;

    public MatchDataLoader(MatchRepository matchRepository, OlympiacosRepository olympiacosRepository,
                           OpponentRepository opponentRepository, CompetitionRepository competitionRepository,
                           CoachRepository coachRepository, SeasonRepository seasonRepository, ITeamStatsRepository teamStatsRepository) {
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
        Competition superLeagueGreece = competitionRepository.findByCompetitionName("Greek Super League").orElseThrow();
        Competition championsLeague = competitionRepository.findByCompetitionName("UEFA Champions League").orElseThrow();
        Competition greekFootballCup = competitionRepository.findByCompetitionName("Greek Football Cup").orElseThrow();

        // Team and Season Stats
        TeamStats season2526TotalTeamStats = new TeamStats("TS20252026");
        teamStatsRepository.save(season2526TotalTeamStats);
        season2526.setTeamStats(season2526TotalTeamStats);
        seasonRepository.save(season2526);

        // Matches
        // Match 1 | OLYMPIACOS F.C. - Asteras 2:0 | 23/08/2025
        TeamStats teamStats01230825 = new TeamStats("TS01230825",
                2, 2, 0, 0, 0);
        Match match01230825 = new Match("MA01230825",
                olympiacos, opponentRepository.findByOpponentName("Asteras Tripolis").orElseThrow(OpponentNotFoundException::new),
                2, 0,
                "23/08/2025", "20:00", SATURDAY, superLeagueGreece, HOME,
                1, "Greek Super League Round 1, MatchDay: 01", mendilibar, season2526, teamStats01230825);
        saveMatchAndUpdateTotalStats(match01230825, teamStats01230825, season2526TotalTeamStats);

        // Match 2 | NFC Volos - OLYMPIACOS F.C. 0:2 | 30/08/2025
        TeamStats teamStats02300825 = new TeamStats("TS02300825",
                2, 2, 0, 0, 0);
        Match match02300825 = new Match("MA02300825",
                olympiacos, opponentRepository.findByOpponentName("NFC Volos").orElseThrow(OpponentNotFoundException::new),
                2, 0,
                "30/08/2025", "19:00", SATURDAY, superLeagueGreece, AWAY,
                2, "Greek Super League Round 1, MatchDay: 02", mendilibar, season2526, teamStats02300825);
        saveMatchAndUpdateTotalStats(match02300825, teamStats02300825, season2526TotalTeamStats);

        // Match 3 | OLYMPIACOS F.C. - Panserraikos FC 5:0 | 13/09/2025
        TeamStats teamStats03130925 = new TeamStats("TS03130925",
                5, 5, 0, 0, 0);
        Match match03130925 = new Match("MA03130925",
                olympiacos, opponentRepository.findByOpponentName("Panserraikos FC").orElseThrow(OpponentNotFoundException::new),
                5, 0,
                "13/09/2025", "18:00", SATURDAY, superLeagueGreece, HOME,
                3, "Greek Super League Round 1, MatchDay: 03", mendilibar, season2526, teamStats03130925);
        saveMatchAndUpdateTotalStats(match03130925, teamStats03130925, season2526TotalTeamStats);

        // Match 4 | OLYMPIACOS F.C. - Pafos FC 0:0 | 17/09/2025
        TeamStats teamStats04170925 = new TeamStats("TS04170925",
                0, 0, 0, 3, 0);
        Match match04170925 = new Match("MA04170925",
                olympiacos, opponentRepository.findByOpponentName("Pafos FC").orElseThrow(OpponentNotFoundException::new),
                0, 0,
                "17/09/2025", "19:45", WEDNESDAY, championsLeague, HOME,
                4, "UEFA Champions League League Phase, MatchDay: 01", mendilibar, season2526, teamStats04170925);
        saveMatchAndUpdateTotalStats(match04170925, teamStats04170925, season2526TotalTeamStats);

        // Match 5 | Panathinaikos FC - OLYMPIACOS F.C 1:1 | 21/09/2025
        TeamStats teamStats05210925 = new TeamStats("TS05210925",
                1, 1, 1, 4, 0);
        Match match05210925 = new Match("MA05210925",
                olympiacos, opponentRepository.findByOpponentName("Panathinaikos FC").orElseThrow(OpponentNotFoundException::new),
                1, 1,
                "21/09/2025","21:00", SUNDAY, superLeagueGreece, AWAY,
                5, "Greek Super League Round 1, MatchDay: 04", mendilibar, season2526, teamStats05210925);
        saveMatchAndUpdateTotalStats(match05210925, teamStats05210925, season2526TotalTeamStats);

        // Match 6 | Asteras Tripolis - OLYMPIACOS F.C. 1:2 | 24/09/2025
        TeamStats teamStats06240925 = new TeamStats("TS06240925",
                2, 0, 1, 5, 0);
        Match match06240925 = new Match("MA06240925",
                olympiacos, opponentRepository.findByOpponentName("Asteras Tripolis").orElseThrow(OpponentNotFoundException::new),
                2, 1,
                "24/09/2025", "17:00", WEDNESDAY, greekFootballCup, AWAY,
                6, "Greek Football Cup League Phase, MatchDay: 01", mendilibar, season2526,teamStats06240925);
        saveMatchAndUpdateTotalStats(match06240925, teamStats06240925, season2526TotalTeamStats);

        // Match 7 | OLYMPIACOS F.C. - Levadiakos FC 3:2 | 27/09/2025
        TeamStats teamStats07270925 = new TeamStats("TS07270925",
                3, 2, 2, 2, 0);
        Match match07270925 = new Match("MA07270925",
                olympiacos, opponentRepository.findByOpponentName("Levadiakos FC").orElseThrow(OpponentNotFoundException::new),
                3, 2,
                "27/09/2025", "18:00", SATURDAY, superLeagueGreece, HOME,
                7, "Greek Super League Round 1, MatchDay: 05", mendilibar, season2526,teamStats07270925);
        saveMatchAndUpdateTotalStats(match07270925, teamStats07270925, season2526TotalTeamStats);

        // Match 8 | Arsenal FC - OLYMPIACOS F.C. 2:0 | 01/10/2025
        TeamStats teamStats08011025 = new TeamStats("TS08011025",
                0, 0, 2, 2, 0);
        Match match08011025 = new Match("MA08011025",
                olympiacos, opponentRepository.findByOpponentName("Arsenal FC").orElseThrow(OpponentNotFoundException::new),
                0, 2,
                "01/10/2025", "22:00", WEDNESDAY, championsLeague, AWAY,
                8, "UEFA Champions League League Phase, MatchDay: 02", mendilibar, season2526, teamStats08011025);
        saveMatchAndUpdateTotalStats(match08011025, teamStats08011025, season2526TotalTeamStats);

        // Match 9 | PAOK FC - OLYMPIACOS F.C. 2:1 | 05/10/2025
        TeamStats teamStats09051025 = new TeamStats("TS09051025",
                1, 1, 2, 3, 0);
        Match match09051025 = new Match("MA09051025",
                olympiacos, opponentRepository.findByOpponentName("PAOK FC").orElseThrow(OpponentNotFoundException::new),
                1, 2,
                "05/10/2025", "20:30", SUNDAY, superLeagueGreece, AWAY,
                9, "Greek Super League Round 1, MatchDay: 06", mendilibar, season2526, teamStats09051025);
        saveMatchAndUpdateTotalStats(match09051025, teamStats09051025, season2526TotalTeamStats);

        // Match 10 | AE Larissa - OLYMPIACOS F.C. 0:2 | 18/10/2025
        TeamStats teamStats10181025 = new TeamStats("TS10181025",
                2, 1, 0, 1, 0);
        Match match10181025 = new Match("MA10181025",
                olympiacos, opponentRepository.findByOpponentName("AE Larissa").orElseThrow(OpponentNotFoundException::new),
                2, 0,
                "18/10/2025", "17:00", SATURDAY, superLeagueGreece, AWAY,
                10, "Greek Super League Round 1, MatchDay: 07", mendilibar, season2526, teamStats10181025);
        saveMatchAndUpdateTotalStats(match10181025, teamStats10181025, season2526TotalTeamStats);

        // Match 11 | FC Barcelona - OLYMPIACOS F.C. 6:1 | 21/10/2025
        TeamStats teamStats11211025 = new TeamStats("TS11211025",
                1, 0, 6, 4, 1);
        Match match11211025 = new Match("MA11211025",
                olympiacos, opponentRepository.findByOpponentName("FC Barcelona").orElseThrow(OpponentNotFoundException::new),
                1, 6,
                "21/10/2025", "19:45", TUESDAY, championsLeague, AWAY,
                11, "UEFA Champions League League Phase, MatchDay: 03", mendilibar, season2526, teamStats11211025);
        saveMatchAndUpdateTotalStats(match11211025, teamStats11211025, season2526TotalTeamStats);

        // Match 12 | OLYMPIACOS F.C. - AEK FC 2:0 | 26/10/2025
        TeamStats teamStats12261025 = new TeamStats("TS12261025",
                2, 1, 0, 3, 0);
        Match match12261025 = new Match("MA12261025",
                olympiacos, opponentRepository.findByOpponentName("AEK FC").orElseThrow(OpponentNotFoundException::new),
                2, 0,
                "26/10/2025", "21:00", SUNDAY, superLeagueGreece, HOME,
                12, "Greek Super League Round 1, MatchDay: 08", mendilibar, season2526, teamStats12261025);
        saveMatchAndUpdateTotalStats(match12261025, teamStats12261025, season2526TotalTeamStats);

        // Match 13 | OLYMPIACOS F.C. - NFC Volos 5:0 | 29/10/2025
        TeamStats teamStats13291025 = new TeamStats("TS13291025",
                5, 3, 0, 2, 0);
        Match match13291025 = new Match("MA13291025",
                olympiacos, opponentRepository.findByOpponentName("NFC Volos").orElseThrow(OpponentNotFoundException::new),
                5, 0,
                "29/10/2025", "17:30", WEDNESDAY, greekFootballCup, HOME,
                13, "Greek Football Cup League Phase, MatchDay: 02", mendilibar, season2526, teamStats13291025);
        saveMatchAndUpdateTotalStats(match13291025, teamStats13291025, season2526TotalTeamStats);

        // Match 14 | OLYMPIACOS F.C. - ARIS FC 2:1 | 01/11/2025
        TeamStats teamStats14011125 = new TeamStats("TS14011125",
                2, 1, 1, 2, 1);
        Match match14011125 = new Match("MA14011125",
                olympiacos, opponentRepository.findByOpponentName("ARIS FC").orElseThrow(OpponentNotFoundException::new),
                2, 1,
                "01/11/2025", "20:00", SATURDAY, superLeagueGreece, HOME,
        14, "Greek Super League Round 1, MatchDay: 09", mendilibar, season2526, teamStats14011125);
        saveMatchAndUpdateTotalStats(match14011125, teamStats14011125, season2526TotalTeamStats);

        // Match 15 | OLYMPIACOS F.C. - PSV Eindhoven 1:1 | 04/11/2025
        TeamStats teamStats15041125 = new TeamStats("TS15041125",
                1, 1, 1, 1, 0);
        Match match15041125 = new Match("MA15041125",
                olympiacos, opponentRepository.findByOpponentName("PSV Eindhoven").orElseThrow(OpponentNotFoundException::new),
                1, 1,
                "04/11/2025", "22:00", TUESDAY, championsLeague, HOME,
                15, "UEFA Champions League League Phase, MatchDay: 04", mendilibar, season2526, teamStats15041125);
        saveMatchAndUpdateTotalStats(match15041125, teamStats15041125, season2526TotalTeamStats);

        // Match 16 | Kifisia FC - OLYMPIACOS F.C. 1:3 | 09/11/2025
        TeamStats teamStats16091125 = new TeamStats("TS16091125",
                3, 1, 1, 1, 0);
        Match match16091125 = new Match("MA16091125",
                olympiacos, opponentRepository.findByOpponentName("Kifisia FC").orElseThrow(OpponentNotFoundException::new),
                3, 1,
                "09/11/2025", "15:00", SUNDAY, superLeagueGreece, AWAY,
                16, "Greek Super League Round 1, MatchDay: 10", mendilibar, season2526, teamStats16091125);
        saveMatchAndUpdateTotalStats(match16091125, teamStats16091125, season2526TotalTeamStats);

        // Match 17 | OLYMPIACOS F.C. - Atromitos FC 3:0 | 22/11/2025
        TeamStats teamStats17221125 = new TeamStats("TS17221125",
                3, 1, 0, 0, 0);
        Match match17221125 = new Match("MA17221125",
                olympiacos, opponentRepository.findByOpponentName("Atromitos FC").orElseThrow(OpponentNotFoundException::new),
                3,0,
                "22/11/2025", "20:00", SATURDAY, superLeagueGreece, HOME,
                17, "Greek Super League Round 1, MatchDay: 11", mendilibar, season2526, teamStats17221125);
        saveMatchAndUpdateTotalStats(match17221125, teamStats17221125, season2526TotalTeamStats);

        // Match 18 | OLYMPIACOS F.C. - Real Madrid CF 3:4 | 26/11/2025
        TeamStats teamStats18261125 = new TeamStats("TS18261125",
                3, 3, 4, 1, 0);
        Match match18261125 = new Match("MA18261125",
                olympiacos, opponentRepository.findByOpponentName("Real Madrid CF").orElseThrow(OpponentNotFoundException::new),
                3, 4,
                "26/11/2025", "22:00", WEDNESDAY, championsLeague, HOME,
                18, "UEFA Champions League League Phase, MatchDay: 05", mendilibar, season2526, teamStats18261125);
        saveMatchAndUpdateTotalStats(match18261125, teamStats18261125, season2526TotalTeamStats);

        // Match 19 | Panaitolikos FC  - OLYMPIACOS F.C. 0:1 | 30/11/2025
        TeamStats teamStats19301125 = new TeamStats("TS19301125",
                1, 1, 0, 0, 0);
        Match match19301125 = new Match("MA19301125",
                olympiacos, opponentRepository.findByOpponentName("Panaitolikos FC").orElseThrow(OpponentNotFoundException::new),
                1, 0,
                "30/11/2025", "17:00", SUNDAY, superLeagueGreece, AWAY,
                19, "Greek Super League Round 1, MatchDay: 12", mendilibar, season2526, teamStats19301125);
        saveMatchAndUpdateTotalStats(match19301125, teamStats19301125, season2526TotalTeamStats);

        // Match 20 | APO Ellas Syrou  - OLYMPIACOS F.C. 2:5 | 03/12/2025
        TeamStats teamStats20031225 = new TeamStats("TS20031225",
                5, 5, 2, 1, 0);
        Match match20031225 = new Match("MA20031225",
                olympiacos, opponentRepository.findByOpponentName("APO Ellas Syrou").orElseThrow(OpponentNotFoundException::new),
                5, 2,
                "03/12/2025", "13:30", WEDNESDAY, greekFootballCup, AWAY,
                20, "Greek Football Cup League Phase, MatchDay: 03", mendilibar, season2526, teamStats20031225);
        saveMatchAndUpdateTotalStats(match20031225, teamStats20031225, season2526TotalTeamStats);

        // Match 21 | OLYMPIACOS F.C. - OFI Crete FC 3:0 | 06/12/2025
        TeamStats teamStats21061225 = new TeamStats("TS21061225",
                3, 2, 0, 0, 0);
        Match match21061225 = new Match("MA21061225",
                olympiacos, opponentRepository.findByOpponentName("OFI Crete FC").orElseThrow(OpponentNotFoundException::new),
                3, 0,
                "06/12/2025", "17:00", SATURDAY, superLeagueGreece, HOME,
                21, "Greek Super League Round 1, MatchDay: 13", mendilibar, season2526, teamStats21061225);
        saveMatchAndUpdateTotalStats(match21061225, teamStats21061225, season2526TotalTeamStats);

        // Match 22 | FC Kairat Almaty - OLYMPIACOS F.C. 0:1 | 09/12/2025
        TeamStats teamStats22091225 = new TeamStats("TS22091225",
                1, 1, 0, 2, 0);
        Match match22091225 = new Match("MA22091225",
                olympiacos, opponentRepository.findByOpponentName("FC Kairat Almaty").orElseThrow(OpponentNotFoundException::new),
                1, 0,
                "09/12/2025", "17:30", TUESDAY, championsLeague, AWAY,
                22, "UEFA Champions League League Phase, MatchDay: 06", mendilibar, season2526, teamStats22091225);
        saveMatchAndUpdateTotalStats(match22091225, teamStats22091225, season2526TotalTeamStats);

        // Match 23 | ARIS FC - OLYMPIACOS F.C. -:- | 14/12/2025
        TeamStats teamStats23141225 = new TeamStats("TS23141225");
        Match match23141225 = new Match("MA23141225",
                olympiacos, opponentRepository.findByOpponentName("ARIS FC").orElseThrow(OpponentNotFoundException::new),
                "14/12/2025", "20:00", SUNDAY, superLeagueGreece, AWAY,
                23, "Greek Super League Round 2, MatchDay: 14", mendilibar, season2526, teamStats23141225);
        matchRepository.save(match23141225);

        // Competition Position Setter
        competitionRepository.save(superLeagueGreece.setCompetitionPosition(1));
        competitionRepository.save(championsLeague.setCompetitionPosition(33));
        competitionRepository.save(greekFootballCup.setCompetitionPosition(1));
    }

    private void saveMatchAndUpdateTotalStats(Match match, TeamStats teamStats, TeamStats teamTotals) {
        matchRepository.save(match);
        teamTotals.addStats(teamStats);
        teamStatsRepository.save(teamTotals);
        addPoints(match);
    }

    private void addPoints(Match match) {
        if (match.getOlympiacosGoals() > match.getOpponentGoals()) {
            match.getCompetition().add3();
        } else if (match.getOlympiacosGoals().equals(match.getOpponentGoals())){
            match.getCompetition().add1();
        }
        competitionRepository.save(match.getCompetition());
    }
}
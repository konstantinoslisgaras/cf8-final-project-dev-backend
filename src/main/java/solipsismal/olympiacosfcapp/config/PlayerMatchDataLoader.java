package solipsismal.olympiacosfcapp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import solipsismal.olympiacosfcapp.core.enums.Result;
import solipsismal.olympiacosfcapp.core.exceptions.PlayerNotFoundException;
import solipsismal.olympiacosfcapp.model.Match;
import solipsismal.olympiacosfcapp.model.Player;
import solipsismal.olympiacosfcapp.model.PlayerMatch;
import solipsismal.olympiacosfcapp.model.PlayerStats;
import static solipsismal.olympiacosfcapp.core.enums.Result.*;
import solipsismal.olympiacosfcapp.repository.MatchRepository;
import solipsismal.olympiacosfcapp.repository.PlayerMatchRepository;
import solipsismal.olympiacosfcapp.repository.PlayerRepository;
import solipsismal.olympiacosfcapp.repository.PlayerStatsRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Order(8)
public class PlayerMatchDataLoader implements CommandLineRunner {

    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;
    private final PlayerMatchRepository playerMatchRepository;
    private final PlayerStatsRepository playerStatsRepository;

    public PlayerMatchDataLoader(PlayerRepository playerRepository, MatchRepository matchRepository,
                                 PlayerMatchRepository playerMatchRepository, PlayerStatsRepository playerStatsRepository) {
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
        this.playerMatchRepository = playerMatchRepository;
        this.playerStatsRepository = playerStatsRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws PlayerNotFoundException {
        // Players
        Map<String, Player> players = getPlayersByLastnames(
                "Tzolakis", "Paschalakis", "Botis",
                "Rodinei", "Costinha", "Retsos", "Mancha", "Biancone", "Kalogeropoulos", "Pirola", "Vezo", "Ortega", "Onyemaechi",
                "Hezze", "Liatsikouras", "Garcia", "Mouzakitis", "Nascimento", "Scipioni", "Yazici", "Cabella", "Chiquinho",
                "Martins", "Strefezza", "Podence", "Pnevmonidis", "El Kaabi", "Taremi", "Yaremchuk"
        );

        // Players Matches
        // Match 1 | OLYMPIACOS F.C. - Asteras 2:0 | 23/08/2025
        Match match01230825 = matchRepository.findById("MA01230825").orElseThrow();
        List<PlayerMatch> playerMatches01230825 = List.of(
                new PlayerMatch("PM01390394", players.get("Tzolakis"), match01230825,
                        0, 0, 0, 0,99),
                new PlayerMatch("PM02958419", players.get("Costinha"), match01230825,
                        0, 0, 0, 0, 64),
                new PlayerMatch("PM03045783", players.get("Retsos"), match01230825,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM04428524", players.get("Pirola"), match01230825,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM05763492", players.get("Ortega"), match01230825,
                        0, 0, 0, 0, 83),
                new PlayerMatch("PM06942204", players.get("Garcia"), match01230825,
                        0, 0, 0, 0, 64),
                new PlayerMatch("PM07289562", players.get("Hezze"), match01230825,
                        0, 0, 0, 0, 76),
                new PlayerMatch("PM08509341", players.get("Rodinei"), match01230825,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM09531100", players.get("Chiquinho"), match01230825,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM10153752", players.get("Pnevmonidis"), match01230825,
                        0, 0, 0, 0, 83),
                new PlayerMatch("PM11959486", players.get("El Kaabi"), match01230825,
                        1, 0, 0, 0, 99),
                new PlayerMatch("PM12209562", players.get("Mouzakitis"), match01230825,
                        0, 1, 0, 0, 35),
                new PlayerMatch("PM13424960", players.get("Martins"), match01230825,
                        0, 0, 0, 0, 35),
                new PlayerMatch("PM14895463", players.get("Nascimento"), match01230825,
                        0, 1, 0, 0, 23),
                new PlayerMatch("PM15086431", players.get("Yazici"), match01230825,
                        1, 0, 0, 0, 16),
                new PlayerMatch("PM16094231", players.get("Onyemaechi"), match01230825,
                        0, 0, 0, 0, 16)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches01230825, WIN);

        // Match 2 | NFC Volos - OLYMPIACOS F.C. 0:2 | 30/08/2025
        Match match02300825 = matchRepository.findById("MA02300825").orElseThrow();
        List<PlayerMatch> playerMatches02300825 = List.of(
                new PlayerMatch("PM01560394", players.get("Tzolakis"), match02300825,
                        0, 0, 0, 0, 98),
                new PlayerMatch("PM02428419", players.get("Rodinei"), match02300825,
                        0, 0, 0, 0, 98),
                new PlayerMatch("PM03054783", players.get("Retsos"), match02300825,
                        1, 0, 0, 0, 98),
                new PlayerMatch("PM04428574", players.get("Pirola"), match02300825,
                        0, 0, 0, 0, 98),
                new PlayerMatch("PM05443492", players.get("Ortega"), match02300825,
                        0, 0, 0, 0, 98),
                new PlayerMatch("PM06142204", players.get("Nascimento"), match02300825,
                        0, 0, 0, 0, 91),
                new PlayerMatch("PM07250562", players.get("Garcia"), match02300825,
                        0, 0, 0, 0, 67),
                new PlayerMatch("PM08500341", players.get("Martins"), match02300825,
                        0, 0, 0, 0, 80),
                new PlayerMatch("PM09538676", players.get("Chiquinho"), match02300825,
                        1, 1, 0, 0, 92),
                new PlayerMatch("PM10653752", players.get("Pnevmonidis"), match02300825,
                        0, 0, 0, 0, 68),
                new PlayerMatch("PM11759486", players.get("El Kaabi"), match02300825,
                        0, 0, 0, 0, 98),
                new PlayerMatch("PM12202762", players.get("Hezze"), match02300825,
                        0, 0, 0, 0, 31),
                new PlayerMatch("PM13421160", players.get("Strefezza"), match02300825,
                        0, 1, 0, 0, 30),
                new PlayerMatch("PM14995463", players.get("Yazici"), match02300825,
                        0, 0, 0, 0, 18),
                new PlayerMatch("PM15084231", players.get("Scipioni"), match02300825,
                        0, 0, 0, 0, 7),
                new PlayerMatch("PM16779045", players.get("Cabella"), match02300825,
                        0, 0, 0, 0, 6)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches02300825, WIN);

        // Match 3 | OLYMPIACOS F.C. - Panserraikos FC 5:0 | 13/09/2025
        Match match03130925 = matchRepository.findById("MA03130925").orElseThrow();
        List<PlayerMatch> playerMatches03130925 = List.of(
                new PlayerMatch("PM01505294", players.get("Tzolakis"), match03130925,
                        0, 0, 0, 0, 97),
                new PlayerMatch("PM02528419", players.get("Costinha"), match03130925,
                        0, 0, 0, 0, 97),
                new PlayerMatch("PM03054921", players.get("Retsos"), match03130925,
                        0, 0, 0, 0, 97),
                new PlayerMatch("PM04428552", players.get("Biancone"), match03130925,
                        0, 0, 0, 0, 97),
                new PlayerMatch("PM05439692", players.get("Ortega"), match03130925,
                        1, 1, 0, 0, 97),
                new PlayerMatch("PM06737104", players.get("Hezze"), match03130925,
                        0, 0, 0, 0, 79),
                new PlayerMatch("PM07289762", players.get("Mouzakitis"), match03130925,
                        0, 0, 0, 0, 97),
                new PlayerMatch("PM08111341", players.get("Martins"), match03130925,
                        0, 0, 0, 0, 18),
                new PlayerMatch("PM09890113", players.get("Chiquinho"), match03130925,
                        0, 1, 0, 0, 79),
                new PlayerMatch("PM10597252", players.get("Cabella"), match03130925,
                        0, 1, 0, 0, 72),
                new PlayerMatch("PM11109086", players.get("El Kaabi"), match03130925,
                        1, 0, 0, 0, 73),
                new PlayerMatch("PM12428460", players.get("Strefezza"), match03130925,
                        0, 0, 0, 0, 79),
                new PlayerMatch("PM13201562", players.get("Podence"), match03130925,
                        1, 1, 0, 0, 25),
                new PlayerMatch("PM14992163", players.get("Taremi"), match03130925,
                        2, 0, 0, 0, 24),
                new PlayerMatch("PM15094231", players.get("Yazici"), match03130925,
                        0, 1, 0, 0, 18),
                new PlayerMatch("PM16369045", players.get("Scipioni"), match03130925,
                        0, 0, 0, 0, 18)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches03130925, WIN);

        // Match 4 | OLYMPIACOS F.C. - Pafos FC 0:0 | 17/09/2025
        Match match04170925 = matchRepository.findById("MA04170925").orElseThrow();
        List<PlayerMatch> playerMatches04170925 = List.of(
                new PlayerMatch("PM01509424", players.get("Paschalakis"), match04170925,
                        0, 0, 0, 0, 100),
                new PlayerMatch("PM02556249", players.get("Rodinei"), match04170925,
                        0, 0, 0, 0, 65),
                new PlayerMatch("PM03056001", players.get("Retsos"), match04170925,
                        0, 0, 0, 0, 100),
                new PlayerMatch("PM04425932", players.get("Pirola"), match04170925,
                        0, 0, 1, 0, 80),
                new PlayerMatch("PM05239692", players.get("Ortega"), match04170925,
                        0, 0, 0, 0, 100),
                new PlayerMatch("PM06222204", players.get("Hezze"), match04170925,
                        0, 0, 0, 0, 79),
                new PlayerMatch("PM07189762", players.get("Garcia"), match04170925,
                        0, 0, 1, 0, 49),
                new PlayerMatch("PM08599341", players.get("Strefezza"), match04170925,
                        0, 0, 0, 0, 49),
                new PlayerMatch("PM09536826", players.get("Chiquinho"), match04170925,
                        0, 0, 0, 0, 100),
                new PlayerMatch("PM10597322", players.get("Podence"), match04170925,
                        0, 0, 0, 0, 100),
                new PlayerMatch("PM11109896", players.get("El Kaabi"), match04170925,
                        0, 0, 0, 0, 100),
                new PlayerMatch("PM12025460", players.get("Mouzakitis"), match04170925,
                        0, 0, 0, 0, 51),
                new PlayerMatch("PM13339562", players.get("Taremi"), match04170925,
                        0, 0, 1, 0, 51),
                new PlayerMatch("PM14742163", players.get("Costinha"), match04170925,
                        0, 0, 0, 0, 35),
                new PlayerMatch("PM15194231", players.get("Pnevmonidis"), match04170925,
                        0, 0, 0, 0, 31),
                new PlayerMatch("PM16269045", players.get("Biancone"), match04170925,
                        0, 0, 0, 0, 20)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches04170925, DRAW);

        // Match 5 | Panathinaikos FC - OLYMPIACOS F.C. 1:1 | 21/09/2025
        Match match05210925 = matchRepository.findById("MA05210925").orElseThrow();
        List<PlayerMatch> playerMatches05210925 = List.of(
                new PlayerMatch("PM01509222", players.get("Tzolakis"), match05210925,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM02559750", players.get("Costinha"), match05210925,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM03051624", players.get("Retsos"), match05210925,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM04592932", players.get("Pirola"), match05210925,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM05255692", players.get("Ortega"), match05210925,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM06050204", players.get("Scipioni"), match05210925,
                        0, 0, 1, 0, 70),
                new PlayerMatch("PM07112762", players.get("Mouzakitis"), match05210925,
                        0, 0, 0, 0, 82),
                new PlayerMatch("PM08063341", players.get("Strefezza"), match05210925,
                        0, 0, 1, 0, 70),
                new PlayerMatch("PM09537926", players.get("Nascimento"), match05210925,
                        0, 0, 0, 0, 59),
                new PlayerMatch("PM10530922", players.get("Cabella"), match05210925,
                        0, 0, 1, 0, 82),
                new PlayerMatch("PM11093467", players.get("El Kaabi"), match05210925,
                        1, 0, 1, 0, 99),
                new PlayerMatch("PM12525460", players.get("Podence"), match05210925,
                        0, 0, 0, 0, 40),
                new PlayerMatch("PM13191562", players.get("Chiquinho"), match05210925,
                        0, 0, 0, 0, 29),
                new PlayerMatch("PM14746113", players.get("Yazici"), match05210925,
                        0, 0, 0, 0, 29),
                new PlayerMatch("PM15124900", players.get("Hezze"), match05210925,
                        0, 0, 0, 0, 17),
                new PlayerMatch("PM16963045", players.get("Taremi"), match05210925,
                        0, 1, 0, 0, 17)
        );
        setGKGoalsConceded(playerMatches05210925, players.get("Tzolakis"), 1);
        savePlayerMatchesAndUpdateTotalStats(playerMatches05210925, DRAW);

        // Match 6 | Asteras Tripolis - OLYMPIACOS F.C. 1:2 | 24/09/2025
        Match match06240925 = matchRepository.findById("MA06240925").orElseThrow();
        List<PlayerMatch> playerMatches06240925 = List.of(
                new PlayerMatch("PM01009222", players.get("Paschalakis"), match06240925,
                        0, 0, 0, 0, 94),
                new PlayerMatch("PM02882750", players.get("Kalogeropoulos"), match06240925,
                        0, 0, 0, 0, 65),
                new PlayerMatch("PM03953624", players.get("Biancone"), match06240925,
                        0, 0, 1, 0, 94),
                new PlayerMatch("PM04773932", players.get("Mancha"), match06240925,
                        0, 0, 1, 0, 94),
                new PlayerMatch("PM05409692", players.get("Onyemaechi"), match06240925,
                        0, 0, 1, 0, 94),
                new PlayerMatch("PM06050402", players.get("Garcia"), match06240925,
                        0, 0, 1, 0, 77),
                new PlayerMatch("PM07112336", players.get("Nascimento"), match06240925,
                        0, 0, 0, 0, 65),
                new PlayerMatch("PM08063413", players.get("Cabella"), match06240925,
                        0, 0, 0, 0, 65),
                new PlayerMatch("PM09537629", players.get("Yazici"), match06240925,
                        0, 0, 0, 0, 77),
                new PlayerMatch("PM10593222", players.get("Pnevmonidis"), match06240925,
                        0, 0, 0, 0, 94),
                new PlayerMatch("PM11170396", players.get("Taremi"), match06240925,
                        2, 0, 0, 0, 94),
                new PlayerMatch("PM12507360", players.get("Costinha"), match06240925,
                        0, 0, 0, 0, 29),
                new PlayerMatch("PM13132362", players.get("Hezze"), match06240925,
                        0, 0, 0, 0, 29),
                new PlayerMatch("PM14641113", players.get("Podence"), match06240925,
                        0, 0, 1, 0, 29),
                new PlayerMatch("PM15124931", players.get("Liatsikouras"), match06240925,
                        0, 0, 0, 0, 17),
                new PlayerMatch("PM16063045", players.get("El Kaabi"), match06240925,
                        0, 0, 0, 0, 17)
        );
        setGKGoalsConceded(playerMatches06240925, players.get("Paschalakis"), 1);
        savePlayerMatchesAndUpdateTotalStats(playerMatches06240925, WIN);

        // Match 7 | OLYMPIACOS F.C. - Levadiakos FC 3:2 | 27/09/2025
        Match match07270925 = matchRepository.findById("MA07270925").orElseThrow();
        List<PlayerMatch> playerMatches07270925 = List.of(
                new PlayerMatch("PM01003212", players.get("Tzolakis"), match07270925,
                        0, 0, 0, 0, 113),
                new PlayerMatch("PM02922750", players.get("Costinha"), match07270925,
                        0, 0, 0, 0, 81),
                new PlayerMatch("PM03953600", players.get("Retsos"), match07270925,
                        1, 0, 0, 0, 113),
                new PlayerMatch("PM04073932", players.get("Pirola"), match07270925,
                        0, 0, 0, 0, 113),
                new PlayerMatch("PM05409132", players.get("Ortega"), match07270925,
                        0, 0, 1, 0, 113),
                new PlayerMatch("PM06157412", players.get("Mouzakitis"), match07270925,
                        0, 1, 0, 0, 70),
                new PlayerMatch("PM07992336", players.get("Hezze"), match07270925,
                        0, 0, 1, 0, 113),
                new PlayerMatch("PM08993413", players.get("Strefezza"), match07270925,
                        0, 0, 0, 0, 70),
                new PlayerMatch("PM09837629", players.get("Chiquinho"), match07270925,
                        2, 0, 0, 0, 113),
                new PlayerMatch("PM10393182", players.get("Podence"), match07270925,
                        0, 0, 0, 0, 80),
                new PlayerMatch("PM11170746", players.get("El Kaabi"), match07270925,
                        0, 0, 0, 0, 109),
                new PlayerMatch("PM12507630", players.get("Garcia"), match07270925,
                        0, 1, 0, 0, 42),
                new PlayerMatch("PM13142362", players.get("Martins"), match07270925,
                        0, 0, 0, 0, 42),
                new PlayerMatch("PM13791113", players.get("Cabella"), match07270925,
                        0, 0, 0, 0, 32),
                new PlayerMatch("PM15841931", players.get("Rodinei"), match07270925,
                        0, 0, 0, 0, 31),
                new PlayerMatch("PM16064375", players.get("Taremi"), match07270925,
                        0, 0, 0, 0, 4)
        );
        setGKGoalsConceded(playerMatches07270925, players.get("Tzolakis"), 2);
        savePlayerMatchesAndUpdateTotalStats(playerMatches07270925, WIN);

        // Match 8 | Arsenal FC - OLYMPIACOS F.C. 2:0 | 01/10/2025
        Match match08011025 = matchRepository.findById("MA08011025").orElseThrow();
        List<PlayerMatch> playerMatches08011025 = List.of(
                new PlayerMatch("PM01821712", players.get("Tzolakis"), match08011025,
                        0, 0, 0, 0, 97),
                new PlayerMatch("PM02922571", players.get("Costinha"), match08011025,
                        0, 0, 0, 0, 97),
                new PlayerMatch("PM03953446", players.get("Retsos"), match08011025,
                        0, 0, 0, 0, 88),
                new PlayerMatch("PM04099912", players.get("Pirola"), match08011025,
                        0, 0, 0, 0, 97),
                new PlayerMatch("PM05409302", players.get("Ortega"), match08011025,
                        0, 0, 0, 0, 97),
                new PlayerMatch("PM06157507", players.get("Hezze"), match08011025,
                        0, 0, 0, 0, 88),
                new PlayerMatch("PM07992991", players.get("Garcia"), match08011025,
                        0, 0, 0, 0, 77),
                new PlayerMatch("PM08063651", players.get("Martins"), match08011025,
                        0, 0, 0, 0, 64),
                new PlayerMatch("PM09537020", players.get("Chiquinho"), match08011025,
                        0, 0, 0, 0, 88),
                new PlayerMatch("PM10393288", players.get("Podence"), match08011025,
                        0, 0, 0, 0, 97),
                new PlayerMatch("PM11170177", players.get("El Kaabi"), match08011025,
                        0, 0, 0, 0, 97),
                new PlayerMatch("PM12507002", players.get("Taremi"), match08011025,
                        0, 0, 0, 0, 33),
                new PlayerMatch("PM13142452", players.get("Scipioni"), match08011025,
                        0, 0, 0, 0, 30),
                new PlayerMatch("PM14641009", players.get("Biancone"), match08011025,
                        0, 0, 0, 0, 19),
                new PlayerMatch("PM15124991", players.get("Strefezza"), match08011025,
                        0, 0, 0, 0, 19),
                new PlayerMatch("PM16264375", players.get("Mouzakitis"), match08011025,
                        0, 0, 0, 0, 19)
        );
        setGKGoalsConceded(playerMatches08011025, players.get("Tzolakis"), 2);
        savePlayerMatchesAndUpdateTotalStats(playerMatches08011025, LOSS);

        // Match 9 | PAOK FC - OLYMPIACOS F.C. 2:1 | 05/10/2025
        Match match09051025 = matchRepository.findById("MA09051025").orElseThrow();
        List<PlayerMatch> playerMatches09051025 = List.of(
                new PlayerMatch("PM01883212", players.get("Tzolakis"), match09051025,
                        0, 0, 0, 0, 95),
                new PlayerMatch("PM02982571", players.get("Costinha"), match09051025,
                        0, 0, 1, 0, 87),
                new PlayerMatch("PM03907315", players.get("Biancone"), match09051025,
                        0, 0, 1, 0, 95),
                new PlayerMatch("PM04073112", players.get("Pirola"), match09051025,
                        0, 0, 0, 0, 95),
                new PlayerMatch("PM05093005", players.get("Ortega"), match09051025,
                        0, 0, 0, 0, 95),
                new PlayerMatch("PM06446195", players.get("Hezze"), match09051025,
                        0, 0, 0, 0, 95),
                new PlayerMatch("PM07192991", players.get("Garcia"), match09051025,
                        0, 0, 0, 0, 74),
                new PlayerMatch("PM08883451", players.get("Martins"), match09051025,
                        0, 0, 0, 0, 79),
                new PlayerMatch("PM09539080", players.get("Chiquinho"), match09051025,
                        1, 0, 0, 0, 95),
                new PlayerMatch("PM10693288", players.get("Podence"), match09051025,
                        0, 0, 1, 0, 95),
                new PlayerMatch("PM11370177", players.get("El Kaabi"), match09051025,
                        0, 1, 0, 0, 95),
                new PlayerMatch("PM12599992", players.get("Mouzakitis"), match09051025,
                        0, 0, 0, 0, 21),
                new PlayerMatch("PM13131452", players.get("Taremi"), match09051025,
                        0, 0, 0, 0, 16),
                new PlayerMatch("PM14640509", players.get("Yazici"), match09051025,
                        0, 0, 0, 0, 8)
        );
        setGKGoalsConceded(playerMatches09051025, players.get("Tzolakis"), 2);
        savePlayerMatchesAndUpdateTotalStats(playerMatches09051025, LOSS);

        // Match 10 | AE Larissa - OLYMPIACOS F.C. 0:2 | 18/10/2025
        Match match10181025 = matchRepository.findById("MA10181025").orElseThrow();
        List<PlayerMatch> playerMatches10181025 = List.of(
                new PlayerMatch("PM01805212", players.get("Tzolakis"), match10181025,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM02982339", players.get("Costinha"), match10181025,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM03551396", players.get("Retsos"), match10181025,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM04586731", players.get("Mancha"), match10181025,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM05586711", players.get("Ortega"), match10181025,
                        0, 1, 0, 0, 62),
                new PlayerMatch("PM06110507", players.get("Scipioni"), match10181025,
                        0, 0, 1, 0, 68),
                new PlayerMatch("PM07192321", players.get("Hezze"), match10181025,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM08003651", players.get("Yazici"), match10181025,
                        0, 0, 0, 0, 61),
                new PlayerMatch("PM09547020", players.get("Chiquinho"), match10181025,
                        0, 0, 0, 0, 76),
                new PlayerMatch("PM10693299", players.get("Podence"), match10181025,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM11373147", players.get("El Kaabi"), match10181025,
                        2, 0, 0, 0, 75),
                new PlayerMatch("PM12551102", players.get("Cabella"), match10181025,
                        0, 0, 0, 0, 38),
                new PlayerMatch("PM13191433", players.get("Onyemaechi"), match10181025,
                        0, 0, 0, 0, 37),
                new PlayerMatch("PM14689509", players.get("Mouzakitis"), match10181025,
                        0, 0, 0, 0, 31),
                new PlayerMatch("PM15892345", players.get("Yaremchuk"), match10181025,
                        0, 0, 0, 0, 24),
                new PlayerMatch("PM16745362", players.get("Nascimento"), match10181025,
                        0, 0, 0, 0, 23)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches10181025, WIN);

        // Match 11 | FC Barcelona - OLYMPIACOS F.C. 6:1 | 21/10/2025
        Match match11211025 = matchRepository.findById("MA11211025").orElseThrow();
        List<PlayerMatch> playerMatches11211025 = List.of(
                new PlayerMatch("PM01505212", players.get("Tzolakis"), match11211025,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM02732339", players.get("Costinha"), match11211025,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM03598296", players.get("Retsos"), match11211025,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM04558212", players.get("Pirola"), match11211025,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM05591202", players.get("Ortega"), match11211025,
                        0, 0, 0, 0, 55),
                new PlayerMatch("PM06598607", players.get("Garcia"), match11211025,
                        0, 0, 1, 0, 96),
                new PlayerMatch("PM07192421", players.get("Hezze"), match11211025,
                        0, 0, 2, 1, 59),
                new PlayerMatch("PM08903651", players.get("Martins"), match11211025,
                        0, 0, 0, 0, 47),
                new PlayerMatch("PM09983100", players.get("Chiquinho"), match11211025,
                        0, 0, 0, 0, 31),
                new PlayerMatch("PM10598939", players.get("Podence"), match11211025,
                        0, 0, 1, 0, 80),
                new PlayerMatch("PM11879521", players.get("El Kaabi"), match11211025,
                        1, 0, 0, 0, 80),
                new PlayerMatch("PM12251102", players.get("Nascimento"), match11211025,
                        0, 0, 0, 0, 65),
                new PlayerMatch("PM13851433", players.get("Mouzakitis"), match11211025,
                        0, 0, 0, 0, 49),
                new PlayerMatch("PM14189509", players.get("Onyemaechi"), match11211025,
                        0, 0, 0, 0, 41),
                new PlayerMatch("PM15094311", players.get("Yaremchuk"), match11211025,
                        0, 0, 0, 0, 16),
                new PlayerMatch("PM16705362", players.get("Taremi"), match11211025,
                        0, 0, 0, 0, 16)
        );
        setGKGoalsConceded(playerMatches11211025, players.get("Tzolakis"), 6);
        savePlayerMatchesAndUpdateTotalStats(playerMatches11211025, LOSS);

        // Match 12 | OLYMPIACOS F.C. - AEK FC 2:0 | 26/10/2025
        Match match12261025 = matchRepository.findById("MA12261025").orElseThrow();
        List<PlayerMatch> playerMatches12261025 = List.of(
                new PlayerMatch("PM01505092", players.get("Tzolakis"), match12261025,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM02742139", players.get("Costinha"), match12261025,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM03493355", players.get("Retsos"), match12261025,
                        0, 0, 1, 0, 96),
                new PlayerMatch("PM04258212", players.get("Pirola"), match12261025,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM05591092", players.get("Onyemaechi"), match12261025,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM06597307", players.get("Hezze"), match12261025,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM07195521", players.get("Garcia"), match12261025,
                        0, 0, 1, 0, 71),
                new PlayerMatch("PM08393651", players.get("Cabella"), match12261025,
                        0, 0, 0, 0, 65),
                new PlayerMatch("PM09047020", players.get("Taremi"), match12261025,
                        1, 0, 0, 0, 71),
                new PlayerMatch("PM10694409", players.get("Podence"), match12261025,
                        0, 1, 1, 0, 85),
                new PlayerMatch("PM11926447", players.get("El Kaabi"), match12261025,
                        1, 0, 0, 0, 86),
                new PlayerMatch("PM12341102", players.get("Chiquinho"), match12261025,
                        0, 0, 0, 0, 31),
                new PlayerMatch("PM13091433", players.get("Rodinei"), match12261025,
                        0, 0, 0, 0, 25),
                new PlayerMatch("PM14181029", players.get("Scipioni"), match12261025,
                        0, 0, 0, 0, 25),
                new PlayerMatch("PM15894395", players.get("Strefezza"), match12261025,
                        0, 0, 0, 0, 11),
                new PlayerMatch("PM16702942", players.get("Yaremchuk"), match12261025,
                        0, 0, 0, 0, 10)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches12261025, WIN);

        // Match 13 | OLYMPIACOS F.C. - NFC Volos 5:0 | 29/10/2025
        Match match13291025 = matchRepository.findById("MA13291025").orElseThrow();
        List<PlayerMatch> playerMatches13291025 = List.of(
                new PlayerMatch("PM01009482", players.get("Paschalakis"), match13291025,
                        0, 0, 0, 0, 95),
                new PlayerMatch("PM02950769", players.get("Kalogeropoulos"), match13291025,
                        0, 0, 0, 0, 73),
                new PlayerMatch("PM03406505", players.get("Biancone"), match13291025,
                        2, 0, 1, 0, 95),
                new PlayerMatch("PM04773129", players.get("Mancha"), match13291025,
                        0, 0, 0, 0, 95),
                new PlayerMatch("PM05292410", players.get("Vezo"), match13291025,
                        0, 0, 0, 0, 73),
                new PlayerMatch("PM06050317", players.get("Mouzakitis"), match13291025,
                        0, 0, 0, 0, 61),
                new PlayerMatch("PM07112378", players.get("Scipioni"), match13291025,
                        0, 0, 1, 0, 95),
                new PlayerMatch("PM08194413", players.get("Strefezza"), match13291025,
                        0, 2, 0, 0, 74),
                new PlayerMatch("PM09544629", players.get("Nascimento"), match13291025,
                        0, 0, 0, 0, 95),
                new PlayerMatch("PM10518602", players.get("Yazici"), match13291025,
                        1, 1, 0, 0, 95),
                new PlayerMatch("PM11270396", players.get("Yaremchuk"), match13291025,
                        2, 0, 0, 0, 61),
                new PlayerMatch("PM12547360", players.get("Liatsikouras"), match13291025,
                        0, 0, 0, 0, 34),
                new PlayerMatch("PM13902362", players.get("Pnevmonidis"), match13291025,
                        0, 0, 0, 0, 34),
                new PlayerMatch("PM14624113", players.get("Onyemaechi"), match13291025,
                        0, 0, 0, 0, 22),
                new PlayerMatch("PM15125531", players.get("Rodinei"), match13291025,
                        0, 0, 0, 0, 22),
                new PlayerMatch("PM16060045", players.get("Cabella"), match13291025,
                        0, 0, 0, 0, 21)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches13291025, WIN);

        // Match 14 | OLYMPIACOS F.C. - ARIS FC 2:1 | 01/11/2025
        Match match14011125 = matchRepository.findById("MA14011125").orElseThrow();
        List<PlayerMatch> playerMatches14011125 = List.of(
                new PlayerMatch("PM01052412", players.get("Tzolakis"), match14011125,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM02712439", players.get("Costinha"), match14011125,
                        0, 0, 0, 0, 70),
                new PlayerMatch("PM03435122", players.get("Retsos"), match14011125,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM04980415", players.get("Mancha"), match14011125,
                        0, 0, 0, 1, 74),
                new PlayerMatch("PM05601202", players.get("Onyemaechi"), match14011125,
                        0, 0, 1, 0, 99),
                new PlayerMatch("PM06398607", players.get("Garcia"), match14011125,
                        0, 0, 0, 0, 70),
                new PlayerMatch("PM07179851", players.get("Mouzakitis"), match14011125,
                        0, 0, 1, 0, 93),
                new PlayerMatch("PM08903541", players.get("Chiquinho"), match14011125,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM09541120", players.get("Taremi"), match14011125,
                        1, 0, 0, 0, 78),
                new PlayerMatch("PM10663299", players.get("Podence"), match14011125,
                        1, 1, 0, 0, 78),
                new PlayerMatch("PM11373002", players.get("El Kaabi"), match14011125,
                        0, 0, 0, 0, 99),
                new PlayerMatch("PM12251402", players.get("Rodinei"), match14011125,
                        0, 0, 0, 0, 29),
                new PlayerMatch("PM13251433", players.get("Scipioni"), match14011125,
                        0, 0, 0, 0, 29),
                new PlayerMatch("PM14989509", players.get("Pirola"), match14011125,
                        0, 0, 0, 0, 21),
                new PlayerMatch("PM15000247", players.get("Martins"), match14011125,
                        0, 0, 0, 0, 21),
                new PlayerMatch("PM16903262", players.get("Nascimento"), match14011125,
                        0, 0, 0, 0, 6)
        );
        setGKGoalsConceded(playerMatches14011125, players.get("Tzolakis"), 1);
        savePlayerMatchesAndUpdateTotalStats(playerMatches14011125, WIN);

        // Match 15 | OLYMPIACOS F.C. - PSV Eindhoven 1:1 | 04/11/2025
        Match match15041125 = matchRepository.findById("MA15041125").orElseThrow();
        List<PlayerMatch> playerMatches15041125 = List.of(
                new PlayerMatch("PM01054212", players.get("Tzolakis"), match15041125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM02712909", players.get("Rodinei"), match15041125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM03324096", players.get("Retsos"), match15041125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM04578512", players.get("Pirola"), match15041125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM05637902", players.get("Ortega"), match15041125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM06448607", players.get("Garcia"), match15041125,
                        0, 0, 0, 0, 65),
                new PlayerMatch("PM07028513", players.get("Mouzakitis"), match15041125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM08023541", players.get("Martins"), match15041125,
                        1, 0, 0, 0, 96),
                new PlayerMatch("PM09578920", players.get("Chiquinho"), match15041125,
                        0, 1, 0, 0, 76),
                new PlayerMatch("PM10303299", players.get("Podence"), match15041125,
                        0, 0, 0, 0, 86),
                new PlayerMatch("PM11973402", players.get("El Kaabi"), match15041125,
                        0, 0, 0, 0, 85),
                new PlayerMatch("PM12524177", players.get("Nascimento"), match15041125,
                        0, 0, 0, 0, 31),
                new PlayerMatch("PM13004233", players.get("Taremi"), match15041125,
                        0, 0, 0, 0, 20),
                new PlayerMatch("PM14042509", players.get("Scipioni"), match15041125,
                        0, 0, 1, 0, 11),
                new PlayerMatch("PM15530310", players.get("Costinha"), match15041125,
                        0, 0, 0, 0, 10)
        );
        setGKGoalsConceded(playerMatches15041125, players.get("Tzolakis"), 1);
        savePlayerMatchesAndUpdateTotalStats(playerMatches15041125, DRAW);

        // Match 16 | Kifisia FC - OLYMPIACOS F.C. 1:3 | 09/11/2025
        Match match16091125 = matchRepository.findById("MA16091125").orElseThrow();
        List<PlayerMatch> playerMatches16091125 = List.of(
                new PlayerMatch("PM01052420", players.get("Tzolakis"), match16091125,
                        0, 0, 0, 0, 98),
                new PlayerMatch("PM02724009", players.get("Rodinei"), match16091125,
                        0, 1, 0, 0, 98),
                new PlayerMatch("PM03312996", players.get("Retsos"), match16091125,
                        0, 0, 0, 0, 98),
                new PlayerMatch("PM04566412", players.get("Pirola"), match16091125,
                        0, 0, 0, 0, 98),
                new PlayerMatch("PM05603302", players.get("Ortega"), match16091125,
                        0, 0, 0, 0, 98),
                new PlayerMatch("PM06790607", players.get("Mouzakitis"), match16091125,
                        0, 0, 0, 0, 88),
                new PlayerMatch("PM07060313", players.get("Nascimento"), match16091125,
                        1, 0, 0, 0, 98),
                new PlayerMatch("PM08022490", players.get("Martins"), match16091125,
                        0, 0, 0, 0, 88),
                new PlayerMatch("PM09553120", players.get("Chiquinho"), match16091125,
                        0, 0, 0, 0, 88),
                new PlayerMatch("PM10304499", players.get("Podence"), match16091125,
                        0, 0, 0, 0, 78),
                new PlayerMatch("PM11203402", players.get("El Kaabi"), match16091125,
                        2, 0, 0, 0, 79),
                new PlayerMatch("PM12270602", players.get("Strefezza"), match16091125,
                        0, 0, 0, 0, 20),
                new PlayerMatch("PM13004711", players.get("Yaremchuk"), match16091125,
                        0, 0, 0, 0, 19),
                new PlayerMatch("PM14094209", players.get("Scipioni"), match16091125,
                        0, 0, 0, 0, 10),
                new PlayerMatch("PM15116610", players.get("Yazici"), match16091125,
                        0, 0, 0, 0, 10),
                new PlayerMatch("PM16907762", players.get("Cabella"), match16091125,
                        0, 0, 0, 0, 10)
        );
        setGKGoalsConceded(playerMatches16091125, players.get("Tzolakis"), 1);
        savePlayerMatchesAndUpdateTotalStats(playerMatches16091125, WIN);

        // Match 17 | OLYMPIACOS F.C. - Atromitos FC 3:0 | 22/11/2025
        Match match17221125 = matchRepository.findById("MA17221125").orElseThrow();
        List<PlayerMatch> playerMatches17221125 = List.of(
                new PlayerMatch("PM01002345", players.get("Tzolakis"), match17221125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM02990421", players.get("Rodinei"), match17221125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM03454296", players.get("Retsos"), match17221125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM04015677", players.get("Pirola"), match17221125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM05697941", players.get("Ortega"), match17221125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM06955351", players.get("Hezze"), match17221125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM07803411", players.get("Nascimento"), match17221125,
                        0, 0, 0, 0, 70),
                new PlayerMatch("PM08866732", players.get("Martins"), match17221125,
                        0, 0, 0, 0, 87),
                new PlayerMatch("PM09955308", players.get("Chiquinho"), match17221125,
                        0, 0, 0, 0, 70),
                new PlayerMatch("PM10234201", players.get("Podence"), match17221125,
                        0, 0, 0, 0, 87),
                new PlayerMatch("PM11987969", players.get("El Kaabi"), match17221125,
                        1, 0, 0, 0, 70),
                new PlayerMatch("PM12011135", players.get("Mouzakitis"), match17221125,
                        0, 0, 0, 0, 26),
                new PlayerMatch("PM13667632", players.get("Yaremchuk"), match17221125,
                        0, 1, 0, 0, 26),
                new PlayerMatch("PM14434960", players.get("Taremi"), match17221125,
                        2, 0, 0, 0, 26),
                new PlayerMatch("PM15877531", players.get("Yazici"), match17221125,
                        0, 0, 0, 0, 9),
                new PlayerMatch("PM16600042", players.get("Strefezza"), match17221125,
                        0, 0, 0, 0, 9)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches17221125, WIN);

        // Match 18 | OLYMPIACOS F.C. - Real Madrid CF 3:4 | 26/11/2025
        Match match18261125 = matchRepository.findById("MA18261125").orElseThrow();
        List<PlayerMatch> playerMatches18261125 = List.of(
                new PlayerMatch("PM01999232", players.get("Tzolakis"), match18261125,
                        0, 0, 0, 0, 97),
                new PlayerMatch("PM02452340", players.get("Rodinei"), match18261125,
                        0, 0, 0, 0, 74),
                new PlayerMatch("PM03987573", players.get("Retsos"), match18261125,
                        0, 0, 0, 0, 97),
                new PlayerMatch("PM04110980", players.get("Pirola"), match18261125,
                        0, 0, 0, 0, 64),
                new PlayerMatch("PM05570693", players.get("Ortega"), match18261125,
                        0, 0, 1, 0, 97),
                new PlayerMatch("PM06789435", players.get("Garcia"), match18261125,
                        0, 0, 0, 0, 47),
                new PlayerMatch("PM07875471", players.get("Mouzakitis"), match18261125,
                        0, 0, 0, 0, 97),
                new PlayerMatch("PM08842312", players.get("Martins"), match18261125,
                        0, 0, 0, 0, 97),
                new PlayerMatch("PM09005308", players.get("Chiquinho"), match18261125,
                        1, 0, 0, 0, 27),
                new PlayerMatch("PM10253021", players.get("Podence"), match18261125,
                        0, 0, 0, 0, 74),
                new PlayerMatch("PM11103969", players.get("El Kaabi"), match18261125,
                        1, 1, 0, 0, 97),
                new PlayerMatch("PM12014050", players.get("Taremi"), match18261125,
                        1, 0, 0, 0, 70),
                new PlayerMatch("PM13117642", players.get("Hezze"), match18261125,
                        0, 1, 0, 0, 50),
                new PlayerMatch("PM14593410", players.get("Biancone"), match18261125,
                        0, 0, 0, 0, 33),
                new PlayerMatch("PM15830101", players.get("Costinha"), match18261125,
                        0, 0, 0, 0, 23),
                new PlayerMatch("PM16070072", players.get("Strefezza"), match18261125,
                        0, 1, 0, 0, 23)
        );
        setGKGoalsConceded(playerMatches16091125, players.get("Tzolakis"), 4);
        savePlayerMatchesAndUpdateTotalStats(playerMatches18261125, LOSS);

        // Match 19 | Panaitolikos FC  - OLYMPIACOS F.C. 0:1 | 30/11/2025 2+ 4
        Match match19301125 = matchRepository.findById("MA19301125").orElseThrow();
        List<PlayerMatch> playerMatches19301125 = List.of(
                new PlayerMatch("PM01092345", players.get("Tzolakis"), match19301125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM02092321", players.get("Costinha"), match19301125,
                        0, 0, 0, 0, 61),
                new PlayerMatch("PM03092394", players.get("Retsos"), match19301125,
                        0, 0, 0, 0, 45),
                new PlayerMatch("PM04092372", players.get("Mancha"), match19301125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM05092399", players.get("Onyemaechi"), match19301125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM06309103", players.get("Hezze"), match19301125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM07911314", players.get("Nascimento"), match19301125,
                        0, 0, 0, 0, 61),
                new PlayerMatch("PM08908546", players.get("Martins"), match19301125,
                        0, 0, 0, 0, 96),
                new PlayerMatch("PM09013242", players.get("El Kaabi"), match19301125,
                        1, 0, 0, 0, 96),
                new PlayerMatch("PM10001232", players.get("Strefezza"), match19301125,
                        0, 0, 0, 0, 61),
                new PlayerMatch("PM11904852", players.get("Yaremchuk"), match19301125,
                        0, 0, 0, 0, 82),
                new PlayerMatch("PM12312045", players.get("Kalogeropoulos"), match19301125,
                        0, 0, 0, 0, 51),
                new PlayerMatch("PM13939506", players.get("Rodinei"), match19301125,
                        0, 0, 0, 0, 35),
                new PlayerMatch("PM14434551", players.get("Mouzakitis"), match19301125,
                        0, 0, 0, 0, 35),
                new PlayerMatch("PM15678102", players.get("Yazici"), match19301125,
                        0, 1, 0, 0, 35),
                new PlayerMatch("PM16079645", players.get("Garcia"), match19301125,
                        0, 0, 0, 0, 14)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches19301125, WIN);

        // Match 20 | APO Ellas Syrou  - OLYMPIACOS F.C. 2:5 | 03/12/2025 1+4
        Match match20031225 = matchRepository.findById("MA20031225").orElseThrow();
        List<PlayerMatch> playerMatches20031225 = List.of(
                new PlayerMatch("PM01035923", players.get("Botis"), match20031225,
                        0, 0, 0, 0, 95),
                new PlayerMatch("PM02567183", players.get("Costinha"), match20031225,
                        0, 0, 0, 0, 68),
                new PlayerMatch("PM03950425", players.get("Kalogeropoulos"), match20031225,
                        0, 0, 0, 0, 95),
                new PlayerMatch("PM04770426", players.get("Mancha"), match20031225,
                        0, 0, 1, 0, 95),
                new PlayerMatch("PM05400429", players.get("Onyemaechi"), match20031225,
                        0, 0, 0, 0, 81),
                new PlayerMatch("PM06750302", players.get("Scipioni"), match20031225,
                        0, 0, 0, 0, 95),
                new PlayerMatch("PM07878753", players.get("Nascimento"), match20031225,
                        0, 1, 0, 0, 81),
                new PlayerMatch("PM08063999", players.get("Cabella"), match20031225,
                        0, 1, 0, 0, 81),
                new PlayerMatch("PM09989031", players.get("Taremi"), match20031225,
                        1, 0, 0, 0, 69),
                new PlayerMatch("PM10695434", players.get("Yazici"), match20031225,
                        2, 1, 0, 0, 95),
                new PlayerMatch("PM11011367", players.get("Yaremchuk"), match20031225,
                        1, 0, 0, 0, 95),
                new PlayerMatch("PM12012279", players.get("Vezo"), match20031225,
                        0, 0, 0, 0, 27),
                new PlayerMatch("PM13460194", players.get("Garcia"), match20031225,
                        0, 0, 0, 0, 26),
                new PlayerMatch("PM14556302", players.get("Rodinei"), match20031225,
                        0, 1, 0, 0, 14),
                new PlayerMatch("PM15577188", players.get("Strefezza"), match20031225,
                        0, 1, 0, 0, 14),
                new PlayerMatch("PM16869701", players.get("El Kaabi"), match20031225,
                        1, 0, 0, 0, 14)
        );
        setGKGoalsConceded(playerMatches16091125, players.get("Botis"), 2);
        savePlayerMatchesAndUpdateTotalStats(playerMatches20031225, WIN);
    }

    private Map<String, Player> getPlayersByLastnames(String... lastnames) throws PlayerNotFoundException{
        Map<String, Player> map = new HashMap<>();
        for (String lastname : lastnames) {
            map.put(lastname, playerRepository.findByLastname(lastname).orElseThrow(() -> new PlayerNotFoundException(lastname)));
        }
        return map;
    }

    private void setGKGoalsConceded(List<PlayerMatch> playerMatch, Player player, int goalsConceded) {
        playerMatch.stream()
                .filter(pm -> pm.getPlayer().equals(player))
                .findFirst()
                .ifPresent(pm -> pm.setGoalsConceded(goalsConceded));
    }

    private void savePlayerMatchesAndUpdateTotalStats(List<PlayerMatch> playerMatches, Result result) {
        playerMatchRepository.saveAll(playerMatches);

        Map<String, PlayerStats> statsCache = new HashMap<>();

        for (PlayerMatch playerMatch : playerMatches) {
            Player player = playerMatch.getPlayer();

            PlayerStats playerStats = statsCache.computeIfAbsent(
                    player.getId(),
                    id -> playerStatsRepository.findByPlayer(player)
                            .orElseGet(() -> new PlayerStats("PS" + id, player))
            );
            playerStats.addMatchStats(playerMatch, result);
        }
        playerStatsRepository.saveAll(statsCache.values());
    }
}
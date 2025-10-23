package solipsismal.olympiacosfcapp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import solipsismal.olympiacosfcapp.model.Match;
import solipsismal.olympiacosfcapp.model.Player;
import solipsismal.olympiacosfcapp.model.PlayerMatch;
import solipsismal.olympiacosfcapp.model.PlayerStats;
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
    public void run(String... args) {
        // Players
        Map<String, Player> players = getPlayersByLastnames(
                "Tzolakis", "Paschalakis", "Botis",
                "Rodinei", "Costinha", "Retsos", "Mancha", "Biancone", "Kalogeropoulos", "Pirola", "Ortega", "Onyemaechi",
                "Hezze", "Liatsikouras", "Garcia", "Mouzakitis", "Nascimento", "Scipioni", "Yazici", "Cabella", "Chiquinho",
                "Martins", "Strefezza", "Podence", "Pnevmonidis", "El Kaabi", "Taremi", "Yaremchuk"
        );

        // Players Matches
        // Match 1 | OLYMPIACOS F.C. - Asteras 2:0 | 23/08/2025
        Match match01230825 = matchRepository.findById("MA01230825").orElseThrow();
        List<PlayerMatch> playerMatches01230825 = List.of(
                new PlayerMatch("PM56390394", players.get("Tzolakis"), match01230825,
                        0, 0, 0, 0, 0, 1, 99),
                new PlayerMatch("PM09428419", players.get("Costinha"), match01230825,
                        0, 0, 0, 0, 0, 1, 64),
                new PlayerMatch("PM41045783", players.get("Retsos"), match01230825,
                        0, 0, 0, 0, 0, 1, 99),
                new PlayerMatch("PM09428524", players.get("Pirola"), match01230825,
                        0, 0, 0, 0, 0, 1, 99),
                new PlayerMatch("PM15763492", players.get("Ortega"), match01230825,
                        0, 0, 0, 0, 0, 1, 83),
                new PlayerMatch("PM53942204", players.get("Garcia"), match01230825,
                        0, 0, 0, 0, 0, 1, 64),
                new PlayerMatch("PM04289562", players.get("Hezze"), match01230825,
                        0, 0, 0, 0, 0, 1, 76),
                new PlayerMatch("PM92509341", players.get("Rodinei"), match01230825,
                        0, 0, 0, 0, 0, 1, 99),
                new PlayerMatch("PM90538676", players.get("Chiquinho"), match01230825,
                        0, 0, 0, 0, 0, 1, 99),
                new PlayerMatch("PM80153752", players.get("Pnevmonidis"), match01230825,
                        0, 0, 0, 0, 0, 1, 83),
                new PlayerMatch("PM26959486", players.get("El Kaabi"), match01230825,
                        1, 0, 0, 0, 0, 1, 99),
                new PlayerMatch("PM38209562", players.get("Mouzakitis"), match01230825,
                        0, 1, 0, 0, 0, 1, 35),
                new PlayerMatch("PM58424960", players.get("Martins"), match01230825,
                        0, 0, 0, 0, 0, 1, 35),
                new PlayerMatch("PM20895463", players.get("Nascimento"), match01230825,
                        0, 1, 0, 0, 0, 1, 23),
                new PlayerMatch("PM74084231", players.get("Yazici"), match01230825,
                        1, 0, 0, 0, 0, 1, 16),
                new PlayerMatch("PM15369045", players.get("Onyemaechi"), match01230825,
                        0, 0, 0, 0, 0, 1, 16)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches01230825);

        // Match 2 | NFC Volos - OLYMPIACOS F.C. 0:2 | 30/08/2025
        Match match02300825 = matchRepository.findById("MA02300825").orElseThrow();
        List<PlayerMatch> playerMatches02300825 = List.of(
                new PlayerMatch("PM56560394", players.get("Tzolakis"), match02300825,
                        0, 0, 0, 0, 0, 1, 98),
                new PlayerMatch("PM12428419", players.get("Rodinei"), match02300825,
                        0, 0, 0, 0, 0, 1, 98),
                new PlayerMatch("PM41054783", players.get("Retsos"), match02300825,
                        1, 0, 0, 0, 0, 1, 98),
                new PlayerMatch("PM09428574", players.get("Pirola"), match02300825,
                        0, 0, 0, 0, 0, 1, 98),
                new PlayerMatch("PM15443492", players.get("Ortega"), match02300825,
                        0, 0, 0, 0, 0, 1, 98),
                new PlayerMatch("PM53142204", players.get("Nascimento"), match02300825,
                        0, 0, 0, 0, 0, 1, 91),
                new PlayerMatch("PM04289762", players.get("Garcia"), match02300825,
                        0, 0, 0, 0, 0, 1, 67),
                new PlayerMatch("PM92500341", players.get("Martins"), match02300825,
                        0, 0, 0, 0, 0, 1, 80),
                new PlayerMatch("PM52538676", players.get("Chiquinho"), match02300825,
                        1, 1, 0, 0, 0, 1, 92),
                new PlayerMatch("PM50653752", players.get("Pnevmonidis"), match02300825,
                        0, 0, 0, 0, 0, 1, 68),
                new PlayerMatch("PM27759486", players.get("El Kaabi"), match02300825,
                        0, 0, 0, 0, 0, 1, 98),
                new PlayerMatch("PM38202762", players.get("Hezze"), match02300825,
                        0, 0, 0, 0, 0, 1, 31),
                new PlayerMatch("PM58421160", players.get("Strefezza"), match02300825,
                        0, 1, 0, 0, 0, 1, 30),
                new PlayerMatch("PM20995463", players.get("Yazici"), match02300825,
                        0, 0, 0, 0, 0, 1, 18),
                new PlayerMatch("PM56084231", players.get("Scipioni"), match02300825,
                        0, 0, 0, 0, 0, 1, 7),
                new PlayerMatch("PM02369045", players.get("Cabella"), match02300825,
                        0, 0, 0, 0, 0, 1, 6)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches02300825);

        // Match 3 | OLYMPIACOS F.C. - Panserraikos FC 5:0 | 13/09/2025
        Match match03130925 = matchRepository.findById("MA03130925").orElseThrow();
        List<PlayerMatch> playerMatches03130925 = List.of(
                new PlayerMatch("PM56505294", players.get("Tzolakis"), match03130925,
                        0, 0, 0, 0, 0, 1, 97),
                new PlayerMatch("PM10528419", players.get("Costinha"), match03130925,
                        0, 0, 0, 0, 0, 1, 97),
                new PlayerMatch("PM41054921", players.get("Retsos"), match03130925,
                        0, 0, 0, 0, 0, 1, 97),
                new PlayerMatch("PM09428552", players.get("Biancone"), match03130925,
                        0, 0, 0, 0, 0, 1, 97),
                new PlayerMatch("PM15439692", players.get("Ortega"), match03130925,
                        1, 1, 0, 0, 0, 1, 97),
                new PlayerMatch("PM53222204", players.get("Hezze"), match03130925,
                        0, 0, 0, 0, 0, 1, 79),
                new PlayerMatch("PM11289762", players.get("Mouzakitis"), match03130925,
                        0, 0, 0, 0, 0, 1, 97),
                new PlayerMatch("PM59500341", players.get("Martins"), match03130925,
                        0, 0, 0, 0, 0, 1, 18),
                new PlayerMatch("PM49538676", players.get("Chiquinho"), match03130925,
                        0, 1, 0, 0, 0, 1, 79),
                new PlayerMatch("PM50597252", players.get("Cabella"), match03130925,
                        0, 1, 0, 0, 0, 1, 72),
                new PlayerMatch("PM27109086", players.get("El Kaabi"), match03130925,
                        1, 0, 0, 0, 0, 1, 73),
                new PlayerMatch("PM58428460", players.get("Strefezza"), match03130925,
                        0, 0, 0, 0, 0, 1, 79),
                new PlayerMatch("PM38201562", players.get("Podence"), match03130925,
                        1, 1, 0, 0, 0, 1, 25),
                new PlayerMatch("PM20992163", players.get("Taremi"), match03130925,
                        2, 0, 0, 0, 0, 1, 24),
                new PlayerMatch("PM56094231", players.get("Yazici"), match03130925,
                        0, 1, 0, 0, 0, 1, 18),
                new PlayerMatch("PM35369045", players.get("Scipioni"), match03130925,
                        0, 0, 0, 0, 0, 1, 18)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches03130925);

        // Match 4 | OLYMPIACOS F.C. - Pafos FC 0:0 | 17/09/2025
        Match match04170925 = matchRepository.findById("MA04170925").orElseThrow();
        List<PlayerMatch> playerMatches04170925 = List.of(
                new PlayerMatch("PM56509424", players.get("Paschalakis"), match04170925,
                        0, 0, 0, 0, 0, 1, 100),
                new PlayerMatch("PM10556249", players.get("Rodinei"), match04170925,
                        0, 0, 0, 0, 0, 1, 65),
                new PlayerMatch("PM41056001", players.get("Retsos"), match04170925,
                        0, 0, 0, 0, 0, 1, 100),
                new PlayerMatch("PM09425932", players.get("Pirola"), match04170925,
                        0, 0, 1, 0, 0, 1, 80),
                new PlayerMatch("PM45239692", players.get("Ortega"), match04170925,
                        0, 0, 0, 0, 0, 1, 100),
                new PlayerMatch("PM11222204", players.get("Hezze"), match04170925,
                        0, 0, 0, 0, 0, 1, 79),
                new PlayerMatch("PM14189762", players.get("Garcia"), match04170925,
                        0, 0, 1, 0, 0, 1, 49),
                new PlayerMatch("PM59599341", players.get("Strefezza"), match04170925,
                        0, 0, 0, 0, 0, 1, 49),
                new PlayerMatch("PM49536826", players.get("Chiquinho"), match04170925,
                        0, 0, 0, 0, 0, 1, 100),
                new PlayerMatch("PM50597322", players.get("Podence"), match04170925,
                        0, 0, 0, 0, 0, 1, 100),
                new PlayerMatch("PM27109896", players.get("El Kaabi"), match04170925,
                        0, 0, 0, 0, 0, 1, 100),
                new PlayerMatch("PM58025460", players.get("Mouzakitis"), match04170925,
                        0, 0, 0, 0, 0, 1, 51),
                new PlayerMatch("PM38339562", players.get("Taremi"), match04170925,
                        0, 0, 1, 0, 0, 1, 51),
                new PlayerMatch("PM20742163", players.get("Costinha"), match04170925,
                        0, 0, 0, 0, 0, 1, 35),
                new PlayerMatch("PM46194231", players.get("Pnevmonidis"), match04170925,
                        0, 0, 0, 0, 0, 1, 31),
                new PlayerMatch("PM90269045", players.get("Biancone"), match04170925,
                        0, 0, 0, 0, 0, 1, 20)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches04170925);

        // Match 5 | Panathinaikos - OLYMPIACOS F.C 1:1 | 21/09/2025
        Match match05210925 = matchRepository.findById("MA05210925").orElseThrow();
        List<PlayerMatch> playerMatches05210925 = List.of(
                new PlayerMatch("PM56509222", players.get("Tzolakis"), match05210925,
                        0, 0, 0, 0, 1, 1, 99),
                new PlayerMatch("PM10559750", players.get("Costinha"), match05210925,
                        0, 0, 0, 0, 0, 1, 99),
                new PlayerMatch("PM41051624", players.get("Retsos"), match05210925,
                        0, 0, 0, 0, 0, 1, 99),
                new PlayerMatch("PM09592932", players.get("Pirola"), match05210925,
                        0, 0, 0, 0, 0, 1, 99),
                new PlayerMatch("PM45255692", players.get("Ortega"), match05210925,
                        0, 0, 0, 0, 0, 1, 99),
                new PlayerMatch("PM11050204", players.get("Scipioni"), match05210925,
                        0, 0, 1, 0, 0, 1, 70),
                new PlayerMatch("PM14112762", players.get("Mouzakitis"), match05210925,
                        0, 0, 0, 0, 0, 1, 82),
                new PlayerMatch("PM59063341", players.get("Strefezza"), match05210925,
                        0, 0, 1, 0, 0, 1, 70),
                new PlayerMatch("PM49537926", players.get("Nascimento"), match05210925,
                        0, 0, 0, 0, 0, 1, 59),
                new PlayerMatch("PM50530922", players.get("Cabella"), match05210925,
                        0, 0, 1, 0, 0, 1, 82),
                new PlayerMatch("PM12109896", players.get("El Kaabi"), match05210925,
                        1, 0, 1, 0, 0, 1, 99),
                new PlayerMatch("PM86525460", players.get("Podence"), match05210925,
                        0, 0, 0, 0, 0, 1, 40),
                new PlayerMatch("PM38191562", players.get("Chiquinho"), match05210925,
                        0, 0, 0, 0, 0, 1, 29),
                new PlayerMatch("PM20746113", players.get("Yazici"), match05210925,
                        0, 0, 0, 0, 0, 1, 29),
                new PlayerMatch("PM46124931", players.get("Hezze"), match05210925,
                        0, 0, 0, 0, 0, 1, 17),
                new PlayerMatch("PM90963045", players.get("Taremi"), match05210925,
                        0, 1, 0, 0, 0, 1, 17)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches05210925);

        // Match 6 | Asteras Tripolis - OLYMPIACOS F.C. 1:2 | 24/09/2025
        Match match06240925 = matchRepository.findById("MA06240925").orElseThrow();
        List<PlayerMatch> playerMatches06240925 = List.of(
                new PlayerMatch("PM12009222", players.get("Paschalakis"), match06240925,
                        0, 0, 0, 0, 1, 1, 94),
                new PlayerMatch("PM10882750", players.get("Kalogeropoulos"), match06240925,
                        0, 0, 0, 0, 0, 1, 65),
                new PlayerMatch("PM41953624", players.get("Biancone"), match06240925,
                        0, 0, 1, 0, 0, 1, 94),
                new PlayerMatch("PM09773932", players.get("Mancha"), match06240925,
                        0, 0, 1, 0, 0, 1, 94),
                new PlayerMatch("PM45409692", players.get("Onyemaechi"), match06240925,
                        0, 0, 1, 0, 0, 1, 94),
                new PlayerMatch("PM11050402", players.get("Garcia"), match06240925,
                        0, 0, 1, 0, 0, 1, 77),
                new PlayerMatch("PM14112336", players.get("Nascimento"), match06240925,
                        0, 0, 0, 0, 0, 1, 65),
                new PlayerMatch("PM59063413", players.get("Cabella"), match06240925,
                        0, 0, 0, 0, 0, 1, 65),
                new PlayerMatch("PM49537629", players.get("Yazici"), match06240925,
                        0, 0, 0, 0, 0, 1, 77),
                new PlayerMatch("PM50593222", players.get("Pnevmonidis"), match06240925,
                        0, 0, 0, 0, 0, 1, 94),
                new PlayerMatch("PM12170396", players.get("Taremi"), match06240925,
                        2, 0, 0, 0, 0, 1, 94),
                new PlayerMatch("PM86507360", players.get("Costinha"), match06240925,
                        0, 0, 0, 0, 0, 1, 29),
                new PlayerMatch("PM38132362", players.get("Hezze"), match06240925,
                        0, 0, 0, 0, 0, 1, 29),
                new PlayerMatch("PM20641113", players.get("Podence"), match06240925,
                        0, 0, 1, 0, 0, 1, 29),
                new PlayerMatch("PM64124931", players.get("Liatsikouras"), match06240925,
                        0, 0, 0, 0, 0, 1, 17),
                new PlayerMatch("PM90063045", players.get("El Kaabi"), match06240925,
                        0, 0, 0, 0, 0, 1, 17)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches06240925);

        // Match 7 | OLYMPIACOS F.C. - Levadiakos 3:2 | 27/09/2025
        Match match07270925 = matchRepository.findById("MA07270925").orElseThrow();
        List<PlayerMatch> playerMatches07270925 = List.of(
                new PlayerMatch("PM12003212", players.get("Tzolakis"), match07270925,
                        0, 0, 0, 0, 2, 1, 113),
                new PlayerMatch("PM10922750", players.get("Costinha"), match07270925,
                        0, 0, 0, 0, 0, 1, 81),
                new PlayerMatch("PM94953624", players.get("Retsos"), match07270925,
                        1, 0, 0, 0, 0, 1, 113),
                new PlayerMatch("PM89073932", players.get("Pirola"), match07270925,
                        0, 0, 0, 0, 0, 1, 113),
                new PlayerMatch("PM45409132", players.get("Ortega"), match07270925,
                        0, 0, 1, 0, 0, 1, 113),
                new PlayerMatch("PM12157412", players.get("Mouzakitis"), match07270925,
                        0, 1, 0, 0, 0, 1, 70),
                new PlayerMatch("PM14992336", players.get("Hezze"), match07270925,
                        0, 0, 1, 0, 0, 1, 113),
                new PlayerMatch("PM12063413", players.get("Strefezza"), match07270925,
                        0, 0, 0, 0, 0, 1, 70),
                new PlayerMatch("PM04537629", players.get("Chiquinho"), match07270925,
                        2, 0, 0, 0, 0, 1, 113),
                new PlayerMatch("PM53393182", players.get("Podence"), match07270925,
                        0, 0, 0, 0, 0, 1, 80),
                new PlayerMatch("PM12170746", players.get("El Kaabi"), match07270925,
                        0, 0, 0, 0, 0, 1, 109),
                new PlayerMatch("PM86507630", players.get("Garcia"), match07270925,
                        0, 1, 0, 0, 0, 1, 42),
                new PlayerMatch("PM38142362", players.get("Martins"), match07270925,
                        0, 0, 0, 0, 0, 1, 42),
                new PlayerMatch("PM11641113", players.get("Cabella"), match07270925,
                        0, 0, 0, 0, 0, 1, 32),
                new PlayerMatch("PM66124931", players.get("Rodinei"), match07270925,
                        0, 0, 0, 0, 0, 1, 31),
                new PlayerMatch("PM90064375", players.get("Taremi"), match07270925,
                        0, 0, 0, 0, 0, 1, 4)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches07270925);

        // Match 8 | Arsenal FC - OLYMPIACOS F.C. 2:0 | 01/10/2025
        Match match08011025 = matchRepository.findById("MA08011025").orElseThrow();
        List<PlayerMatch> playerMatches08011025 = List.of(
                new PlayerMatch("PM12821712", players.get("Tzolakis"), match08011025,
                        0, 0, 0, 0, 2, 1, 97),
                new PlayerMatch("PM10922571", players.get("Costinha"), match08011025,
                        0, 0, 0, 0, 0, 1, 97),
                new PlayerMatch("PM94953446", players.get("Retsos"), match08011025,
                        0, 0, 0, 0, 0, 1, 88),
                new PlayerMatch("PM89073112", players.get("Pirola"), match08011025,
                        0, 0, 0, 0, 0, 1, 97),
                new PlayerMatch("PM45409302", players.get("Ortega"), match08011025,
                        0, 0, 0, 0, 0, 1, 97),
                new PlayerMatch("PM12157507", players.get("Hezze"), match08011025,
                        0, 0, 0, 0, 0, 1, 88),
                new PlayerMatch("PM14992991", players.get("Garcia"), match08011025,
                        0, 0, 0, 0, 0, 1, 77),
                new PlayerMatch("PM12063651", players.get("Martins"), match08011025,
                        0, 0, 0, 0, 0, 1, 64),
                new PlayerMatch("PM04537020", players.get("Chiquinho"), match08011025,
                        0, 0, 0, 0, 0, 1, 88),
                new PlayerMatch("PM53393288", players.get("Podence"), match08011025,
                        0, 0, 0, 0, 0, 1, 97),
                new PlayerMatch("PM12170177", players.get("El Kaabi"), match08011025,
                        0, 0, 0, 0, 0, 1, 97),
                new PlayerMatch("PM86507002", players.get("Taremi"), match08011025,
                        0, 0, 0, 0, 0, 1, 33),
                new PlayerMatch("PM38142452", players.get("Scipioni"), match08011025,
                        0, 0, 0, 0, 0, 1, 30),
                new PlayerMatch("PM11641009", players.get("Biancone"), match08011025,
                        0, 0, 0, 0, 0, 1, 19),
                new PlayerMatch("PM66124991", players.get("Strefezza"), match08011025,
                        0, 0, 0, 0, 0, 1, 19),
                new PlayerMatch("PM10264375", players.get("Mouzakitis"), match08011025,
                        0, 0, 0, 0, 0, 1, 19)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches08011025);

        // Match 9 | PAOK FC - OLYMPIACOS F.C. 2:1 | 05/10/2025
        Match match09051025 = matchRepository.findById("MA09051025").orElseThrow();
        List<PlayerMatch> playerMatches09051025 = List.of(
                new PlayerMatch("PM92883212", players.get("Tzolakis"), match09051025,
                        0, 0, 0, 0, 2, 1, 95),
                new PlayerMatch("PM10982571", players.get("Costinha"), match09051025,
                        0, 0, 1, 0, 0, 1, 87),
                new PlayerMatch("PM11953446", players.get("Biancone"), match09051025,
                        0, 0, 1, 0, 0, 1, 95),
                new PlayerMatch("PM22073112", players.get("Pirola"), match09051025,
                        0, 0, 0, 0, 0, 1, 95),
                new PlayerMatch("PM39409302", players.get("Ortega"), match09051025,
                        0, 0, 0, 0, 0, 1, 95),
                new PlayerMatch("PM85157507", players.get("Hezze"), match09051025,
                        0, 0, 0, 0, 0, 1, 95),
                new PlayerMatch("PM94192991", players.get("Garcia"), match09051025,
                        0, 0, 0, 0, 0, 1, 74),
                new PlayerMatch("PM02063651", players.get("Martins"), match09051025,
                        0, 0, 0, 0, 0, 1, 79),
                new PlayerMatch("PM56537020", players.get("Chiquinho"), match09051025,
                        1, 0, 0, 0, 0, 1, 95),
                new PlayerMatch("PM62693288", players.get("Podence"), match09051025,
                        0, 0, 1, 0, 0, 1, 95),
                new PlayerMatch("PM32370177", players.get("El Kaabi"), match09051025,
                        0, 1, 0, 0, 0, 1, 95),
                new PlayerMatch("PM98507002", players.get("Mouzakitis"), match09051025,
                        0, 0, 0, 0, 0, 1, 21),
                new PlayerMatch("PM38131452", players.get("Taremi"), match09051025,
                        0, 0, 0, 0, 0, 1, 16),
                new PlayerMatch("PM11640509", players.get("Yazici"), match09051025,
                        0, 0, 0, 0, 0, 1, 8)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches09051025);

        // Match 10 | AE Larissa - OLYMPIACOS F.C. 0:2 | 18/10/2025
        Match match10181025 = matchRepository.findById("MA10181025").orElseThrow();
        List<PlayerMatch> playerMatches10181025 = List.of(
                new PlayerMatch("PM92805212", players.get("Tzolakis"), match10181025,
                        0, 0, 0, 0, 0, 1, 99),
                new PlayerMatch("PM10982339", players.get("Costinha"), match10181025,
                        0, 0, 0, 0, 0, 1, 99),
                new PlayerMatch("PM19551396", players.get("Retsos"), match10181025,
                        0, 0, 0, 0, 0, 1, 99),
                new PlayerMatch("PM41073112", players.get("Mancha"), match10181025,
                        0, 0, 0, 0, 0, 1, 99),
                new PlayerMatch("PM99409302", players.get("Ortega"), match10181025,
                        0, 1, 0, 0, 0, 1, 62),
                new PlayerMatch("PM85110507", players.get("Scipioni"), match10181025,
                        0, 0, 1, 0, 0, 1, 68),
                new PlayerMatch("PM94192321", players.get("Hezze"), match10181025,
                        0, 0, 0, 0, 0, 1, 99),
                new PlayerMatch("PM02003651", players.get("Yazici"), match10181025,
                        0, 0, 0, 0, 0, 1, 61),
                new PlayerMatch("PM56547020", players.get("Chiquinho"), match10181025,
                        0, 0, 0, 0, 0, 1, 76),
                new PlayerMatch("PM62693299", players.get("Podence"), match10181025,
                        0, 0, 0, 0, 0, 1, 99),
                new PlayerMatch("PM32373147", players.get("El Kaabi"), match10181025,
                        2, 0, 0, 0, 0, 1, 75),
                new PlayerMatch("PM98551102", players.get("Cabella"), match10181025,
                        0, 0, 0, 0, 0, 1, 38),
                new PlayerMatch("PM38191433", players.get("Onyemaechi"), match10181025,
                        0, 0, 0, 0, 0, 1, 37),
                new PlayerMatch("PM11689509", players.get("Mouzakitis"), match10181025,
                        0, 0, 0, 0, 0, 1, 31),
                new PlayerMatch("PM03892345", players.get("Yaremchuk"), match10181025,
                        0, 0, 0, 0, 0, 1, 24),
                new PlayerMatch("PM90745362", players.get("Nascimento"), match10181025,
                        0, 0, 0, 0, 0, 1, 23)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches10181025);

        // Match 11 | FC Barcelona - OLYMPIACOS F.C. 6:1 | 21/10/2025 2 + 4 = 96
        Match match11211025 = matchRepository.findById("MA11211025").orElseThrow();
        List<PlayerMatch> playerMatches11211025 = List.of(
                new PlayerMatch("PM30505212", players.get("Tzolakis"), match11211025,
                        0, 0, 0, 0, 6, 1, 96),
                new PlayerMatch("PM15732339", players.get("Costinha"), match11211025,
                        0, 0, 0, 0, 0, 1, 96),
                new PlayerMatch("PM19598296", players.get("Retsos"), match11211025,
                        0, 0, 0, 0, 0, 1, 96),
                new PlayerMatch("PM41558212", players.get("Pirola"), match11211025,
                        0, 0, 0, 0, 0, 1, 96),
                new PlayerMatch("PM99591202", players.get("Ortega"), match11211025,
                        0, 0, 0, 0, 0, 1, 55),
                new PlayerMatch("PM85598607", players.get("Garcia"), match11211025,
                        0, 0, 1, 0, 0, 1, 96),
                new PlayerMatch("PM94192421", players.get("Hezze"), match11211025,
                        0, 0, 2, 1, 0, 1, 59),
                new PlayerMatch("PM09903651", players.get("Martins"), match11211025,
                        0, 0, 0, 0, 0, 1, 47),
                new PlayerMatch("PM11547020", players.get("Chiquinho"), match11211025,
                        0, 0, 0, 0, 0, 1, 31),
                new PlayerMatch("PM35693299", players.get("Podence"), match11211025,
                        0, 0, 1, 0, 0, 1, 80),
                new PlayerMatch("PM90373147", players.get("El Kaabi"), match11211025,
                        1, 0, 0, 0, 0, 1, 80),
                new PlayerMatch("PM92251102", players.get("Nascimento"), match11211025,
                        0, 0, 0, 0, 0, 1, 65),
                new PlayerMatch("PM38851433", players.get("Mouzakitis"), match11211025,
                        0, 0, 0, 0, 0, 1, 49),
                new PlayerMatch("PM15189509", players.get("Onyemaechi"), match11211025,
                        0, 0, 0, 0, 0, 1, 41),
                new PlayerMatch("PM30892345", players.get("Yaremchuk"), match11211025,
                        0, 0, 0, 0, 0, 1, 16),
                new PlayerMatch("PM94705362", players.get("Taremi"), match11211025,
                        0, 0, 0, 0, 0, 1, 16)
        );
        savePlayerMatchesAndUpdateTotalStats(playerMatches11211025);

    }

    private Map<String, Player> getPlayersByLastnames(String... lastnames) {
        Map<String, Player> map = new HashMap<>();
        for (String lastname : lastnames) {
            map.put(lastname, playerRepository.findByLastname(lastname).orElseThrow());
        }
        return map;
    }

    private void savePlayerMatchesAndUpdateTotalStats(List<PlayerMatch> playerMatches) {
        playerMatchRepository.saveAll(playerMatches);

        Map<String, PlayerStats> statsCache = new HashMap<>();

        for (PlayerMatch playerMatch : playerMatches) {
            Player player = playerMatch.getPlayer();

            PlayerStats playerStats = statsCache.computeIfAbsent(
                    player.getId(),
                    id -> playerStatsRepository.findByPlayer(player)
                            .orElseGet(() -> new PlayerStats("PS" + id, player))
            );
            playerStats.addMatchStats(playerMatch);
        }
        playerStatsRepository.saveAll(statsCache.values());
    }
}
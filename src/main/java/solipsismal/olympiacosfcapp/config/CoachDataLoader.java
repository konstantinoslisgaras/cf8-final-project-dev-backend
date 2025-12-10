package solipsismal.olympiacosfcapp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import solipsismal.olympiacosfcapp.model.*;
import solipsismal.olympiacosfcapp.repository.CoachRepository;

@Component
@Order(3)
public class CoachDataLoader implements CommandLineRunner {

    private final CoachRepository coachRepository;

    public CoachDataLoader(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @SuppressWarnings("ExtractMethodRecommender")
    @Override
    public void run(String... args) {
        // Mendilibar
        DetailedBio mendilibarBio = new DetailedBio("DB34418052", "José Luis Mendilibar Etxebarria", "14/03/1961",
                "Zaldibar", "", 1.72, "Sevilla", "José Luis Mendilibar is a Spanish football manager known for his pragmatic, demanding, and direct style of play, having coached over 400 matches in La Liga for multiple clubs including Eibar, Osasuna, and Real Valladolid. His career enjoyed a remarkable resurgence in 2023 when he took over Sevilla and promptly guided them to a historic UEFA Europa League title. Building on this success, he joined Greek club Olympiacos F.C. in 2024 and led them to win the UEFA Europa Conference League, securing the first-ever European trophy for a Greek club, cementing his reputation as a \"fixer\" who achieves rapid, historic success.");
        CoachStats mendilibarTotalStats = new CoachStats("CSMG34418052",
                0, 0, 0, 0, 0, 0);
        Coach mendilibar = new Coach("MG34418052", "Mendilibar", "José Luis", 1961,
                "Spain", mendilibarBio, mendilibarTotalStats, true);

        coachRepository.save(mendilibar);

        // Match 1 | OLYMPIACOS F.C. - Asteras 2:0 | 23/08/2025
        updateCoachStats(2, 0, mendilibar);

        // Match 2 | NFC Volos - OLYMPIACOS F.C. 0:2 | 30/08/2025
        updateCoachStats(2, 0, mendilibar);

        // Match 3 | OLYMPIACOS F.C. - Panserraikos FC 5:0 | 13/09/2025
        updateCoachStats(5, 0, mendilibar);

        // Match 4 | OLYMPIACOS F.C. - Pafos FC 0:0 | 17/09/2025
        updateCoachStats(0, 0, mendilibar);

        // Match 5 | Panathinaikos - OLYMPIACOS F.C 1:1 | 21/09/2025
        updateCoachStats(1, 1, mendilibar);

        // Match 6 | Asteras Tripolis - OLYMPIACOS F.C. 1:2 | 24/09/2025
        updateCoachStats(2, 1, mendilibar);

        // Match 7 | OLYMPIACOS F.C. - Levadiakos 3:2 | 27/09/2025
        updateCoachStats(3, 2, mendilibar);

        // Match 8 | Arsenal FC - OLYMPIACOS F.C. 2:0 | 01/10/2025
        updateCoachStats(0, 2, mendilibar);

        // Match 9 | PAOK FC - OLYMPIACOS F.C. 2:1 | 05/10/2025
        updateCoachStats(1, 2, mendilibar);

        // Match 10 | AE Larissa - OLYMPIACOS F.C. 0:2 | 18/10/2025
        updateCoachStats(2, 0, mendilibar);

        // Match 11 | FC Barcelona - OLYMPIACOS F.C. 6:1 | 21/10/2025
        updateCoachStats(1, 6, mendilibar);

        // Match 12 | OLYMPIACOS F.C. AEK FC 2:0 | 26/10/2025
        updateCoachStats(2, 0, mendilibar);

        // Match 13 | OLYMPIACOS F.C. - NFC Volos 5:0 | 29/10/2025
        updateCoachStats(5, 0, mendilibar);

        // Match 14 | OLYMPIACOS F.C. - ARIS FC 2:1 | 01/11/2025
        updateCoachStats(2, 1, mendilibar);

        // Match 15 | OLYMPIACOS F.C. - PSV Eindhoven 1:1 | 04/11/2025
        updateCoachStats(1, 1, mendilibar);

        // Match 16 | Kifisia FC - OLYMPIACOS F.C. 1:3 | 09/11/2025
        updateCoachStats(3, 1, mendilibar);

        // Match 17 | OLYMPIACOS F.C. - Atromitos FC 3:0 | 22/11/2025
        updateCoachStats(3, 0, mendilibar);

        // Match 18 | OLYMPIACOS F.C. - Real Madrid CF 3:4 | 26/11/2025
        updateCoachStats(3, 4, mendilibar);

        // Match 19 | Panaitolikos FC  - OLYMPIACOS F.C. 0:1 | 30/11/2025
        updateCoachStats(1, 0, mendilibar);

        // Match 20 | APO Ellas Syrou  - OLYMPIACOS F.C. 2:5 | 03/12/2025
        updateCoachStats(5, 2, mendilibar);

        // Match 21 | OLYMPIACOS F.C. - OFI Crete FC 3:0 | 06/12/2025
        updateCoachStats(3, 0, mendilibar);
    }

    private void updateCoachStats(int goals, int goalsConceded, Coach coach) {
        coach.getCoachStats().addCoachMatchStats(goals, goalsConceded);
        coachRepository.save(coach);
    }
}
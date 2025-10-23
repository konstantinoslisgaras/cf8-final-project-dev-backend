package solipsismal.olympiacosfcapp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import solipsismal.olympiacosfcapp.model.*;
import solipsismal.olympiacosfcapp.repository.CoachRepository;
import solipsismal.olympiacosfcapp.repository.CoachStatsRepository;

import static solipsismal.olympiacosfcapp.core.enums.Day.*;
import static solipsismal.olympiacosfcapp.core.enums.Ground.AWAY;
import static solipsismal.olympiacosfcapp.core.enums.Ground.HOME;

@Component
@Order(3)
public class CoachDataLoader implements CommandLineRunner {

    private final CoachRepository coachRepository;
    private final CoachStatsRepository coachStatsRepository;

    public CoachDataLoader(CoachRepository coachRepository, CoachStatsRepository coachStatsRepository) {
        this.coachRepository = coachRepository;
        this.coachStatsRepository = coachStatsRepository;
    }

    @Override
    public void run(String... args) {
        // Mendilibar
        DetailedBio mendilibarBio = new DetailedBio("DB34418052", "José Luis Mendilibar Etxebarria", "14/03/1961",
                "Zaldibar", "", 1.72, "Sevilla", "José Luis Mendilibar is a Spanish football manager known for his pragmatic, demanding, and direct style of play, having coached over 400 matches in La Liga for multiple clubs including Eibar, Osasuna, and Real Valladolid. His career enjoyed a remarkable resurgence in 2023 when he took over Sevilla and promptly guided them to a historic UEFA Europa League title. Building on this success, he joined Greek club Olympiacos F.C. in 2024 and led them to win the UEFA Europa Conference League, securing the first-ever European trophy for a Greek club, cementing his reputation as a \"fixer\" who achieves rapid, historic success.");
        CoachStats mendilibarTotalStats = new CoachStats("CS34418052",
                0, 0, 0, 0, 0, 0);
        coachRepository.save(new Coach("MA34418052", "Mendilibar", "José Luis", 1961,
                "Spain", mendilibarBio, mendilibarTotalStats, true));

        // Match 1 | OLYMPIACOS F.C. - Asteras 2:0 | 23/08/2025
        updateCoachStats(2, 0, mendilibarTotalStats);

        // Match 2 | NFC Volos - OLYMPIACOS F.C. 0:2 | 30/08/2025
        updateCoachStats(2, 0, mendilibarTotalStats);

        // Match 3 | OLYMPIACOS F.C. - Panserraikos FC 5:0 | 13/09/2025
        updateCoachStats(5, 0, mendilibarTotalStats);

        // Match 4 | OLYMPIACOS F.C. - Pafos FC 0:0 | 17/09/2025
        updateCoachStats(0, 0, mendilibarTotalStats);

        // Match 5 | Panathinaikos - OLYMPIACOS F.C 1:1 | 21/09/2025
        updateCoachStats(1, 1, mendilibarTotalStats);

        // Match 6 | Asteras Tripolis - OLYMPIACOS F.C. 1:2 | 24/09/2025
        updateCoachStats(2, 1, mendilibarTotalStats);

        // Match 7 | OLYMPIACOS F.C. - Levadiakos 3:2 | 27/09/2025
        updateCoachStats(3, 2, mendilibarTotalStats);

        // Match 8 | Arsenal FC - OLYMPIACOS F.C. 2:0 | 01/10/2025
        updateCoachStats(0, 2, mendilibarTotalStats);

        // Match 9 | PAOK FC - OLYMPIACOS F.C. 2:1 | 05/10/2025
        updateCoachStats(1, 2, mendilibarTotalStats);

        // Match 10 | AE Larissa - OLYMPIACOS F.C. 0:2 | 18/10/2025
        updateCoachStats(2, 0, mendilibarTotalStats);

        // Match 11 | FC Barcelona - OLYMPIACOS F.C. 6:1 | 21/10/2025
        updateCoachStats(6, 1, mendilibarTotalStats);

        // Match 12 | OLYMPIACOS F.C. AEK FC 0:0 | 26/10/2025
        updateCoachStats(0, 0, mendilibarTotalStats);
    }

    private void updateCoachStats(int goals, int goalsConceded, CoachStats mendilibarTotalStats) {
        mendilibarTotalStats.addCoachMatchStats(new CoachStats("", goals, goalsConceded));
        coachStatsRepository.save(mendilibarTotalStats);
    }
}
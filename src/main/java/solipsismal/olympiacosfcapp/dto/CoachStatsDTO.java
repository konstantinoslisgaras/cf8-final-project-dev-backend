package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.utils.PlayerUtils;

@Getter
@Setter
public class CoachStatsDTO {
    private String coachId;
    private String name;
    private int wins;
    private int draws;
    private int losses;
    private int goals;
    private int goalsConceded;
    private int matchesManaged;

    public CoachStatsDTO(String coachId, String lastname, String firstname,
                         int goals, int goalsConceded, int matchesManaged, int wins, int draws, int losses) {
        this.coachId = coachId;
        this.name = PlayerUtils.getConcatenatedName(lastname, firstname);
        this.goals = goals;
        this.goalsConceded = goalsConceded;
        this.matchesManaged = matchesManaged;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }
}
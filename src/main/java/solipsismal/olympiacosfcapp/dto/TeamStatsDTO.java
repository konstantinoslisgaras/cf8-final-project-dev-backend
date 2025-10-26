package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.model.TeamStats;

@Getter
@Setter
public class TeamStatsDTO {
    private String id;
    private Integer goals;
    private Integer assists;
    private Integer goalsConceded;
    private Integer yellowCards;
    private Integer redCards;
    private Integer wins;
    private Integer draws;
    private Integer losses;
    private Integer matchesPlayed;

    public TeamStatsDTO(TeamStats teamStatsDTO) {
        this.id = teamStatsDTO.getId();
        this.goals = teamStatsDTO.getGoals();
        this.assists = teamStatsDTO.getAssists();
        this.goalsConceded = teamStatsDTO.getGoalsConceded();
        this.yellowCards = teamStatsDTO.getYellowCards();
        this.redCards = teamStatsDTO.getRedCards();
        this.wins = teamStatsDTO.getWins();
        this.draws = teamStatsDTO.getDraws();
        this.losses = teamStatsDTO.getLosses();
        this.matchesPlayed = teamStatsDTO.getMatchesPlayed();
    }

}

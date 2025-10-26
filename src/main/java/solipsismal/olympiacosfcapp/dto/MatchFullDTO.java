package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.model.*;

@Getter
@Setter
public class MatchFullDTO {
    private String id;
    private String olympiacos;
    private String opponent;
    private Integer olympiacosGoals;
    private Integer opponentGoals;
    private String date;
    private String day;
    private String competition;
    private String ground;
    private Integer matchNumber;
    private String description;
    private CoachDTO coachDTO;
    private TeamStatsDTO teamStatsDTO;
    private String season;

    public MatchFullDTO(Match match) {
        this.id = match.getId();
        this.olympiacos = match.getOlympiacos().getName();
        this.opponent = match.getOpponent().getOpponentName();
        this.olympiacosGoals = match.getOlympiacosGoals();
        this.opponentGoals = match.getOpponentGoals();
        this.date = match.getDate();
        this.day = match.getDay().toString();
        this.competition = match.getCompetition().getCompetitionName();
        this.ground = match.getGround().toString();
        this.matchNumber = match.getMatchNumber();
        this.description = match.getDescription();
        this.coachDTO = new CoachDTO(match.getCoach());
        this.teamStatsDTO = new TeamStatsDTO(match.getTeamStats());
        this.season = match.getSeason().getSeasonName();
    }
}
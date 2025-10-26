package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.model.*;

@Getter
@Setter
public class MatchBasicDTO {
    private String id;
    private String olympiacosName;
    private String opponentName;
    private Integer olympiacosGoals;
    private Integer opponentGoals;
    private String date;
    private String ground;

    public MatchBasicDTO(Match match) {
        this.id = match.getId();
        this.olympiacosName = match.getOlympiacos().getName();
        this.opponentName = match.getOpponent().getOpponentName();
        this.olympiacosGoals = match.getOlympiacosGoals();
        this.opponentGoals = match.getOpponentGoals();
        this.date = match.getDate();
        this.ground = match.getGround().toString();
    }
}

package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.model.*;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class MatchBasicDTO {
    private String id;
    private String olympiacosName;
    private String opponentName;
    private Integer olympiacosGoals;
    private Integer opponentGoals;
    private String date;
    private String time;
    private String ground;
    private String result;
    private Integer matchNumber;

    public MatchBasicDTO(Match match) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        this.id = match.getId();
        this.olympiacosName = match.getOlympiacos().getName();
        this.opponentName = match.getOpponent().getOpponentName();
        this.olympiacosGoals = match.getOlympiacosGoals();
        this.opponentGoals = match.getOpponentGoals();
        this.date = match.getDate() != null ? match.getDate().format(dateFormatter) : null;
        this.time = match.getTime() != null ? match.getTime().format(timeFormatter) : null;
        this.ground = match.getGround().toString();
        this.result = match.getResult();
        this.matchNumber = match.getMatchNumber();
    }
}
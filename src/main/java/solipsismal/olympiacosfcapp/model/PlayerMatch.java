package solipsismal.olympiacosfcapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import solipsismal.olympiacosfcapp.core.enums.Position;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "players_matches")
public class PlayerMatch {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

    @Column(length = 2, nullable = false)
    private Integer goals;

    @Column(length = 2, nullable = false)
    private Integer assists;

    @Column(length = 2, nullable = false)
    private Integer yellowCards;

    @Column(length = 2, nullable = false)
    private Integer redCards;

    @Column(length = 2, nullable = false)
    private Integer goalsConceded = 0;

    @Column(length = 3, nullable = false)
    private Integer minutesPlayed;

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = (player != null && player.getPosition() == Position.GOALKEEPER) ? goalsConceded : 0;
    }

    public PlayerMatch(String id, Player player, Match match, Integer goals, Integer assists,
                       Integer yellowCards, Integer redCards, Integer minutesPlayed) {
        this.id = id;
        this.player = player;
        this.match = match;
        this.goals = goals;
        this.assists = assists;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.minutesPlayed = minutesPlayed;
    }

}
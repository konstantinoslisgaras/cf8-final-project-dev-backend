package solipsismal.olympiacosfcapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import solipsismal.olympiacosfcapp.core.enums.Position;
import solipsismal.olympiacosfcapp.core.enums.PreferredFoot;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "players")
public class Player {

    @Id
    @Column(length = 10, unique = true, nullable = false)
    private String id;

    @Column(name = "lastname", length = 30, unique = false, nullable = false)
    private String lastname;

    @Column(name = "firstname", length = 30, unique = false, nullable = true)
    private String firstname;

    @Column(name = "birth_year", length = 4, unique = false, nullable = false)
    private Integer birthYear;

    @Column(name = "nationality", length = 30, unique = false, nullable = false)
    private String nationality;

    @Column(name = "shirt_number", length = 2, unique = false, nullable = false)
    private Integer shirtNumber;

    @Column(unique = false, nullable = false)
    private Integer fans = 0;

    @Enumerated(EnumType.STRING)
    private Position position;

    @Enumerated(EnumType.STRING)
    @Column(name = "preferred_foot", nullable = false)
    private PreferredFoot preferredFoot;

    @Column(name = "captain")
    private boolean isCaptain;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "detailed_bio_id")
    private DetailedBio detailedBio;

    @Column(name = "plays_for_olympiacos", nullable = false)
    private Boolean playsForOlympiacos;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PlayerMatch> playersMatches = new HashSet<>();

    public Player(String id, String lastname, String firstname, Integer birthYear, String nationality, Integer shirtNumber,
                  Position position, PreferredFoot preferredFoot, boolean isCaptain, DetailedBio detailedBio, Boolean playsForOlympiacos) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthYear = birthYear;
        this.nationality = nationality;
        this.shirtNumber = shirtNumber;
        this.position = position;
        this.preferredFoot = preferredFoot;
        this.isCaptain = isCaptain;
        this.detailedBio = detailedBio;
        this.playsForOlympiacos = playsForOlympiacos;
        this.playersMatches = new HashSet<>();
    }

    public void addFan() {
        this.fans++;
    }

    public void removeFan() {
        if (this.fans > 0) this.fans--;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return isCaptain == player.isCaptain && Objects.equals(id, player.id) && Objects.equals(lastname, player.lastname) && Objects.equals(firstname, player.firstname) && Objects.equals(birthYear, player.birthYear) && Objects.equals(nationality, player.nationality) && Objects.equals(shirtNumber, player.shirtNumber) && position == player.position && preferredFoot == player.preferredFoot && Objects.equals(detailedBio, player.detailedBio) && Objects.equals(playsForOlympiacos, player.playsForOlympiacos) && Objects.equals(playersMatches, player.playersMatches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname, birthYear, nationality, shirtNumber, position, preferredFoot, isCaptain, detailedBio, playsForOlympiacos, playersMatches);
    }
}
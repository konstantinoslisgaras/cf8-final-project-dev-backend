package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.core.enums.Position;
import solipsismal.olympiacosfcapp.core.enums.PreferredFoot;
import solipsismal.olympiacosfcapp.model.Player;

@Getter
@Setter
public class PlayerDTO {
    private String id;
    private String lastname;
    private String firstname;
    private Integer birthYear;
    private String nationality;
    private Integer shirtNumber;
    private Position position;
    private PreferredFoot preferredFoot;
    private boolean isCaptain;
    private DetailedBioDTO detailedBio;

    public PlayerDTO(Player player) {
        this.id = player.getId();
        this.lastname = player.getLastname();
        this.firstname = player.getFirstname();
        this.birthYear = player.getBirthYear();
        this.nationality = player.getNationality();
        this.shirtNumber = player.getShirtNumber();
        this.position = player.getPosition();
        this.preferredFoot = player.getPreferredFoot();
        this.isCaptain = player.isCaptain();
        this.detailedBio = new DetailedBioDTO(player.getDetailedBio());
    }
}
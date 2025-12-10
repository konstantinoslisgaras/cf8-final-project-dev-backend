package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
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
    private Integer fans;
    private String genericPosition;
    private String position;
    private String preferredFoot;
    private boolean isCaptain;

    public PlayerDTO(Player player) {
        this.id = player.getId();
        this.lastname = player.getLastname();
        this.firstname = player.getFirstname();
        this.birthYear = player.getBirthYear();
        this.nationality = player.getNationality();
        this.shirtNumber = player.getShirtNumber();
        this.fans = player.getFans();
        this.genericPosition = player.getPosition().getGenericPosition();
        this.position = player.getPosition().getAbbreviation();
        this.preferredFoot = player.getPreferredFoot().getAbbreviation();
        this.isCaptain = player.isCaptain();
    }
}
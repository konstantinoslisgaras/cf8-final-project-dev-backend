package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.model.Player;

@Getter
@Setter
public class PlayerListDTO {
    private String id;
    private String name;
    private Integer shirtNumber;

    public PlayerListDTO(Player player) {
        this.id = player.getId();
        this.name = formatPlayerFullName(player);
        this.shirtNumber = player.getShirtNumber();
    }

    private String formatPlayerFullName(Player player) {
        String lastname = player.getLastname();
        String firstname = player.getFirstname();
        if (firstname == null || firstname.isEmpty()) return lastname;
        return lastname + " " + firstname.charAt(0) + ".";
    }
}

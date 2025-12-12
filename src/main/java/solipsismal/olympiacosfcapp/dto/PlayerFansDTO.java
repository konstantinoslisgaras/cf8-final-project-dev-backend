package solipsismal.olympiacosfcapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.model.Player;

import static solipsismal.olympiacosfcapp.utils.PlayerUtils.formatPlayerFullName;

@Getter
@Setter
@AllArgsConstructor
public class PlayerFansDTO {
    private String id;
    private String name;
    private Integer fans;

    public PlayerFansDTO(Player player) {
        this.id = player.getId();
        this.name = formatPlayerFullName(player);
        this.fans = player.getFans();
    }
}
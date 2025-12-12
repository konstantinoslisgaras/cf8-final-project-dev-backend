package solipsismal.olympiacosfcapp.service;

import solipsismal.olympiacosfcapp.dto.PlayerFansDTO;
import solipsismal.olympiacosfcapp.dto.PlayerListDTO;

import java.util.List;

public interface IPlayerService {
    List<PlayerListDTO> getPlayerList();
    List<PlayerFansDTO> getTop10Fans();
}
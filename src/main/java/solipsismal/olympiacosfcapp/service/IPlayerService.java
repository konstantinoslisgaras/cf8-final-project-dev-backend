package solipsismal.olympiacosfcapp.service;

import solipsismal.olympiacosfcapp.dto.PlayerListDTO;

import java.util.List;

public interface IPlayerService {
    List<PlayerListDTO> getPlayerList();
}
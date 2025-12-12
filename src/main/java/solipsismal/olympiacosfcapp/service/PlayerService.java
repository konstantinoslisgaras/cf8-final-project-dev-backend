package solipsismal.olympiacosfcapp.service;

import org.springframework.stereotype.Service;
import solipsismal.olympiacosfcapp.dto.PlayerDTO;
import solipsismal.olympiacosfcapp.dto.PlayerFansDTO;
import solipsismal.olympiacosfcapp.dto.PlayerListDTO;
import solipsismal.olympiacosfcapp.repository.PlayerRepository;

import java.util.List;

@Service
public class PlayerService implements IPlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<PlayerListDTO> getPlayerList() {
        return playerRepository.findAllByOrderByLastnameAsc()
                .stream()
                .map(PlayerListDTO::new)
                .toList();
    }

    @Override
    public List<PlayerFansDTO> getTop10Fans() {
        return playerRepository.findTop10ByOrderByFansDesc()
                .stream()
                .map(PlayerFansDTO::new)
                .toList();
    }
}

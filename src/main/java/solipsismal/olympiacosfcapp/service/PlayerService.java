package solipsismal.olympiacosfcapp.service;

import org.springframework.stereotype.Service;
import solipsismal.olympiacosfcapp.dto.PlayerListDTO;
import solipsismal.olympiacosfcapp.model.Player;
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
}

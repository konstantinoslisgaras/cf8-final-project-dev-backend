package solipsismal.olympiacosfcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import solipsismal.olympiacosfcapp.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, String>, JpaSpecificationExecutor<Player> {
    Optional<Player> findByLastname(String lastname);
    List<Player> findAllByOrderByShirtNumberAsc();
    List<Player> findAllByOrderByLastnameAsc();
}

package solipsismal.olympiacosfcapp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import solipsismal.olympiacosfcapp.model.Opponent;
import solipsismal.olympiacosfcapp.repository.OpponentRepository;

import java.util.List;

@Component
@Order(5)
public class OpponentDataLoader implements CommandLineRunner {

    private final OpponentRepository opponentRepository;

    public OpponentDataLoader(OpponentRepository opponentRepository) {
        this.opponentRepository = opponentRepository;
    }

    @Override
    public void run(String... args) {
        opponentRepository.saveAll(List.of(
                new Opponent("OT83523495", "Asteras Tripolis", "Greece"),
                new Opponent("OT35210638", "NFC Volos", "Greece"),
                new Opponent("OT15210985", "Panserraikos FC", "Greece"),
                new Opponent("OT09532476", "Pafos FC", "Cyprus"),
                new Opponent("OT19205883", "Panathinaikos", "Greece"),
                new Opponent("OT75142094", "Levadiakos", "Greece"),
                new Opponent("OT51098945", "Arsenal FC", "England"),
                new Opponent("OT36758902", "PAOK FC", "Greece"),
                new Opponent("OT92415380", "AE Larissa", "Greece"),
                new Opponent("OT94961380", "FC Barcelona", "Spain"),
                new Opponent("OT64021380", "AEK FC", "Greece")
                )
        );
    }
}
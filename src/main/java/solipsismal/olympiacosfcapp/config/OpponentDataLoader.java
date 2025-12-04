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
                new Opponent("OT19205883", "Panathinaikos FC", "Greece"),
                new Opponent("OT75142094", "Levadiakos FC", "Greece"),
                new Opponent("OT51098945", "Arsenal FC", "England"),
                new Opponent("OT36758902", "PAOK FC", "Greece"),
                new Opponent("OT92415380", "AE Larissa", "Greece"),
                new Opponent("OT94961380", "FC Barcelona", "Spain"),
                new Opponent("OT64021380", "AEK FC", "Greece"),
                new Opponent("OT92015963", "ARIS FC", "Greece"),
                new Opponent("OT30895149", "PSV Eindhoven", "Netherlands"),
                new Opponent("OT49025138", "Kifisia FC", "Greece"),
                new Opponent("OT14239840", "Atromitos FC", "Greece"),
                new Opponent("OT60276410", "Real Madrid CF", "Spain"),
                new Opponent("OT19253327", "Panaitolikos FC", "Greece"),
                new Opponent("OT86423927", "APO Ellas Syrou", "Greece"),
                new Opponent("OT79201532", "OFI Crete FC", "Greece"),
                new Opponent("OT04291312", "FC Kairat Almaty", "Kazakhstan"),
                new Opponent("OT34950235", "Iraklis FC", "Greece")
                )
        );
    }
}
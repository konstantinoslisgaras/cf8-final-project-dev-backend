package solipsismal.olympiacosfcapp.config.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import solipsismal.olympiacosfcapp.model.Olympiacos;
import solipsismal.olympiacosfcapp.repository.OlympiacosRepository;

@Order(1)
@Component
public class OlympiacosDataLoader implements CommandLineRunner {

    private final OlympiacosRepository olympiacosRepository;

    public OlympiacosDataLoader(OlympiacosRepository olympiacosRepository) {
        this.olympiacosRepository = olympiacosRepository;
    }

    @Override
    public void run(String... args) {
        // Olympiacos
        String olympiacosId = "OL00000007";
        String olympiacosName = "Olympiacos F.C.";
        String olympiacosTrophies = """
        Major Trophies:
        UEFA Europa Conference League: 1
        Greek Super League (Championships): 48
        Greek Cup (Domestic Cup): 29
        Double (Championships & Domestic Cups): 19
        Greek Super Cup: 4
        UEFA Youth League: 1
        Balkan Cup: 1
        """;
        String olympiacosHistory = """
        Olympiacos F.C., nicknamed Thrylos (The Legend), is the most successful club in Greek football history. Founded on March 10, 1925, in Piraeus, Greece's largest port city, the club was formed after the merger of two existing local clubs. The name, Olympiacos Syndesmos Filathlon Peiraios (Olympic Association of Fans of Piraeus), was inspired by the ancient Olympic Games, symbolizing noble rivalry and athletic ideal. The club's colors, red and white, represent passion for victory and purity, respectively. The early success of the five legendary Andrianopoulos brothers, who formed the club's formidable offensive line, quickly raised Olympiacos's reputation and helped establish its immense popularity, especially among the working-class people of Piraeus.\
        Olympiacos's domination of Greek football began early, with the club securing its first Greek Championship in 1931. The pre-World War II and post-war era of the 1950s became a "Golden Era," where the team, featuring stars like Andreas Mouratis and Elias Rossidis, won an unprecedented six consecutive league titles from 1954 to 1959, solidifying their nickname "The Legend." This era also saw the club set the record for six consecutive Greek Cups between 1957 and 1963. In the 1970s, under the presidency of Nikos Goulandris, the club experienced another period of success, winning three consecutive championships (1973, 1974, 1975).\
        The club faced a lean period, known as the "Stone Years," between the mid-1980s and mid-1990s, going ten years without a league title (1987-1997). However, the late 1990s marked the start of a "Golden Era" of sustained dominance under the presidency of Sokratis Kokkalis, largely fueled by almost yearly participation in the lucrative UEFA Champions League. Olympiacos set a Greek record by winning seven consecutive league titles from 1997 to 2003, a feat they later repeated from 2011 to 2017. Their domestic supremacy is virtually unmatched, holding records with a total of 48 Greek League titles and 29 Greek Cups (19 doubles).\
        On the European stage, Olympiacos made history as the first Greek club to compete in a UEFA-sanctioned European competition (1959–60 European Cup). While often a strong competitor in the UEFA Champions League, their best run in the elite competition was in the 1998–99 season, reaching the quarter-finals and narrowly missing out on a semi-final spot against Juventus in the final minutes of the second leg. They also reached the quarter-finals of the UEFA Cup Winners' Cup in 1992–93.\
        The most significant chapter in their European history came in the 2023–24 season. In a landmark achievement for Greek football, Olympiacos F.C. became the first Greek club to win a major UEFA trophy by defeating Fiorentina in the final of the UEFA Europa Conference League in Athens. This historic triumph secured their status as the first Greek club to be crowned European champions and cemented their place as a powerhouse in the region. Their youth team also won the UEFA Youth League in the same season, making Olympiacos the first European club to win two UEFA trophies in a single season. The club's home ground is the Karaiskakis Stadium in Piraeus, and their rivalry with Panathinaikos, the "Derby of the Eternal Rivals," remains one of the most intense in world football.
        """;
        Olympiacos olympiacos = new Olympiacos(olympiacosId, olympiacosName, olympiacosTrophies, olympiacosHistory);
        olympiacosRepository.save(olympiacos);
    }
}
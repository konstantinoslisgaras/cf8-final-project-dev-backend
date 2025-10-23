package solipsismal.olympiacosfcapp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import solipsismal.olympiacosfcapp.model.DetailedBio;
import solipsismal.olympiacosfcapp.model.Player;
import solipsismal.olympiacosfcapp.repository.PlayerRepository;

import static solipsismal.olympiacosfcapp.core.enums.Position.*;
import static solipsismal.olympiacosfcapp.core.enums.PreferredFoot.*;

@Component
@Order(4)
public class PlayerDataLoader implements CommandLineRunner {

    private final PlayerRepository playerRepository;

    public PlayerDataLoader(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void run(String... args) {
        // Tzolakis
        DetailedBio tzolakisBio = new DetailedBio("DB53859301", "Konstantinos \"Konstantis\" Tzolakis", "08/11/2002",
                "Chania", "", 1.93, "Platanias", "Konstantinos \"Konstantis\" Tzolakis (born 8 November 2002) is a Greek professional footballer who plays as a goalkeeper for Olympiacos and the Greece national team. A product of Platanias and later the Olympiacos academy, he debuted for the senior side in 2019. He first made headlines in the 2020 Greek Cup Final, keeping a clean sheet in Olympiacos’s victory. Tzolakis’s breakthrough came during the 2023–24 UEFA Europa Conference League, where his decisive penalty saves against Fenerbahçe in the quarter-finals propelled Olympiacos toward winning their first European trophy. By 2025 he had established himself as the club’s first-choice goalkeeper, known for his agility, composure under pressure and shot-stopping ability, while also earning regular caps with the Greek national team.");
        playerRepository.save(new Player("PL53859301", "Tzolakis", "Konstantis", 2002,
                        "Greece", 88, GOALKEEPER, BOTH, false, tzolakisBio, true));
        // Paschalakis
        DetailedBio paschalakisBio = new DetailedBio("DB90113428", "Alexandros Paschalakis", "28/07/1989",
                "Xanthi", "", 1.97, "PAOK", "Alexandros Paschalakis (born 28 July 1989) is a Greek professional goalkeeper for Olympiacos and the Greece national team. Standing 1.97 m, he began his career with smaller clubs in Greece before rising to prominence at PAS Giannina, earning a move to PAOK in 2017. With PAOK he won the 2018–19 Super League and multiple Greek Cups, establishing himself as one of the top domestic goalkeepers. In 2022 he joined Olympiacos, where he contributed to the club’s historic 2023–24 UEFA Europa Conference League triumph. A Greek international since 2019, Paschalakis is recognized for his height, strong reflexes and leadership in high-pressure matches.");
        playerRepository.save(new Player("PL90113428", "Paschalakis", "Alexandros", 1989,
                "Greece", 1, GOALKEEPER, RIGHT, false, paschalakisBio, true));
        // Botis
        DetailedBio botisBio = new DetailedBio("DB32095644", "Nikolaos Nestoras Botis", "31/03/2004",
                "Larissa", "", 1.96, "Inter", "Nikolaos Nestoras Botis (born 31 March 2004) is a Greek goalkeeper for Olympiacos and the Greece U21 national team. A tall presence at 1.96 m, he began his career in PAOK’s youth system before moving to Inter Milan’s academy in 2020. After three years in Italy, he returned to Greece with Olympiacos, featuring for both the senior and B teams. Regarded as a promising talent, Botis has combined domestic appearances with international experience at youth level and is seen as a long-term option in goal for both club and country.");
        playerRepository.save(new Player("PL32095644", "Botis", "Nikolaos", 2004,
                "Greece", 31, GOALKEEPER, RIGHT, false, botisBio, true));
        // Rodinei
        DetailedBio rodineiBio = new DetailedBio("DB82542910", "Rodinei Marcelo de Almeida", "29/01/1992",
                "Tatuí", "", 1.75, "Flamengo", "Rodinei Marcelo de Almeida (born 29 January 1992), known simply as Rodinei, is a Brazilian right-back for Olympiacos. After beginning his career in Brazil, he rose to prominence at Flamengo, where he won multiple domestic honors and two Copa Libertadores titles. In January 2023 he signed for Olympiacos, becoming an influential figure in their 2023–24 UEFA Europa Conference League triumph. Renowned for his attacking instincts, stamina and work rate, Rodinei has established himself as a reliable veteran presence in the Greek Super League.");
        playerRepository.save(new Player("PL82542910", "Rodinei", "", 1992,
                "Brazil", 23, RIGHT_BACK, RIGHT, false, rodineiBio, true));
        // Costinha
        DetailedBio costinhaBio = new DetailedBio("DB14949263", "João Pedro Loureiro da Costa", "26/03/2000",
                "Póvoa de Varzim", "", 1.81, "Rio Ave", "João Pedro Loureiro da Costa (born 26 March 2000), commonly known as Costinha, is a Portuguese right-back for Olympiacos. A product of Rio Ave, he played regularly in the Primeira Liga before joining Olympiacos in 2024. Known for his defensive consistency and pace, he has adapted well to the Greek Super League and adds depth and competition at right-back for Olympiacos.");
        playerRepository.save(new Player("PL14949263", "Costinha", "", 2000,
                "Portugal", 20, RIGHT_BACK, RIGHT, false, costinhaBio, true));
        // Retsos
        DetailedBio retsosBio = new DetailedBio("DB52873291", "Panagiotis \"Panos\" Retsos", "09/08/1998",
                "Johannesburg", "", 1.86, "Hellas Verona", "Panagiotis \"Panos\" Retsos (born 9 August 1998) is a Greek professional footballer who captains Olympiacos and plays for the Greece national team. Born in Johannesburg, South Africa, he joined the Olympiacos academy in 2008 and debuted for the senior side in 2016, becoming the youngest captain in the club’s history at 18. He later moved to Bayer Leverkusen, with loan spells at Sheffield United and Saint-Étienne, before returning to Olympiacos in 2022. Retsos was central to Olympiacos’s 2023–24 European triumph and is known for his versatility across the back line, composure, and leadership qualities.");
        playerRepository.save(new Player("PL52873291", "Retsos", "Panagiotis", 1998,
                "Greece", 45, CENTER_BACK, RIGHT, true, retsosBio, true));
        // Mancha
        DetailedBio manchaBio = new DetailedBio("DB98302943", "Gustavo Teixeira Lopes da Conceição", "25/07/2004",
                "Oliveira dos Brejinhos", "", 1.90, "Fortaleza", "Gustavo Teixeira Lopes da Conceição \"Mancha\" (born 25 July 2004) is a Brazilian centre-back for Olympiacos. Starting his youth career at Palmeiras, he moved to Fortaleza where he gained first-team experience, including appearances in the Copa Libertadores. In 2025 he joined Olympiacos, marking his first venture into European football. Standing at 1.90 m, Mancha is viewed as a long-term defensive prospect for the Greek champions, praised for his aerial strength and physical style of play.");
        playerRepository.save(new Player("PL98302943", "Mancha", "Gustavo", 2004,
                "Brazil", 39, CENTER_BACK, LEFT, false, manchaBio, true));
        // Biancone
        DetailedBio bianconeBio = new DetailedBio("DB72029451", "Giulian Alexis André Biancone", "31/03/2000",
                "Fréjus", "", 1.87, "Nottingham Forest", "Giulian Alexis André Biancone (born 31 March 2000) is a French defender for Olympiacos. A product of AS Monaco’s academy, he gained experience with loan spells at Cercle Brugge in Belgium before playing in Ligue 1 with Troyes. In 2022 he joined Nottingham Forest in the Premier League but moved to Olympiacos in 2023. Capable of playing across the defense but primarily used as a centre-back, Biancone contributed to Olympiacos’s domestic and European successes and is valued for his versatility and defensive positioning.");
        playerRepository.save(new Player("PL72029451", "Biancone", "Giulian", 2000,
                "France", 4, CENTER_BACK, RIGHT, false, bianconeBio, true));
        // Kalogeropoulos
        DetailedBio kalogeropoulosBio = new DetailedBio("DB38993201", "Alexios \"Alexis\" Kalogeropoulos", "26/07/2004",
                "Andravida", "", 1.87, "Asteras Tripolis", "Alexios \"Alexis\" Kalogeropoulos (born 26 July 2004) is a Greek centre-back for Olympiacos and a Greece U21 international. Having progressed through the Olympiacos system, he gained senior experience on loan at Volos between 2023 and 2025, where he was named the club’s Player of the Season. Returning to Olympiacos for the 2025–26 campaign, Kalogeropoulos is regarded as a promising defender with strong aerial ability and composure, and is being developed as part of the next generation of Greek footballers.");
        playerRepository.save(new Player("PL38993201", "Kalogeropoulos", "Alexios", 2004,
                "Greece", 6, CENTER_BACK, RIGHT, false, kalogeropoulosBio, true));
        // Pirola
        DetailedBio pirolaBio = new DetailedBio("DB89234201", "Lorenzo Pirola", "20/02/2002",
                "Carate Brianza", "", 1.85, "Salernitana", "Lorenzo Pirola (born 20 February 2002) is an Italian centre-back for Olympiacos. A product of Inter Milan’s academy, he made his senior debut in 2020 before gaining experience with Monza and Salernitana, where he became a regular starter in Serie A. In July 2024 he transferred to Olympiacos, where he quickly earned a place in the starting lineup. An Italian youth international who has captained the U21 side, Pirola is noted for his tactical awareness, leadership and ball-playing ability from defense.");
        playerRepository.save(new Player("PL89234201", "Pirola", "Lorenzo", 2002,
                "Italy", 5, CENTER_BACK, LEFT, false, pirolaBio, true));
        // Ortega
        DetailedBio ortegaBio = new DetailedBio("DB69802341", "Francisco Gabriel Ortega", "19/03/1999",
                "Santa Fe", "", 1.77, "Vélez Sarsfield", "Francisco Gabriel Ortega (born 19 March 1999) is an Argentine professional footballer who plays as a left-back for Olympiacos. A graduate of Vélez Sarsfield, he debuted for their senior team in 2017 and quickly became a key player before transferring to Olympiacos in 2023. Known for his pace, overlapping runs and attacking contributions, Ortega has been a mainstay on Olympiacos’s left flank, including their victorious 2023–24 UEFA Europa Conference League campaign. He has also represented Argentina at youth levels, featuring in the FIFA U-20 World Cup and the 2020 Olympic Games.");
        playerRepository.save(new Player("PL69802341", "Ortega", "Francisco", 1999,
                "Argentina", 3, LEFT_BACK, LEFT, false, ortegaBio, true));
        // Onyemaechi
        DetailedBio onyemaechiBio = new DetailedBio("DB29757340", "Sopuruchukwu Bruno Onyemaechi", "03/04/1999",
                "Owerri", "", 1.84, "Boavista", "Sopuruchukwu Bruno Onyemaechi (born 3 April 1999) is a Nigerian professional footballer who plays as a left-back for Olympiacos and the Nigeria national team. Starting his career in Portugal, he developed with Feirense before making his breakthrough at Boavista, earning a move to Olympiacos in January 2025. Onyemaechi has represented Nigeria at senior level, including the 2023 Africa Cup of Nations where the team reached the final. He is recognized for his defensive discipline, athleticism and ability to contribute in attack.");
        playerRepository.save(new Player("PL29757340", "Onyemaechi", "Bruno", 1999,
                "Nigeria", 70, LEFT_BACK, LEFT, false, onyemaechiBio, true));
        // Hezze
        DetailedBio hezzeBio = new DetailedBio("DB52329655", "Santiago Hezze", "22/10/2001",
                "Buenos Aires", "Poland", 1.78, "Huracán", "Santiago Hezze (born 22 October 2001) is an Argentine defensive midfielder who plays for Olympiacos. A product of Huracán’s academy, Hezze moved to Europe in 2023 to join Olympiacos and became an important midfield screen due to his tackling, positional sense and passing range; he played a central role in Olympiacos’s 2023–24 Europa Conference League campaign. Eligible for Argentina and holding a Polish passport, he is valued for his work rate, leadership and ability to link defence and attack.");
        playerRepository.save(new Player("PL52329655", "Hezze", "Santiago", 2001,
                "Argentina", 32, DEFENDING_MIDFIELDER, RIGHT, false, hezzeBio, true));
        // Liatsikouras
        DetailedBio liatsikourasBio = new DetailedBio("DB68034151", "Argyrios \"Argyris\" Liatsikouras", "20/12/2006",
                "", "", 1.78, "Olympiacos B", "Argyrios \"Argyris\" Liatsikouras (born 20 December 2006) is a Greek defensive midfielder in the Olympiacos system who has progressed through the club’s youth teams and featured for Olympiacos B. A technically tidy player known for his ball retention and tactical awareness, Liatsikouras emerged from the academy into professional football in 2025 and is regarded as a long-term prospect for both club and Greece youth national teams.");
        playerRepository.save(new Player("PL68034151", "Liatsikouras", "Argyrios", 2006,
                "Greece", 67, DEFENDING_MIDFIELDER, RIGHT, false, liatsikourasBio, true));
        // Garcia
        DetailedBio garciaBio = new DetailedBio("DB13945570", "Daniel \"Dani\" Garcia Carrillo", "24/05/1990",
                "Zumarraga", "", 1.80, "Athletic Bilbao", "Daniel \"Dani\" García Carrillo (born 24 May 1990) is a Spanish defensive midfielder who joined Olympiacos after a long career in Spain. Previously a mainstay at SD Eibar and later Athletic Bilbao, García brings veteran experience, disciplined positioning and strong ball distribution; his presence strengthened Olympiacos’s midfield in the 2024–25 season and he contributed leadership during domestic and European campaigns.");
        playerRepository.save(new Player("PL13945570", "Garcia", "Dani", 1990,
                "Spain", 14, DEFENDING_MIDFIELDER, RIGHT, false, garciaBio, true));
        // Mouzakitis
        DetailedBio mouzakitisBio = new DetailedBio("DB72352901", "Christos Mouzakitis", "25/12/2006",
                "Athens", "", 1.78, "Olympiacos B", "Christos Mouzakitis (born 25 December 2006) is a Greek central midfielder who progressed through the Olympiacos academy and has featured for the club’s B and senior squads. Known for his football intelligence and composure, he made early professional appearances and earned recognition as a standout youth performer in 2024–25; Mouzakitis is considered a promising home-grown midfield talent with a high ceiling.");
        playerRepository.save(new Player("PL72352901", "Mouzakitis", "Christos", 2006,
                "Greece", 96, CENTER_MIDFIELDER, LEFT, false, mouzakitisBio, true));
        // Nascimento
        DetailedBio nascimentoBio = new DetailedBio("DB25297542", "Diogo André Santos Nascimento", "02/11/2002",
                "Leiria", "", 1.66, "Vizela", "Diogo André Santos Nascimento (born 2 November 2002) is a Portuguese central midfielder who transferred to Olympiacos in July 2025 after developing at Vizela and earlier Portuguese academies. A creative playmaker with close control and passing vision, Nascimento earned domestic recognition in Portugal before moving to Greece; he is regarded as a technically gifted midfielder expected to contribute in possession and transition.");
        playerRepository.save(new Player("PL25297542", "Nascimento", "Diogo", 2002,
                "Portugal", 8, CENTER_MIDFIELDER, RIGHT, false, nascimentoBio, true));
        // Scipioni
        DetailedBio scipioniBio = new DetailedBio("DB84249033", "Lorenzo Scipioni", "24/11/2004",
                "Martinez", "Italy", 1.81, "Tigre", "Lorenzo Scipioni (born 24 November 2004) is an Argentine central midfielder who joined Olympiacos from Tigre in 2025. Developed in Argentina, Scipioni made his senior breakthrough with Tigre and earned a move to Europe on the back of strong domestic performances; he is valued for his engine, ball progression and tactical discipline as he adapts to the demands of European football.");
        playerRepository.save(new Player("PL84249033", "Scipioni", "Lorenzo", 2004,
                "Argentina", 16, CENTER_MIDFIELDER, RIGHT, false, scipioniBio, true));
        // Yazici
        DetailedBio yaziciBio = new DetailedBio("DB40914528", "Yusuf Yazici", "29/01/1997",
                "Trabzon", "", 1.83, "Lille", "Yusuf Yazici (born 29 January 1997) is a Turkish attacking midfielder who plays for Olympiacos. A product of Trabzonspor, Yazici moved to Lille and has since had spells across Europe, bringing creativity, long-range shooting and set-piece threat. He joined Olympiacos in 2024 and contributed experience and attacking impetus in domestic and continental competitions.");
        playerRepository.save(new Player("PL40914528", "Yazici", "Yusuf", 1997,
                "Turkey", 97, ATTACKING_MIDFIELDER, LEFT, false, yaziciBio, true));
        // Cabella
        DetailedBio cabellaBio = new DetailedBio("DB93532714", "Rémy Joseph Cabella", "08/03/1990",
                "Ajaccio", "Italy", 1.72, "Lille", "Rémy Joseph Cabella (born 8 March 1990) is a French attacking midfielder who plays for Olympiacos. Cabella developed at Montpellier and played across Europe in France and England before later moves, bringing technical flair, close control and creative passing. As a seasoned professional, he offers depth and creative options off the bench or in rotation for Olympiacos’s attacking midfield positions.");
        playerRepository.save(new Player("PL93532714", "Cabella", "Rémy", 1990,
                "France", 90, ATTACKING_MIDFIELDER, RIGHT, false, cabellaBio, true));
        // Chiquinho
        DetailedBio chiquinhoBio = new DetailedBio("DB04579343", "Francisco Leonel Lima Silva Machado", "19/07/1995",
                "Santo Tirso", "", 1.75, "Benfica", "Chiquinho (Francisco Leonel Lima Silva Machado) (born 19 July 1995) is a Portuguese attacking midfielder who plays for Olympiacos. Developed in Portugal, Chiquinho earned moves to top-flight clubs and joined Olympiacos in 2024; he is noted for his dribbling, passing and contributions from set pieces and featured as a creative option in the club’s domestic and European campaigns.");
        playerRepository.save(new Player("PL04579343", "Chiquinho", "", 1995,
                "Portugal", 22, ATTACKING_MIDFIELDER, RIGHT, false, chiquinhoBio, true));
        // Martins
        DetailedBio martinsBio = new DetailedBio("DB25943256", "Gelson Dany Batalha Martins", "11/05/1995",
                "Praia", "Cape Verde", 1.73, "Monaco", "Gelson Dany Batalha Martins (born 11 May 1995) is a Portuguese winger who plays for Olympiacos. Having risen to prominence at Sporting CP and later as a key player for Monaco, Martins brings pace, dribbling and wide attacking experience; he joined Olympiacos in 2024 and provided depth and directness on the flanks during domestic competition.");
        playerRepository.save(new Player("PL25943256", "Martins", "Gelson", 1995,
                "Portugal", 10, RIGHT_WINGER, RIGHT, false, martinsBio, true));
        // Strefezza
        DetailedBio strefezzaBio = new DetailedBio("DB15687065", "Gabriel Tadeu Strefezza Rebelato", "18/04/1997",
                "São Paulo", "Italy", 1.68, "Como", "Gabriel Tadeu Strefezza Rebelato (born 18 April 1997) is a Brazilian-Italian winger who plays for Olympiacos. Having established himself in Italy with Lecce and earlier spells in the Italian system, Strefezza moved to Olympiacos in 2025; he contributes pace, incisive dribbling and goal threat from wide areas and is valued for his versatility across the front line.");
        playerRepository.save(new Player("PL15687065", "Strefezza", "Gabriel", 1997,
                "Brazil", 27, RIGHT_WINGER, RIGHT, false, strefezzaBio, true));
        // Podence
        DetailedBio podenceBio = new DetailedBio("DB47229603", "Daniel Castelo Podence", "21/10/1995",
                "Oeiras", "", 1.70, "Al-Shabab", "Daniel Castelo Podence (born 21 October 1995) is a Portuguese winger who plays for Olympiacos. After youth development at Sporting CP and a spell in the Premier League, Podence returned to Olympiacos on loan in 2023–25 and then rejoined in 2025; he is known for his direct dribbling, pace and ability to create chances from wide positions and has been a frequent attacking contributor.");
        playerRepository.save(new Player("PL47229603", "Podence", "Daniel", 1995,
                "Portugal", 56, LEFT_WINGER, RIGHT, false, podenceBio, true));
        // Pnevmonidis
        DetailedBio pnevmonidisBio = new DetailedBio("DB38616402", "Stavros Pnevmonidis", "07/08/2006",
                "Kastoria", "", 1.78, "Olympiacos B", "Stavros Pnevmonidis (born 7 August 2006) is a Greek winger who progressed through Olympiacos’s youth ranks and featured for the club’s U19 and B teams. A product of the academy, Pnevmonidis played in the club’s successful youth campaigns and earned a professional debut pathway in 2025; he is praised for his pace, directness and potential as an attacking youth prospect.");
        playerRepository.save(new Player("PL38616402", "Pnevmonidis", "Stavros", 2006,
                "Greece", 80, LEFT_WINGER, RIGHT, false, pnevmonidisBio, true));
        // El Kaabi
        DetailedBio elKaabiBio = new DetailedBio("DB94345107", "Ayoub El Kaabi", "25/06/1993",
                "Casablanca", "", 1.82, "Al Sadd", "Ayoub El Kaabi (born 25 June 1993) is a Moroccan striker who plays for Olympiacos. After making his name in Moroccan domestic football and spells abroad, El Kaabi joined Olympiacos in 2023 and became an influential forward, noted for his finishing and aerial presence; he was a key scorer during the club’s successful European campaign and remains an important attacking option.");
        playerRepository.save(new Player("PL94345107", "El Kaabi", "Ayoub", 1993,
                "Morocco", 9, STRIKER, LEFT, false, elKaabiBio, true));
        // Taremi
        DetailedBio taremiBio = new DetailedBio("DB47639319", "Mehdi Taremi", "18/07/1992",
                "Bushehr", "", 1.85, "Inter", "Mehdi Taremi (born 18 July 1992) is an Iranian striker who joined Olympiacos in 2025. A prolific forward with significant experience in Portugal and Iran, Taremi is known for his movement, finishing and ability to operate centrally; his arrival added a proven goalscoring profile to Olympiacos’s attacking unit.");
        playerRepository.save(new Player("PL47639319", "Taremi", "Mehdi", 1992,
                "Iran", 99, STRIKER, RIGHT, false, taremiBio, true));
        // Yaremchuk
        DetailedBio yaremchukBio = new DetailedBio("DB60495429", "Roman Olehovych Yaremchuk", "27/11/1995",
                "Lviv", "", 1.91, "Club Brugge", "Roman Yaremchuk (born 27 November 1995) is a Ukrainian striker who plays for Olympiacos. A product of Dynamo Kyiv’s academy, Yaremchuk built his reputation across Europe with productive spells in Belgium and Portugal before joining Olympiacos in 2024; he is valued for his aerial ability, hold-up play and physical presence leading the attack.");
        playerRepository.save(new Player("PL60495429", "Yaremchuk", "Roman", 1995,
                "Ukraine", 11, STRIKER, RIGHT, false, yaremchukBio, true));
    }
}
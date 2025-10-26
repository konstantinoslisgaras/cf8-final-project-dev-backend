package solipsismal.olympiacosfcapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "seasons")
public class Season {

    @Id
    @Column(name = "seasons", unique = true, nullable = false)
    private String id;

    @Column(name = "year_start", length = 4, nullable = false)
    private Integer yearStart;

    @Column(name = "year_end", length = 4, nullable = false)
    private Integer yearEnd;

    @Column(name = "season_name", length = 5, nullable = false, unique = true)
    private String seasonName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_stats_id")
    private TeamStats teamStats;

    public Season() {}

    public Season(int yearStart, int yearEnd) {
        this.id = seasonIdGenerator(yearStart, yearEnd);
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;
        this.seasonName = seasonNameGenerator(yearStart, yearEnd);
    }

    private String seasonIdGenerator(int yearStart, int yearEnd) {
        return "SE" + yearStart + yearEnd;
    }

    private String seasonNameGenerator(int yearStart, int yearEnd) {
        String start = String.valueOf(yearStart).substring(2);
        String end = String.valueOf(yearEnd).substring(2);
        return start + "-" + end;
    }
}
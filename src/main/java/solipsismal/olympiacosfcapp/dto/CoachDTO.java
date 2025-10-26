package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.model.Coach;

@Getter
@Setter
public class CoachDTO {
    private String id;
    private String lastname;
    private String firstname;
    private Integer birthYear;
    private String nationality;
    private DetailedBioDTO detailedBio;

    public CoachDTO(Coach coach) {
        this.id = coach.getId();
        this.lastname = coach.getLastname();
        this.firstname = coach.getFirstname();
        this.birthYear = coach.getBirthYear();
        this.nationality = coach.getNationality();
        this.detailedBio = new DetailedBioDTO(coach.getDetailedBio());
    }
}
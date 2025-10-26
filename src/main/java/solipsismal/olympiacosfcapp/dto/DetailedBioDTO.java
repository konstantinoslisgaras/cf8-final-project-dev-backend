package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.model.DetailedBio;

@Getter
@Setter
public class DetailedBioDTO {
    private String id;
    private String fullname;
    private String birthdate;
    private String cityOfBirth;
    private String secondNationality;
    private Double height;
    private String previousTeam;
    private String biography;

    public DetailedBioDTO(DetailedBio detailedBioDTO) {
        this.id = detailedBioDTO.getId();
        this.fullname = detailedBioDTO.getFullname();
        this.birthdate = detailedBioDTO.getBirthdate();
        this.cityOfBirth = detailedBioDTO.getCityOfBirth();
        this.secondNationality = detailedBioDTO.getSecondNationality();
        this.height = detailedBioDTO.getHeight();
        this.previousTeam = detailedBioDTO.getPreviousTeam();
        this.biography = detailedBioDTO.getBiography();
    }
}

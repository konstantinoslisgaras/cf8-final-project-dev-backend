package solipsismal.olympiacosfcapp.service;

import solipsismal.olympiacosfcapp.core.exceptions.CompetitionNotFoundException;
import solipsismal.olympiacosfcapp.dto.CompetitionDTO;
import solipsismal.olympiacosfcapp.dto.CompetitionPositionUpdateDTO;

import java.util.List;

public interface ICompetitionService {
    List<CompetitionDTO> findAll();
    List<CompetitionDTO> findActive();
    CompetitionDTO updateCompetitionPosition(CompetitionPositionUpdateDTO competitionPositionUpdateDTO) throws CompetitionNotFoundException;
}

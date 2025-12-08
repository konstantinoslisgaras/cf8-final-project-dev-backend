package solipsismal.olympiacosfcapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solipsismal.olympiacosfcapp.core.exceptions.CompetitionNotFoundException;
import solipsismal.olympiacosfcapp.dto.CompetitionDTO;
import solipsismal.olympiacosfcapp.dto.CompetitionPositionUpdateDTO;
import solipsismal.olympiacosfcapp.model.Competition;
import solipsismal.olympiacosfcapp.repository.CompetitionRepository;
import java.util.List;

@Service
@Slf4j
public class CompetitionService implements ICompetitionService{

    private final CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public List<CompetitionDTO> findAll() {
        return competitionRepository.findAllByOrderByIdAsc()
                .stream()
                .map(CompetitionDTO::new)
                .toList();
    }

    @Override
    public List<CompetitionDTO> findActive() {
        return competitionRepository.findByIsParticipatingTrueOrderByIdAsc()
                .stream()
                .map(CompetitionDTO::new)
                .toList();
    }

    @Override
    @Transactional
    public CompetitionDTO updateCompetitionPosition(CompetitionPositionUpdateDTO competitionPositionUpdateDTO) throws CompetitionNotFoundException {
        Competition competition = competitionRepository.findById(competitionPositionUpdateDTO.getCompetitionId())
                .orElseThrow(() -> new CompetitionNotFoundException(competitionPositionUpdateDTO.getCompetitionId()));

        competition.setCompetitionPosition(competitionPositionUpdateDTO.getPosition());

        Competition updatedCompetition = competitionRepository.save(competition);

        return new CompetitionDTO(updatedCompetition);
    }
}

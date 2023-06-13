package ca.levio.recruitment.persistence.interview;

import java.util.Optional;

import org.springframework.stereotype.Component;

import ca.levio.recruitment.application.interview.commands.createinterview.port.CreateInterviewPort;
import ca.levio.recruitment.application.interview.commands.createinterview.port.FindJobPositionByNamePort;
import ca.levio.recruitment.application.interview.commands.createinterview.port.FindRecruiterByNamePort;
import ca.levio.recruitment.domain.interview.Interview;
import ca.levio.recruitment.domain.jobposition.JobPosition;
import ca.levio.recruitment.domain.recruiter.Recruiter;
import ca.levio.recruitment.persistence.interview.mapper.CreateInterviewPersistenceMapper;
import ca.levio.recruitment.persistence.jobposition.JobPositionRepository;
import ca.levio.recruitment.persistence.jobposition.entities.JobPositionEntity;
import ca.levio.recruitment.persistence.recruiter.RecruiterRepository;
import ca.levio.recruitment.persistence.recruiter.entities.RecruiterEntity;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class InterviewPersistenceAdapter implements CreateInterviewPort,
        FindRecruiterByNamePort,
        FindJobPositionByNamePort {

    private final InterviewRepository interviewRepository;
    private final JobPositionRepository jobPositionRepository;
    private final RecruiterRepository recruiterRepository;

    private final CreateInterviewPersistenceMapper createInterviewMapper;

    @Override
    public Interview createInterview(Interview interview) {
        return createInterviewMapper
                .mapToDomainObject(interviewRepository.save(createInterviewMapper.mapEntityObject(interview)));
    }

    @Override
    public Optional<Recruiter> findRecruiterByName(String name) {
        Optional<RecruiterEntity> recruiter = recruiterRepository.findByName(name);
        if (recruiter.isEmpty())
            return Optional.empty();

        return Optional.of(createInterviewMapper.mapToDomainObject(recruiter.get()));
    }

    @Override
    public Optional<JobPosition> findJobPositionByName(String name) {
        Optional<JobPositionEntity> jobPosition = jobPositionRepository.findByName(name);
        if (jobPosition.isEmpty())
            return Optional.empty();

        return Optional.of(createInterviewMapper.mapToDomainObject(jobPosition.get()));
    }
}

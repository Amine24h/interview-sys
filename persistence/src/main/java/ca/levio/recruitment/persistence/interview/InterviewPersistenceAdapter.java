package ca.levio.recruitment.persistence.interview;

import java.util.Optional;

import org.springframework.stereotype.Component;

import ca.levio.recruitment.application.interview.commands.createinterview.port.CreateInterviewPort;
import ca.levio.recruitment.application.interview.commands.createinterview.port.FindJobPositionByNamePort;
import ca.levio.recruitment.application.interview.commands.createinterview.port.FindRecruiterByNamePort;
import ca.levio.recruitment.domain.Interview;
import ca.levio.recruitment.domain.JobPosition;
import ca.levio.recruitment.domain.Recruiter;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class InterviewPersistenceAdapter implements CreateInterviewPort,
        FindRecruiterByNamePort,
        FindJobPositionByNamePort {

    private final InterviewRepository interviewRepository;

    @Override
    public Interview createInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public Optional<Recruiter> findRecruiterByName(String name) {
        return interviewRepository.findRecruiterByName(name);
    }

    @Override
    public Optional<JobPosition> findJobPositionByName(String name) {
        return interviewRepository.findJobPositionByName(name);
    }
}

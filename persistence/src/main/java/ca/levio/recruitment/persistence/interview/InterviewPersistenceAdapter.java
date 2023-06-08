package ca.levio.recruitment.persistence.interview;

import org.springframework.stereotype.Component;

import ca.levio.recruitment.application.interview.commands.createinterview.port.CreateInterviewPort;
import ca.levio.recruitment.domain.Interview;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class InterviewPersistenceAdapter implements CreateInterviewPort {

    private final InterviewRepository interviewRepository;

    @Override
    public Interview createInterview(Interview interview) {
        
        return interviewRepository.save(interview);
    }
    
}

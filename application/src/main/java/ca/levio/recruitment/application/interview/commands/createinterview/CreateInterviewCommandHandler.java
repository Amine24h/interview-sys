package ca.levio.recruitment.application.interview.commands.createinterview;

import org.springframework.stereotype.Component;

import ca.levio.recruitment.application.interview.commands.createinterview.dto.CreatedInterviewDto;
import ca.levio.recruitment.application.interview.commands.createinterview.mapper.CreateInterviewMapper;
import ca.levio.recruitment.application.interview.commands.createinterview.port.CreateInterviewPort;
import ca.levio.recruitment.application.interview.commands.createinterview.port.FindJobPositionByNamePort;
import ca.levio.recruitment.application.interview.commands.createinterview.port.FindRecruiterByNamePort;
import ca.levio.recruitment.domain.exceptions.ResourceNotFoundException;
import ca.levio.recruitment.domain.interview.Interview;
import ca.levio.recruitment.domain.jobposition.JobPosition;
import ca.levio.recruitment.domain.recruiter.Recruiter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
class CreateInterviewCommandHandler implements CreateInterviewCommandUseCase {

    private final CreateInterviewPort createInterviewPort;
    private final FindJobPositionByNamePort findJobPositionByNamePort;
    private final FindRecruiterByNamePort findRecruiterByNamePort;
    private final CreateInterviewMapper createInterviewMapper;

    public CreatedInterviewDto handle(CreateInterviewCommand command) {
        Recruiter recruiter = findRecruiterByNamePort.findRecruiterByName(command.getRecruiter())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Recruiter with name '%s' not found", command.getRecruiter())));
        JobPosition jobPosition = findJobPositionByNamePort.findJobPositionByName(command.getJobPosition())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("JobPosition with name '%s' not found", command.getJobPosition())));

        Interview interviewToBeCreated = createInterviewMapper.mapToDomainObject(command, recruiter, jobPosition);
        Interview createdInterview = createInterviewPort.createInterview(interviewToBeCreated);

        return createInterviewMapper.mapToDto(createdInterview);
    }
}

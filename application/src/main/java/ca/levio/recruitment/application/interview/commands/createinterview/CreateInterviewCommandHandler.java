package ca.levio.recruitment.application.interview.commands.createinterview;

import org.springframework.stereotype.Component;

import ca.levio.recruitment.application.interview.commands.createinterview.port.CreateInterviewPort;
import ca.levio.recruitment.domain.Interview;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
class CreateInterviewCommandHandler implements CreateInterviewCommandUseCase {
    
    private final CreateInterviewPort createInterviewPort;

    public void handle(CreateInterviewCommand command) {
        createInterviewPort.createInterview(new Interview());
    }
}

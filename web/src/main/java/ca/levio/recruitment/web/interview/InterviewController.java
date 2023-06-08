package ca.levio.recruitment.web.interview;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ca.levio.recruitment.application.interview.commands.createinterview.CreateInterviewCommand;
import ca.levio.recruitment.application.interview.commands.createinterview.CreateInterviewCommandUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class InterviewController {
    
    private final CreateInterviewCommandUseCase createInterviewCommandUseCase;

    @PostMapping("/interviews")
    public void createInterview(@Valid @RequestBody CreateInterviewCommand command) {
        createInterviewCommandUseCase.handle(command);
    }
}

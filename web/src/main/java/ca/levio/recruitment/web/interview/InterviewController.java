package ca.levio.recruitment.web.interview;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ca.levio.recruitment.application.interview.commands.createinterview.CreateInterviewCommand;
import ca.levio.recruitment.application.interview.commands.createinterview.CreateInterviewCommandUseCase;
import ca.levio.recruitment.application.interview.commands.createinterview.dto.CreatedInterviewDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class InterviewController {
    
    private final CreateInterviewCommandUseCase createInterviewCommandUseCase;

    @PostMapping("/interviews")
    public CreatedInterviewDto createInterview(@Valid @RequestBody CreateInterviewCommand command) {
        return createInterviewCommandUseCase.handle(command);
    }
}

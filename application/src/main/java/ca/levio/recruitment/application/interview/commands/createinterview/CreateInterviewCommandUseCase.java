package ca.levio.recruitment.application.interview.commands.createinterview;

import ca.levio.recruitment.application.interview.commands.createinterview.dto.CreatedInterviewDto;

public interface CreateInterviewCommandUseCase {
    
    CreatedInterviewDto handle(CreateInterviewCommand command);
}

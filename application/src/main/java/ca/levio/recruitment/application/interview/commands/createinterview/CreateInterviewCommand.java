package ca.levio.recruitment.application.interview.commands.createinterview;

import ca.levio.recruitment.common.DataValidator;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class CreateInterviewCommand extends DataValidator<CreateInterviewCommand> {
    
    @NotBlank(message = "The person to interview is mandatory")
    private String personToInterview;
    @NotBlank(message = "The description is mandatory")
    private String description;
    private boolean urgent;
    @NotBlank(message = "The level of expertise is mandatory")
    private String levelOfExpertise;
}

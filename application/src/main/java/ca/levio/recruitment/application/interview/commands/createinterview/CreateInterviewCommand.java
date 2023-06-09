package ca.levio.recruitment.application.interview.commands.createinterview;

import ca.levio.recruitment.common.validation.DataValidator;
import ca.levio.recruitment.common.validation.ValueOfEnum;
import ca.levio.recruitment.domain.technicaladvisor.LevelOfExpertise;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "The level of expertise is mandatory")
    @ValueOfEnum(enumClass = LevelOfExpertise.class)
    private String levelOfExpertise;
    @NotBlank(message = "The recruiter is mandatory")
    private String recruiter;
    @NotBlank(message = "The jobPosition is mandatory")
    private String jobPosition;
}

package ca.levio.recruitment.application.interview.commands.createinterview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedInterviewDto {
    
    private String id;
    private String personToInterview;
    private String description;
    private String urgent;
    private String levelOfExpertise;
    private String recruiter;
    private String jobPosition;
}

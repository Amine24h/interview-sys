package ca.levio.recruitment.domain.technicaladvisor;

import ca.levio.recruitment.domain.jobposition.JobPosition;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(exclude = { "jobPosition" })
@NoArgsConstructor
@AllArgsConstructor
public class Skill {

    private Long id;
    
    LevelOfExpertise levelOfExpertise;
    
    JobPosition jobPosition;

    TechnicalAdvisor technicalAdvisor;
}

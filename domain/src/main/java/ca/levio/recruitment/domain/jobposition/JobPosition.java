package ca.levio.recruitment.domain.jobposition;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(exclude = { "lineOfBusiness", "parent" })
@NoArgsConstructor
@AllArgsConstructor
public class JobPosition {
    
    private Long id;
    
    String name;

    LineOfBusiness lineOfBusiness;

    JobPosition parent;
}

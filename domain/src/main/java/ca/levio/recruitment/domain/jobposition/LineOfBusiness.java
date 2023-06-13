package ca.levio.recruitment.domain.jobposition;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(exclude = { "jobPositions" })
@NoArgsConstructor
@AllArgsConstructor
public class LineOfBusiness {
    
    private Long id;
    
    String name;

    List<JobPosition> jobPositions = new ArrayList<>();
}

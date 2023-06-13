package ca.levio.recruitment.domain.recruiter;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Recruiter {
    
    private Long id;
    
    String name;

    String email;

    boolean active;
}

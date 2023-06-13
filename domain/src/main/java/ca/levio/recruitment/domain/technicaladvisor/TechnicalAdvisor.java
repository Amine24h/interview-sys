package ca.levio.recruitment.domain.technicaladvisor;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(exclude = { "skills" })
@NoArgsConstructor
@AllArgsConstructor
public class TechnicalAdvisor {

    private Long id;
    
    String name;

    String email;

    boolean active;
    
    List<Skill> skills = new ArrayList<>();
}

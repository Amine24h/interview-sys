package ca.levio.recruitment.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
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
@Entity
public class LineOfBusiness {
    
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "line_of_business_gen")
    @SequenceGenerator(name = "line_of_business_gen", sequenceName = "line_of_business_seq", schema = "public", allocationSize = 1)
    private Long id;
    
    @Column(name = "name", nullable = false)
    String name;

    @OneToMany(mappedBy = "lineOfBusiness", cascade = CascadeType.ALL)
    List<JobPosition> jobPositions = new ArrayList<>();
}

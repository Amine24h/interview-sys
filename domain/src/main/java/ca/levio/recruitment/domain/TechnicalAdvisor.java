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
@EqualsAndHashCode(exclude = { "skills" })
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TechnicalAdvisor {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "technical_advisor_gen")
    @SequenceGenerator(name = "technical_advisor_gen", sequenceName = "technical_advisor_seq", schema = "public", allocationSize = 1)
    private Long id;
    
    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "email")
    String email;

    @Column(name = "active")
    boolean active;
    
    @OneToMany(mappedBy = "technicalAdvisor", cascade = CascadeType.ALL)
    List<Skill> skills = new ArrayList<>();
}

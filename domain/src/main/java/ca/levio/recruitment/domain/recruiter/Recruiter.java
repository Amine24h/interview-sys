package ca.levio.recruitment.domain.recruiter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
@Entity
public class Recruiter {
    
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recruiter_gen")
    @SequenceGenerator(name = "recruiter_gen", sequenceName = "recruiter_seq", schema = "public", allocationSize = 1)
    private Long id;
    
    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "email")
    String email;

    @Column(name = "active")
    boolean active;
}

package ca.levio.recruitment.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
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
@Entity
public class JobPosition {
    
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_position_gen")
    @SequenceGenerator(name = "job_position_gen", sequenceName = "job_position_seq", schema = "public", allocationSize = 1)
    private Long id;
    
    @Column(name = "name", nullable = false)
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_of_business_id")
    LineOfBusiness lineOfBusiness;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    JobPosition parent;
}

package ca.levio.recruitment.persistence.technicaladvisor.entities;

import ca.levio.recruitment.domain.technicaladvisor.LevelOfExpertise;
import ca.levio.recruitment.persistence.jobposition.entities.JobPositionEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "skill", schema = "public")
public class SkillEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_gen")
    @SequenceGenerator(name = "skill_gen", sequenceName = "skill_seq", schema = "public", allocationSize = 1)
    private Long id;
    
    @Column(name = "level_of_expertise")
    @Enumerated(EnumType.STRING)
    LevelOfExpertise levelOfExpertise;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_position_id")
    JobPositionEntity jobPosition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technical_advisor_id")
    TechnicalAdvisorEntity technicalAdvisor;
}

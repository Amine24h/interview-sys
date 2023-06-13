package ca.levio.recruitment.persistence.interview.entities;

import java.util.ArrayList;
import java.util.List;

import ca.levio.recruitment.domain.technicaladvisor.LevelOfExpertise;
import ca.levio.recruitment.persistence.jobposition.entities.JobPositionEntity;
import ca.levio.recruitment.persistence.recruiter.entities.RecruiterEntity;
import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(exclude = { "recruiter", "jobPosition", "interviewRequests" })
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "interview", schema = "public")
public class InterviewEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interview_gen")
    @SequenceGenerator(name = "interview_gen", sequenceName = "interview_seq", schema = "public", allocationSize = 1)
    private Long id;
    
    @Column(name = "person_to_interview", nullable = false)
    private String personToInterview;

    @Column(name = "description")
    private String description;

    @Column(name = "urgent")
    private boolean urgent;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private LevelOfExpertise levelOfExpertise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruiter_id")
    private RecruiterEntity recruiter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_position_id")
    private JobPositionEntity jobPosition;

    @OneToMany(mappedBy = "interview", cascade = CascadeType.ALL)
    private List<InterviewRequestEntity> interviewRequests = new ArrayList<>();
}

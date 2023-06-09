package ca.levio.recruitment.domain.interview;

import java.util.ArrayList;
import java.util.List;

import ca.levio.recruitment.domain.jobposition.JobPosition;
import ca.levio.recruitment.domain.recruiter.Recruiter;
import ca.levio.recruitment.domain.technicaladvisor.LevelOfExpertise;
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
public class Interview {

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
    private Recruiter recruiter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @OneToMany(mappedBy = "interview", cascade = CascadeType.ALL)
    private List<InterviewRequest> interviewRequests = new ArrayList<>();
}

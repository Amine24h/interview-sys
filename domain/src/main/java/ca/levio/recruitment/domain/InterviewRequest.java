package ca.levio.recruitment.domain;

import java.time.LocalDateTime;

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
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(exclude = { "interview", "technicalAdvisor" })
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InterviewRequest {
    
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interview_request_gen")
    @SequenceGenerator(name = "interview_request_gen", sequenceName = "interview_request_seq", schema = "public", allocationSize = 1)
    private Long id;

    @Column(name = "request_date")
    LocalDateTime requestDate;

    @Column(name = "response_date")
    LocalDateTime responseDate;

    @Column(name = "response_order")
    Integer responseOrder;

    @Column(name = "comment")
    String comment;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    InterviewRequestStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_id")
    Interview interview;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technical_advisor_id")
    TechnicalAdvisor technicalAdvisor;
}

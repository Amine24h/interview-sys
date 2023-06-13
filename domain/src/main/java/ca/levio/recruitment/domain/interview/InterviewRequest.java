package ca.levio.recruitment.domain.interview;

import java.time.LocalDateTime;

import ca.levio.recruitment.domain.technicaladvisor.TechnicalAdvisor;
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
public class InterviewRequest {
    
    private Long id;

    LocalDateTime requestDate;

    LocalDateTime responseDate;

    Integer responseOrder;

    String comment;

    InterviewRequestStatus status;

    Interview interview;

    TechnicalAdvisor technicalAdvisor;
}

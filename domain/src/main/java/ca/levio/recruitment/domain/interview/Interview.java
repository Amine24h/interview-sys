package ca.levio.recruitment.domain.interview;

import java.util.ArrayList;
import java.util.List;

import ca.levio.recruitment.domain.jobposition.JobPosition;
import ca.levio.recruitment.domain.recruiter.Recruiter;
import ca.levio.recruitment.domain.technicaladvisor.LevelOfExpertise;
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
public class Interview {

    private Long id;

    private String personToInterview;

    private String description;

    private boolean urgent;

    private LevelOfExpertise levelOfExpertise;

    private Recruiter recruiter;

    private JobPosition jobPosition;

    private List<InterviewRequest> interviewRequests = new ArrayList<>();
}

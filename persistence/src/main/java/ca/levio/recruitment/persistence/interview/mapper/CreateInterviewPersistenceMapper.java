package ca.levio.recruitment.persistence.interview.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ca.levio.recruitment.domain.interview.Interview;
import ca.levio.recruitment.domain.jobposition.JobPosition;
import ca.levio.recruitment.domain.recruiter.Recruiter;
import ca.levio.recruitment.persistence.interview.entities.InterviewEntity;
import ca.levio.recruitment.persistence.jobposition.entities.JobPositionEntity;
import ca.levio.recruitment.persistence.recruiter.entities.RecruiterEntity;

@Mapper(componentModel = "spring")
public interface CreateInterviewPersistenceMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "interviewRequests", ignore = true)
    InterviewEntity mapEntityObject(Interview interview);

    @Mapping(target = "id", source = "id")
    Interview mapToDomainObject(InterviewEntity interviewEntity);

    Recruiter mapToDomainObject(RecruiterEntity recruiterEntity);

    JobPosition mapToDomainObject(JobPositionEntity jobPositionEntity);
}

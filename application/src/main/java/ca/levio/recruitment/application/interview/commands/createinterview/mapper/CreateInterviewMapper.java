package ca.levio.recruitment.application.interview.commands.createinterview.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ca.levio.recruitment.application.interview.commands.createinterview.CreateInterviewCommand;
import ca.levio.recruitment.application.interview.commands.createinterview.dto.CreatedInterviewDto;
import ca.levio.recruitment.domain.interview.Interview;
import ca.levio.recruitment.domain.jobposition.JobPosition;
import ca.levio.recruitment.domain.recruiter.Recruiter;

@Mapper(componentModel = "spring")
public interface CreateInterviewMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "interviewRequests", ignore = true)
    @Mapping(target = "recruiter", source = "recruiter")
    @Mapping(target = "jobPosition", source = "jobPosition")
    Interview mapToDomainObject(CreateInterviewCommand createInterviewCommand, Recruiter recruiter, JobPosition jobPosition);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "jobPosition", source = "jobPosition.name")
    @Mapping(target = "recruiter", source = "recruiter.name")
    CreatedInterviewDto mapToDto(Interview interview);
}

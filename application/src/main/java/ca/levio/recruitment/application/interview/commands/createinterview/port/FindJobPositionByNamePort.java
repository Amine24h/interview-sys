package ca.levio.recruitment.application.interview.commands.createinterview.port;

import java.util.Optional;

import ca.levio.recruitment.domain.JobPosition;

public interface FindJobPositionByNamePort {
        
        Optional<JobPosition> findJobPositionByName(String name);
}

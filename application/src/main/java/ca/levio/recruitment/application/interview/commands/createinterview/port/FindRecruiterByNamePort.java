package ca.levio.recruitment.application.interview.commands.createinterview.port;

import java.util.Optional;

import ca.levio.recruitment.domain.recruiter.Recruiter;

public interface FindRecruiterByNamePort {
    
    Optional<Recruiter> findRecruiterByName(String name);
}

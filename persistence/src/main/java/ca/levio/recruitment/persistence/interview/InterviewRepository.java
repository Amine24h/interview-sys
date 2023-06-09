package ca.levio.recruitment.persistence.interview;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ca.levio.recruitment.domain.interview.Interview;
import ca.levio.recruitment.domain.jobposition.JobPosition;
import ca.levio.recruitment.domain.recruiter.Recruiter;

interface InterviewRepository extends JpaRepository<Interview, Long> {

    @Query("""
        SELECT r FROM Recruiter r 
        WHERE r.name = :name
        """)
    Optional<Recruiter> findRecruiterByName(String name);

    @Query("""
        SELECT jp FROM JobPosition jp 
        WHERE jp.name = :name
        """)
    Optional<JobPosition> findJobPositionByName(String name);
}

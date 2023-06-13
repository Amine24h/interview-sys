package ca.levio.recruitment.persistence.recruiter;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.levio.recruitment.persistence.recruiter.entities.RecruiterEntity;

public interface RecruiterRepository extends JpaRepository<RecruiterEntity, Long> {

    Optional<RecruiterEntity> findByName(String name);
}

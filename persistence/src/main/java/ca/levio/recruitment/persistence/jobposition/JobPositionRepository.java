package ca.levio.recruitment.persistence.jobposition;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.levio.recruitment.persistence.jobposition.entities.JobPositionEntity;

public interface JobPositionRepository extends JpaRepository<JobPositionEntity, Long> {
    
    Optional<JobPositionEntity> findByName(String name);
}

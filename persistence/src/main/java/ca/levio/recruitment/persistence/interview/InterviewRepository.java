package ca.levio.recruitment.persistence.interview;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.levio.recruitment.persistence.interview.entities.InterviewEntity;

interface InterviewRepository extends JpaRepository<InterviewEntity, Long> {

}

package ca.levio.recruitment.persistence.interview;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.levio.recruitment.domain.Interview;

interface InterviewRepository extends JpaRepository<Interview, Long> {

}

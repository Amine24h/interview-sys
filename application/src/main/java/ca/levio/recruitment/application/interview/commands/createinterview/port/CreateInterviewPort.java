package ca.levio.recruitment.application.interview.commands.createinterview.port;

import ca.levio.recruitment.domain.interview.Interview;

public interface CreateInterviewPort {

    Interview createInterview(Interview interview);
}

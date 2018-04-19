package isabel.vestli.seminar.service;

import isabel.vestli.seminar.model.CourseParticipant;
import isabel.vestli.seminar.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    ParticipantRepository participantRepository;

    public List<CourseParticipant> getParticipantsByCourseId(Long courseId) {
        return participantRepository.findCourseParticipantByCourseId(courseId);
    }
}

package isabel.vestli.seminar.repository;

import isabel.vestli.seminar.model.CourseParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<CourseParticipant, Long> {

    @Query("SELECT participant.firstName, participant.lastName FROM CourseParticipant participant WHERE course_id = :courseId")
    List<CourseParticipant> findCourseParticipantByCourseId(@Param("courseId") Long courseId);
}

package isabel.vestli.seminar.repository;

import isabel.vestli.seminar.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    /*@Query("SELECT course FROM Course cource WHERE LOWER(cource.courseName) = LOWER(:searchString)" +
            " OR LOWER(cource.instructor) = LOWER(:searchString) OR LOWER(cource.room) = LOWER(:searchString)")*/
    List<Course> findCourseByCourseNameOrInstructorOrRoom(String courseName, String instructor, String room);

    //@Query("SELECT course FROM Course cource WHERE LOWER(cource.startTime) LIKE LOWER(:startTime)")
    List<Course> findCourseByStartTimeContaining(@Param("startTime") LocalDateTime startTime);
}

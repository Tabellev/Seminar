package isabel.vestli.seminar.service;

import isabel.vestli.seminar.model.Course;
import isabel.vestli.seminar.repository.CourseRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Transactional
    public Course getCourseById(long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        course.ifPresent(c -> Hibernate.initialize(c.getParticipants()));
        return course.orElse(null);
    }

    @Transactional
    public List<Course> getAllCourses() {
        List<Course> allCourses = courseRepository.findAll();
        allCourses.forEach(course -> Hibernate.initialize(course.getParticipants()));
        return allCourses;
    }

    @Transactional
    public List<Course> getCoursesBySearch(String searchString) {
        List<Course> courses = courseRepository.findCourseByCourseNameOrInstructorOrRoom(searchString, searchString, searchString);
        courses.forEach(course -> Hibernate.initialize(course.getParticipants()));
        return courses;

    }

    @Transactional
    public List<Course> getCoursesByStartTime(LocalDateTime startTime) {
        List<Course> courses = courseRepository.findCourseByStartTimeContaining(startTime);
        courses.forEach(course -> Hibernate.initialize(course.getParticipants()));
        return courses;
    }

    public void deleteCourseById(long courseId) {
        courseRepository.deleteById(courseId);
    }
}

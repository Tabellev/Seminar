package isabel.vestli.seminar;

import isabel.vestli.seminar.model.Course;
import isabel.vestli.seminar.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootApplication
public class SeminarApplication implements CommandLineRunner {

    @Autowired
    CourseRepository courseRepository;
    public static void main(String[] args) {
        SpringApplication.run(SeminarApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*addCourse();
        Course course = getCourse();
        System.out.println(course);*/
    }

    private void addCourse() {
        Course course = new Course();
        course.setCourseName("Kurs1");
        course.setInstructor("Isabel");
        course.setRoom("Rom1");
        course.setStartTime(LocalDateTime.now());
        course.setEndTime(LocalDateTime.now().plusHours(2));

        courseRepository.save(course);
    }

    private Course getCourse() {
        return courseRepository.findById(1L).get();
    }

}

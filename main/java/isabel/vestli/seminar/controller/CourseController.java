package isabel.vestli.seminar.controller;

import isabel.vestli.seminar.model.Course;
import isabel.vestli.seminar.service.CourseService;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Path("resource/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public void saveCourse(Course course) {
        courseService.saveCourse(course);
    }

    @GET
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Course getCource(@PathParam("courseId") long courseid) {
        return courseService.getCourseById(courseid);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GET
    @Path("/{searchString}/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCoursesBySearch(@PathParam("searchString") String searchString) {
        return courseService.getCoursesBySearch(searchString);
    }

    @GET
    @Path("/{startTime}/startTime")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourseByStartTime(@PathParam("startTime") String startTime) {
        LocalDateTime localDateTime = LocalDateTime.parse(startTime);
        return courseService.getCoursesByStartTime(localDateTime);
    }

    @DELETE
    @Path("/{courseId}/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCourse(@PathParam("courseId") long courseId) {
        courseService.deleteCourseById(courseId);
    }
}

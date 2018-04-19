package isabel.vestli.seminar.controller;

import isabel.vestli.seminar.model.CourseParticipant;
import isabel.vestli.seminar.service.ParticipantService;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/resource/participant")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GET
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CourseParticipant> getParticipantsByCourceId(@PathParam("courseId") Long courseId){
        return participantService.getParticipantsByCourseId(courseId);
    }
}

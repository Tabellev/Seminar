package isabel.vestli.seminar;

import isabel.vestli.seminar.controller.CourseController;
import isabel.vestli.seminar.controller.ParticipantController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("rest")
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
    }

    @PostConstruct
    public void setUp() {
        register(CourseController.class);
        register(ParticipantController.class);
        //register(GenericExceptionMapper.class);
    }
}

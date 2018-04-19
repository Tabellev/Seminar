package isabel.vestli.seminar.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "course", uniqueConstraints = @UniqueConstraint(columnNames = {"room", "startTime"}))
public class Course {

    private Long id;
    private String courseName;
    private String instructor;
    private String room;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<CourseParticipant> participants;

    public Course() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JoinColumn(name = "course_id")
    public List<CourseParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<CourseParticipant> participants) {
        this.participants = participants;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

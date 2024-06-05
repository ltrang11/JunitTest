import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class AcademicTest {


    @Test
    public void testAddContentWithNullCourse() {
        Academic academic = new Academic("user1", "pass1", "A123");
        assertThrows(NullPointerException.class, () -> {
            academic.addContent(null, "Sample content");
        });
    }

    @Test
    public void testAddAssignmentWithValidCourse() {
        Academic academic = new Academic("user1", "pass1", "A123");
        Assignment assignment = new Assignment("Assignment 1", new Course("Math"), LocalDate.now());
        Course course = new Course("Math");
        academic.addAssignment(course, assignment);
        assertEquals(1, course.getAssignments().size());
    }

    @Test
    public void testCommunicateThroughForumWithValidForum() {
        Academic academic = new Academic("user1", "pass1", "A123");
        DiscussionForum forum = new DiscussionForum();
        academic.communicateThroughForum(forum, "Message");
        assertDoesNotThrow(() -> academic.communicateThroughForum(forum, "Message"));
    }
}

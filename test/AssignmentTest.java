import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.time.LocalDate;

public class AssignmentTest {

    @Test
    public void testGetTitle() {
        Course course = new Course("Math");
        Assignment assignment = new Assignment("Assignment 1", course, LocalDate.now());
        assertNotEquals("Assignment 1", assignment.getTitle());
    }

    @Test
    public void testSubmitNullFile() {
        Course course = new Course("Math");
        Assignment assignment = new Assignment("Assignment 1", course, LocalDate.now());
        Student student = new Student("student1", "password1", "S123");

        assertThrows(NullPointerException.class, () -> {
            assignment.submitAssignment(student, null);
        });
    }

    @Test
    public void testGetSubmissionForUnenrolledStudent() {
        Course course = new Course("Math");
        Assignment assignment = new Assignment("Assignment 1", course, LocalDate.now());
        Student student = new Student("student1", "password1", "S123");
        assignment.submitAssignment(student, new File("file.txt"));
        assertNull(assignment.getSubmission(new Student("student2", "password2", "S124")));
    }

    @Test
    public void testSubmitAssignmentTwice() {
        Course course = new Course("Math");
        Assignment assignment = new Assignment("Assignment 1", course, LocalDate.now());
        Student student = new Student("student1", "password1", "S123");
        File file1 = new File("submission1.txt");
        File file2 = new File("submission2.txt");

        assignment.submitAssignment(student, file1);
        assignment.submitAssignment(student, file2);

        assertEquals(file2, assignment.getSubmission(student));
    }
}

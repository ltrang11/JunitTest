
import java.time.LocalDate;

public class CourseTest {
    public static void main(String[] args) {
        Course course = new Course("CourseTitle", "CourseCode");

        // Test 1: Adding Duplicate Assignment
        Assignment assignment = new Assignment("Title", "Description", LocalDate.now().plusDays(1));
        course.addAssignment(assignment);
        try {
            course.addAssignment(assignment);
        } catch (Exception e) {
            System.out.println("Caught exception as expected: " + e.getMessage());
        }

        // Test 2: Adding Null Assignment
        try {
            course.addAssignment(null);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException as expected.");
        }
    }
}


import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class MainTest {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Test 1: Null User Logging In
        try {
            sessionManager.login(null);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException as expected.");
        }

        // Test 2: Invalid File Path for Assignment Upload
        Student student = new Student("username", "password", "studentId");
        Assignment assignment = new Assignment("Title", "Description", LocalDate.now().plusDays(1));
        try {
            student.uploadAssignment(assignment, new File("invalid/path/to/file.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException as expected.");
        }
    }
}

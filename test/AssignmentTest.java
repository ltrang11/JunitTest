
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class AssignmentTest {
    public static void main(String[] args) {
        // Test 1: Invalid File Type Upload
        Assignment assignment = new Assignment("Title", "Description", LocalDate.now().plusDays(1));
        File file = new File("non_existent_file.txt");
        try {
            assignment.uploadAssignment(file);
        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException as expected.");
        }

        // Test 2: Past Due Date for Assignment
        Assignment pastDueAssignment = new Assignment("Title", "Description", LocalDate.now().minusDays(1));
        File validFile = new File("valid_file.txt");
        try {
            pastDueAssignment.uploadAssignment(validFile);
        } catch (Exception e) {
            System.out.println("Caught exception as expected: " + e.getMessage());
        }
    }
}

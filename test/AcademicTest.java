
public class AcademicTest {
    public static void main(String[] args) {
        Academic academic = new Academic("username", "password", "academicId");

        // Test 1: Null Course when Adding Content
        try {
            academic.addContent(null, "Content");
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException as expected.");
        }

        // Test 2: Null Content when Adding Content
        Course course = new Course("CourseTitle", "CourseCode");
        try {
            academic.addContent(course, null);
        } catch (Exception e) {
            System.out.println("Caught exception as expected: " + e.getMessage());
        }
    }
}

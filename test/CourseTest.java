import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CourseTest {

    @Test
    public void testAddNullStudent() {
        Course course = new Course("Math");
        assertThrows(NullPointerException.class, () -> {
            course.enrollStudent(null);
        });
    }

    @Test
    public void testGetGradeForUnenrolledStudent() {
        Course course = new Course("Math");
        Student student = new Student("student1", "password1", "S123");
        assertNull(course.getGrade(student));
    }

    @Test
    public void testAddNullContent() {
        Course course = new Course("Math");
        assertThrows(NullPointerException.class, () -> {
            course.addContent(null);
        });
    }

    @Test
    public void testEnrollStudentTwice() {
        Course course = new Course("Math");
        Student student = new Student("student1", "password1", "S123");
        course.enrollStudent(student);
        assertThrows(IllegalArgumentException.class, () -> {
            course.enrollStudent(student);
        });
    }
}

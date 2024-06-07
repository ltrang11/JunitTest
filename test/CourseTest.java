import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CourseTest {

    @Test
    @DisplayName("C01 - Add Null Student")
    public void testAddNullStudent() {
        Course course = new Course("Math");
        assertThrows(NullPointerException.class, () -> {
            course.enrollStudent(null);
        });
    }

    @Test
    @DisplayName("C02 - Add Null Content" )
    public void testAddNullContent() {
        Course course = new Course("Math");
        assertThrows(NullPointerException.class, () -> {
            course.addContent(null);
        });
    }

    @Test
    @DisplayName("C03 - Enroll Student Twice" )
    public void testEnrollStudentTwice() {
        Course course = new Course("Math");
        Student student = new Student("student1", "password1", "S123");
        course.enrollStudent(student);
        assertThrows(IllegalArgumentException.class, () -> {
            course.enrollStudent(student);
        });
    }
}

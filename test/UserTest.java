import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    Student student1 = new Student("Student1", "password1", "S01");
    Student student2 = new Student("Student2", "123", "S01");
    Academic academic = new Academic("academic1", "1423", "A123");
    SessionManager sessionManager = new SessionManager();
    Course course = new Course("Java");

    @Test
    @DisplayName("U01 - Test Authenticate" )
    void authenticate() {
        assertAll(
                () -> assertFalse(student1.authenticate("wrong password")),
                () -> assertFalse(student1.authenticate("PASSWORD1")),
                () -> assertTrue(student1.authenticate("password1")),
                () -> assertFalse(student2.authenticate("password1")),
                () -> assertTrue(student2.authenticate("123")),
                () -> assertFalse(academic.authenticate("PASSWORD")),
                () -> assertTrue(academic.authenticate("1423"))
        );

    }

    /**
     * After logout, student can still check their grade => Logout function is not work.
     */
    @Test
    @DisplayName("U02 - Test Logout" )
    void logout() {
        course.addGrade(student1, new Grade("HD"));
        sessionManager.login(student1);
        assertEquals("HD", student1.checkGrades(course));
        sessionManager.logout(student1);
        assertEquals("No grade available for this course.", student1.checkGrades(course));

    }
}
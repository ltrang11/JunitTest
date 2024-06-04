import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    Student student1 = new Student("Student1", "password1", "S01");
    Student student2 = new Student("Student2", "123", "S01");
    Academic academic = new Academic("academic1", "1423", "A123");

//    @Test
//    void getUsername() {
//    }
//
//    @Test
//    void getPassword() {
//    }

    @Test
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

    @Test
    void logout() {
    }
}
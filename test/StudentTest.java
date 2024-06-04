import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student1;
    Student student2;
    Course course1;
    Course course2;
    Assignment assignment1;
    Assignment assignment2;
    Assignment assignment3;
    String dateString = "2024-06-10";
    LocalDate assignmentDueDate = LocalDate.parse(dateString);
    File file = new File("assignment", ".txt");


    @BeforeEach
    void setup() {
        student1 = new Student("Student1", "password1", "S01");
        student2 = new Student("Student2", "123", "S01");
        course1 = new Course("CP1");
        course1.addContent("slides");
        course1.addContent("video");
        course2 = new Course("Data Science");
        course1.enrollStudent(student1);
        course2.enrollStudent(student1);
        course2.enrollStudent(student2);

        assignment1 = new Assignment("Practical 1", course1, assignmentDueDate);
        assignment2 = new Assignment("Report", course1, assignmentDueDate);
        assignment2 = new Assignment("Presentation", course2, assignmentDueDate);


    }


    @Test
    void getStudentId() {
    }

    @Test
    void accessCourseMaterial() {
        String expect = "slides\n" +
                "video\n";
        String result = "";
        List<String> materials = student1.accessCourseMaterial(course1);
        for (String value : materials) {
            result += value + "\n";
        }
        assertEquals(expect,result);
        assertNull(student2.accessCourseMaterial(course1));
    }

    @Test
    void uploadAssignmentWithEnrolledStudent() {
        student1.uploadAssignment(assignment1, file);
        assertNotNull(assignment1.getSubmission(student1));
    }

    /**
     * Student2 don't enroll course 1
     * => Student 2 can't upload assignment 1 of course 1
     * => Test case fail because this function don't check enrollment.
     */
    @Test
    void uploadAssignmentWithInenrolledStudent() {
        student2.uploadAssignment(assignment1, file);
        assertNull(assignment1.getSubmission(student2));
    }


    @Test
    void checkGradesWithEnrolledStudent() {
        course1.addGrade(student1, new Grade("HD"));
        course2.addGrade(student2, new Grade("add wrong grade"));
        assertEquals("HD", student1.checkGrades(course1) );
        assertEquals("add wrong grade", student2.checkGrades(course2));

    }

    /**
     * Student2 don't enroll course 1
     * => course 1 can't add grade of student 2
     * => Test case fail because this function don't check enrollment.
     */
    @Test
    void checkGradesInerollesStudent() {
        course1.addGrade(student2, new Grade("D"));
        assertEquals("You are not enrolled in this course.", student2.checkGrades(course1));

    }

    @Test
    void accessExam() {
    }
}
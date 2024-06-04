import java.time.LocalDate;

public class Exam {
    private String title;
    private Course course;
    private LocalDate examDate;

    public Exam(String title, Course course, LocalDate examDate) {
        this.title = title;
        this.course = course;
        this.examDate = examDate;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void accessExam(Student student) {
        if (course.isEnrolled(student)) {
            System.out.println("Accessing exam: " + title);
        } else {
            System.out.println("You are not enrolled in this course.");
        }
    }
}

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

    public Course getCourse() {
        return course;
    }

    public LocalDate getExamDate() {
        return examDate;
    }
}

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Assignment {
    private String title;
    private Course course;
    private LocalDate dueDate;
    private Map<Student, File> submissions = new HashMap<>();

    public Assignment(String title, Course course, LocalDate dueDate) {
        this.title = title;
        this.course = course;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void submitAssignment(Student student, File file) {
        submissions.put(student, file);
    }

    public File getSubmission(Student student) {
        return submissions.get(student);
    }
}

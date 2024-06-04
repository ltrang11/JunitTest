import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Course {
    private String name;
    private List<Student> enrolledStudents = new ArrayList<>();
    private List<String> materials = new ArrayList<>();
    private Map<Student, Grade> grades = new HashMap<>();
    private List<Assignment> assignments = new ArrayList<>();
    private List<Exam> exams = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public boolean isEnrolled(Student student) {
        return enrolledStudents.contains(student);
    }

    public void addContent(String content) {
        materials.add(content);
    }

    public List<String> getMaterials() {
        return materials;
    }

    public Grade getGrade(Student student) {
        return grades.get(student);
    }

    public void addGrade(Student student, Grade grade) {
        grades.put(student, grade);
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }

    public List<Exam> getExams() {
        return exams;
    }
}

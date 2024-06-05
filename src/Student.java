import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private String studentId;
    private List<Course> enrolledCourses = new ArrayList<>();

    public Student(String username, String password, String studentId) {
        super(username, password);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }
    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        course.enrollStudent(this);
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }
    public List<String> accessCourseMaterial(Course course) {
        if (course.isEnrolled(this)) {
            return course.getMaterials();
        } else {
            System.out.println("You are not enrolled in this course.");
            return null;
        }
    }

    public void uploadAssignment(Assignment assignment, File file) {
        assignment.submitAssignment(this, file);
    }

    public List<Assignment> getSubmittedAssignments(Course course) {
        List<Assignment> submittedAssignments = new ArrayList<>();
        for (Assignment assignment : course.getAssignments()) {
            if (assignment.getSubmission(this) != null) {
                submittedAssignments.add(assignment);
            }
        }
        return submittedAssignments;
    }

    public String checkGrades(Course course) {
        Grade grade = course.getGrade(this);
        if (grade != null) {
            return grade.getGrade();
        } else {
            return "No grade available for this course.";
        }
    }

    public String accessExam(Exam exam) {
        if (exam.getCourse().isEnrolled(this)) {
            return "Access granted to " + exam.getTitle();
        } else {
            return "Access denied to " + exam.getTitle();
        }
    }

    public String getSchedule(String period, AcademicCalendar calendar) {
        StringBuilder schedule = new StringBuilder();
        for (Course course : enrolledCourses) {
            schedule.append("Course: ").append(course.getName()).append("\n");
            schedule.append(calendar.displaySchedule(course, period)).append("\n");
        }
        return schedule.toString();
    }
}

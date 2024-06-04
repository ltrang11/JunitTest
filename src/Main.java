import java.io.File;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Learning Management System!");
        System.out.println("Please login:");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Assuming student and academic users are pre-defined
        Student student = new Student("student1", "password1", "S123");
        Academic academic = new Academic("academic1", "password1", "A123");

        // User login and authentication
        if (student.getUsername().equals(username) && student.authenticate(password)) {
            sessionManager.login(student);
        } else if (academic.getUsername().equals(username) && academic.authenticate(password)) {
            sessionManager.login(academic);
        } else {
            System.out.println("Invalid username or password. Exiting...");
            return;
        }

        Course course = new Course("Java Programming");
        course.enrollStudent(student);

        LocalDate dueDate = LocalDate.now().plusDays(7);
        Assignment assignment = new Assignment("Homework 1", course, dueDate);

        LocalDate examDate = LocalDate.now().plusWeeks(2);
        Exam exam = new Exam("Midterm Exam", course, examDate);

        academic.addAssignment(course, assignment);
        academic.addExam(course, exam);

        course.addGrade(student, new Grade("A"));

        DiscussionForum forum = new DiscussionForum();

        // Performing actions
        if (sessionManager.isAuthenticated(student)) {
            System.out.println("Accessing course material...");
            List<String> materials = student.accessCourseMaterial(course);
            if (materials != null) {
                for (String material : materials) {
                    System.out.println(material);
                }
            }

            System.out.println("Please provide the file path to upload assignment:");
            String filePath = scanner.nextLine();
            File file = new File(filePath);
            student.uploadAssignment(assignment, file);
            student.checkGrades(course);
            student.accessExam(exam);

            System.out.println("Submitted assignments:");
            List<Assignment> submittedAssignments = student.getSubmittedAssignments(course);
            for (Assignment submittedAssignment : submittedAssignments) {
                System.out.println(submittedAssignment.getTitle());
            }
        }

        if (sessionManager.isAuthenticated(academic)) {
            System.out.println("Adding course content...");
            academic.addContent(course, "Java Basics");
            academic.addContent(course, "Advanced Java");
            academic.communicateThroughForum(forum, "Please read chapter 1.");
        }

        System.out.println("Displaying forum messages:");
        forum.displayMessages();

        AcademicCalendar calendar = new AcademicCalendar();

        // Display schedule
        System.out.println("Please enter the period to display (week/month/semester):");
        String period = scanner.nextLine();
        System.out.println("Displaying schedule for " + period + ":");
        calendar.displaySchedule(course, period);

        // User logout
        if (sessionManager.isAuthenticated(student)) {
            student.logout(sessionManager);
        }
        if (sessionManager.isAuthenticated(academic)) {
            academic.logout(sessionManager);
        }
    }
}

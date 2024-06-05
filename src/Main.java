import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create sample users
        Student student = new Student("student1", "password1", "S123");
        Academic academic = new Academic("academic1", "password1", "A123");

        // Simulate login
        System.out.println("Simulating login...");
        if (student.getUsername().equals("student1") && student.authenticate("password1")) {
            sessionManager.login(student);
        } else if (academic.getUsername().equals("academic1") && academic.authenticate("password1")) {
            sessionManager.login(academic);
        } else {
            System.out.println("Invalid username or password. Exiting...");
            return;
        }

        // Create courses
        Course course1 = new Course("Java Programming");
        Course course2 = new Course("Data Structures");

        // Enroll student in courses
        student.enrollInCourse(course1);
        student.enrollInCourse(course2);

        // Create assignments and exams
        LocalDate dueDate1 = LocalDate.now().plusDays(7);
        Assignment assignment1 = new Assignment("Homework 1", course1, dueDate1);

        LocalDate dueDate2 = LocalDate.now().plusDays(14);
        Assignment assignment2 = new Assignment("Homework 2", course2, dueDate2);

        LocalDate examDate1 = LocalDate.now().plusWeeks(2);
        Exam exam1 = new Exam("Midterm Exam", course1, examDate1);

        LocalDate examDate2 = LocalDate.now().plusWeeks(4);
        Exam exam2 = new Exam("Final Exam", course2, examDate2);

        // Add assignments and exams to courses
        academic.addAssignment(course1, assignment1);
        academic.addAssignment(course2, assignment2);
        academic.addExam(course1, exam1);
        academic.addExam(course2, exam2);

        // Add grades to courses
        course1.addGrade(student, new Grade("A"));
        course2.addGrade(student, new Grade("B"));

        // Create discussion forum
        DiscussionForum forum = new DiscussionForum();

        // Perform student actions
        if (sessionManager.isAuthenticated(student)) {
            System.out.println("Accessing course material...");
            List<String> materials = student.accessCourseMaterial(course1);
            if (materials != null) {
                for (String material : materials) {
                    System.out.println(material);
                }
            }

            // Upload assignment
            File file = new File("path/to/assignment1.txt");
            student.uploadAssignment(assignment1, file);

            // Check grades
            String grade = student.checkGrades(course1);
            System.out.println("Your grade for Java Programming is: " + grade);

            // Access exam
            String examAccessMessage = student.accessExam(exam1);
            System.out.println(examAccessMessage);

            // Display submitted assignments
            System.out.println("Submitted assignments:");
            List<Assignment> submittedAssignments = student.getSubmittedAssignments(course1);
            for (Assignment submittedAssignment : submittedAssignments) {
                System.out.println(submittedAssignment.getTitle());
            }

            // Display schedule
            String period = "week";  // Change as needed: "week", "month", "semester"
            AcademicCalendar calendar = new AcademicCalendar();
            String schedule = student.getSchedule(period, calendar);
            System.out.println("Your schedule for the next " + period + ":\n" + schedule);
        }

        // Perform academic actions
        if (sessionManager.isAuthenticated(academic)) {
            System.out.println("Adding course content...");
            academic.addContent(course1, "Java Basics");
            academic.addContent(course1, "Advanced Java");
            academic.addContent(course2, "Introduction to Data Structures");
            academic.addContent(course2, "Advanced Data Structures");
            academic.communicateThroughForum(forum, "Please read chapter 1.");
        }

        // Display forum messages
        System.out.println("Displaying forum messages:");
        List<String> forumMessages = forum.displayMessages();
        for (String message : forumMessages) {
            System.out.println(message);
        }

        // Logout users
        if (sessionManager.isAuthenticated(student)) {
            student.logout(sessionManager);
        }
        if (sessionManager.isAuthenticated(academic)) {
            academic.logout(sessionManager);
        }
    }
}

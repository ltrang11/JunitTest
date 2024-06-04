import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AcademicCalendar {
    public List<Assignment> getAssignments(Course course, String period) {
        LocalDate currentDate = LocalDate.now();
        LocalDate endDate = null;
        switch (period) {
            case "week":
                endDate = currentDate.plusWeeks(1);
                break;
            case "month":
                endDate = currentDate.plusMonths(1);
                break;
            case "semester":
                endDate = currentDate.plusMonths(6);
                break;
        }

        List<Assignment> filteredAssignments = new ArrayList<>();
        for (Assignment assignment : course.getAssignments()) {
            if (!assignment.getDueDate().isBefore(currentDate) && assignment.getDueDate().isBefore(endDate)) {
                filteredAssignments.add(assignment);
            }
        }

        return filteredAssignments;
    }

    public void displaySchedule(Course course, String period) {
        List<Assignment> assignments = getAssignments(course, period);
        System.out.println("Assignments due in the next " + period + ":");
        for (Assignment assignment : assignments) {
            System.out.println(assignment.getTitle() + " - Due: " + assignment.getDueDate());
        }

        List<Exam> exams = course.getExams();
        LocalDate currentDate = LocalDate.now();
        LocalDate endDate = null;
        switch (period) {
            case "week":
                endDate = currentDate.plusWeeks(1);
                break;
            case "month":
                endDate = currentDate.plusMonths(1);
                break;
            case "semester":
                endDate = currentDate.plusMonths(6);
                break;
        }

        System.out.println("Exams scheduled in the next " + period + ":");
        for (Exam exam : exams) {
            if (!exam.getExamDate().isBefore(currentDate) && exam.getExamDate().isBefore(endDate)) {
                System.out.println(exam.getTitle() + " - Scheduled: " + exam.getExamDate());
            }
        }
    }
}

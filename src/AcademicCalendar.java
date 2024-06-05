import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class AcademicCalendar {

    public String displaySchedule(Course course, String period) {
        LocalDate now = LocalDate.now();
        LocalDate endDate;

        switch (period.toLowerCase()) {
            case "week":
                endDate = now.plusWeeks(1);
                break;
            case "month":
                endDate = now.plusMonths(1);
                break;
            case "semester":
                endDate = now.plusMonths(6);
                break;
            default:
                return "Invalid period. Please choose 'week', 'month', or 'semester'.";
        }

        List<Assignment> assignments = course.getAssignments().stream()
                .filter(a -> !a.getDueDate().isBefore(now) && !a.getDueDate().isAfter(endDate))
                .collect(Collectors.toList());

        List<Exam> exams = course.getExams().stream()
                .filter(e -> !e.getExamDate().isBefore(now) && !e.getExamDate().isAfter(endDate))
                .collect(Collectors.toList());

        StringBuilder schedule = new StringBuilder("Assignments:\n");
        for (Assignment assignment : assignments) {
            schedule.append(assignment.getTitle())
                    .append(" - Due: ")
                    .append(assignment.getDueDate())
                    .append("\n");
        }

        schedule.append("Exams:\n");
        for (Exam exam : exams) {
            schedule.append(exam.getTitle())
                    .append(" - Date: ")
                    .append(exam.getExamDate())
                    .append("\n");
        }

        return schedule.toString();
    }
}

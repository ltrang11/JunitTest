public class Academic extends User {
    private String academicId;

    public Academic(String username, String password, String academicId) {
        super(username, password);
        this.academicId = academicId;
    }

    public String getAcademicId() {
        return academicId;
    }

    public void addContent(Course course, String content) {
        course.addContent(content);
    }

    public void addAssignment(Course course, Assignment assignment) {
        course.addAssignment(assignment);
    }

    public void addExam(Course course, Exam exam) {
        course.addExam(exam);
    }

    public void communicateThroughForum(DiscussionForum forum, String message) {
        forum.addMessage(this, message);
    }
}

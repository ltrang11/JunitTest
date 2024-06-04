import java.util.ArrayList;
import java.util.List;

public class DiscussionForum {
    private List<String> messages = new ArrayList<>();

    public void addMessage(User user, String message) {
        messages.add(user.getUsername() + ": " + message);
    }

    public void displayMessages() {
        for (String message : messages) {
            System.out.println(message);
        }
    }
}

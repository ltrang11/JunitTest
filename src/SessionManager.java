import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private Map<User, Long> activeSessions = new HashMap<>();
    private static final long TIMEOUT = 600_000; // 10 minutes in milliseconds

    public void login(User user) {
        activeSessions.put(user, System.currentTimeMillis());
        System.out.println(user.getUsername() + " logged in.");
    }

    public void logout(User user) {
        activeSessions.remove(user);
        System.out.println(user.getUsername() + " logged out.");
    }

    public boolean isAuthenticated(User user) {
        Long lastActivityTime = activeSessions.get(user);
        if (lastActivityTime == null) {
            return false;
        }
        if (System.currentTimeMillis() - lastActivityTime > TIMEOUT) {
            activeSessions.remove(user);
            System.out.println(user.getUsername() + "'s session timed out.");
            return false;
        }
        activeSessions.put(user, System.currentTimeMillis()); // Reset the timer
        return true;
    }
}

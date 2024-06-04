
public class SessionManagerTest {
    public static void main(String[] args) throws InterruptedException {
        SessionManager sessionManager = new SessionManager();
        User user = new User("username", "password");

        // Test 1: Null User when Logging In
        try {
            sessionManager.login(null);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException as expected.");
        }

        // Test 2: Timeout Handling when User Not Active
        sessionManager.login(user);
        Thread.sleep(601000); // Sleep for just over 10 minutes
        boolean isAuthenticated = sessionManager.isAuthenticated(user);
        System.out.println("User authentication status after timeout: " + isAuthenticated);
    }
}

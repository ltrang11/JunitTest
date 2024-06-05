import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SessionManagerTest {
    User user = new User("Alex", "123");

    @Test
    public void testLoginNullUser() {
        SessionManager sessionManager = new SessionManager();
        assertThrows(NullPointerException.class, () -> {
            sessionManager.login(null);
        });
    }

    @Test
    public void testLogoutWithoutLogin() {
        SessionManager sessionManager = new SessionManager();
        assertDoesNotThrow(() -> {
            sessionManager.logout(user);
        });
    }

    @Test
    public void testLoginTwice() {
        SessionManager sessionManager = new SessionManager();
        User user = new User("user1", "pass1");
        sessionManager.login(user);
        assertThrows(IllegalStateException.class, () -> {
            sessionManager.login(user);
        });
    }
}

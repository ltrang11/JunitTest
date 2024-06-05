import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MainTest {

    @Test
    public void testInvalidLogin() {
        String input = "invalidUser\ninvalidPass\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(RuntimeException.class, () -> {
            Main.main(new String[]{});
        });
    }

    @Test
    public void testEmptyUsername() {
        String input = "\npassword1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(RuntimeException.class, () -> {
            Main.main(new String[]{});
        });
    }
}

import org.junit.jupiter.api.Test;

public class LoginControllerTest {
    @Test
    void limits_username_at_20_chars() {
        LoginController loginController = new LoginController(loginView);

        loginController.usernameUpdated("aaaaaaaaaaaaaaaaaaaabbbbb");

        verify(loginView).setUsername("aaaaaaaaaaaaaaaaaaaa");
    }
}

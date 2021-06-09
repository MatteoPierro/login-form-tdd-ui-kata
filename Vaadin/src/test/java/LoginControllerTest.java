import LoginView.LoginView;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoginControllerTest {
    @Test
    void limits_username_at_20_chars() {
        LoginView loginView = mock(LoginView.class);
        LoginController loginController = new LoginController(loginView);

        loginController.usernameUpdated("aaaaaaaaaaaaaaaaaaaabbbbb");

        verify(loginView).setUsername("aaaaaaaaaaaaaaaaaaaa");
    }
}

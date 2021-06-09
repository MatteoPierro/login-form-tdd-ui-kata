import LoginView.LoginView;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class LoginControllerTest {
    @Test
    void limits_username_at_20_chars() {
        LoginView loginView = mock(LoginView.class);
        LoginController loginController = new LoginController(loginView);

        loginController.usernameUpdated("caaaaaaaaaaaaaaaaaaabbbbb");

        verify(loginView).setUsername("caaaaaaaaaaaaaaaaaaa");
    }

    @Test
    void do_nothing_when_updated_username_is_maximum_20_chars() {
        LoginView loginView = mock(LoginView.class);
        LoginController loginController = new LoginController(loginView);

        loginController.usernameUpdated("aaaaaaaaaaaaaaaaaaaa");

        verifyZeroInteractions(loginView);
    }
}

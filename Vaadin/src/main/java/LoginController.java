import LoginView.LoginView;

public class LoginController {
    public static final int MAX_USERNAME_LENGTH = 20;
    private final LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
    }

    public void usernameUpdated(String username) {
        if (username.length() > MAX_USERNAME_LENGTH) {
            loginView.setUsername(username.substring(0, MAX_USERNAME_LENGTH));
        }
    }
}

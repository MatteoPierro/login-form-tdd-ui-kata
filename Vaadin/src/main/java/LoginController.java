import LoginView.LoginView;

public class LoginController {
    private final LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
    }

    public void usernameUpdated(String username) {
        loginView.setUsername("aaaaaaaaaaaaaaaaaaaa");
    }
}

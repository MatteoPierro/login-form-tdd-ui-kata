import LoginView.LoginView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.HasValue;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point.
 */
@Theme("mytheme")
public class LoginUI extends UI implements LoginView {

    private static final long serialVersionUID = -8092198794020028852L;
    private TextField usernameField;

    /**
     * The UI is initialised. This method is intended to be overridden to add component to the user interface and
     * initialise non-component functionality.
     */
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        LoginController loginController = new LoginController(this);
        VerticalLayout layout = new VerticalLayout();
        usernameField = new TextField();
        usernameField.addValueChangeListener(new HasValue.ValueChangeListener<String>() {
            @Override
            public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {
                loginController.usernameUpdated(valueChangeEvent.getValue());
            }
        });
        layout.addComponent(usernameField);
        setContent(layout);
    }

    @Override
    public void setUsername(String username) {
        usernameField.setValue(username);
    }

    @WebServlet(urlPatterns = "/*", name = "LoginUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = LoginUI.class, productionMode = false)
    public static class LoginUIServlet extends VaadinServlet {

        private static final long serialVersionUID = -8308587615027111707L;
    }
}

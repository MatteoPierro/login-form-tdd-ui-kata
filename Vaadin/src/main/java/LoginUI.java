import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
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
public class LoginUI extends UI {

    private static final long serialVersionUID = -8092198794020028852L;

    /**
     * The UI is initialised. This method is intended to be overridden to add component to the user interface and
     * initialise non-component functionality.
     */
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(new TextField());
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "LoginUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = LoginUI.class, productionMode = false)
    public static class LoginUIServlet extends VaadinServlet {

        private static final long serialVersionUID = -8308587615027111707L;
    }
}

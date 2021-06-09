package samples;

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
public class HelloUI extends UI {

    private static final long serialVersionUID = -8092198794020028852L;

    /**
     * The UI is initialised. This method is intended to be overridden to add component to the user interface and
     * initialise non-component functionality.
     */
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Navigator navigator = new Navigator(this, this);

        // Create and register the views
        navigator.addView("", new HelloView(navigator));
        navigator.addView("/success", new SuccessView());
    }

    public static class HelloView extends VerticalLayout implements View {
        public HelloView(Navigator navigator) {
            final TextField name = new TextField();
            name.setCaption("Type your name here:");

            Button button = new Button("Click Me");
            button.addClickListener(e -> {
                navigator.navigateTo("/success/name="+name.getValue());
            });

            addComponents(name, button);
        }
    }

    public static class SuccessView extends VerticalLayout implements View {

        @Override
        public void enter(ViewChangeListener.ViewChangeEvent event) {
            addComponent(new Label("Thanks " + event.getParameterMap().get("name") + ", it works!"));
        }
    }

//    @WebServlet(urlPatterns = "/*", name = "HelloUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = HelloUI.class, productionMode = false)
    public static class HelloUIServlet extends VaadinServlet {

        private static final long serialVersionUID = -8308587615027111707L;
    }
}

import com.github.mvysny.kaributesting.v8.MockVaadin;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import samples.HelloUI;

import static com.github.mvysny.kaributesting.v8.LocatorJ._get;
import static com.github.mvysny.kaributesting.v8.LocatorJ._setValue;
import static org.junit.jupiter.api.Assertions.*;

class LoginUIAcceptanceTest {
    @BeforeEach
    void beforeEach() {
        MockVaadin.setup(LoginUI::new);
    }

    @AfterEach
    void afterEach() {
        MockVaadin.tearDown();
    }

    @Test
    void limits_username_at_20_chars() {
        _setValue(_get(TextField.class), "aaaaaaaaaaaaaaaaaaaabbbbb");

        assertEquals("aaaaaaaaaaaaaaaaaaaa", _get(TextField.class).getValue());
    }
}
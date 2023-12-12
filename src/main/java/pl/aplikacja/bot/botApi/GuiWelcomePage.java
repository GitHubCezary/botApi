package pl.aplikacja.bot.botApi;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;


@Route("login")
@PageTitle("Login | Web Scraping Api")
@AnonymousAllowed
class GuiWelcomePage extends VerticalLayout {

    private static final String OAUTH_URL = "/oauth2/authorization/google";
    private static final String LOGIN_SUCCESS_URL = "testApi";

    public GuiWelcomePage() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        Anchor loginLink = new Anchor(OAUTH_URL, "Login with Google");
        // Set router-ignore attribute so that Vaadin router doesn't handle the login request
        loginLink.getElement().setAttribute("router-ignore", true);
        add(loginLink);
        getStyle().set("padding", "200px");
        setAlignItems(FlexComponent.Alignment.CENTER);
    }
}


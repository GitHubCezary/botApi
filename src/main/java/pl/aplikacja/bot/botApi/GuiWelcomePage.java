package pl.aplikacja.bot.botApi;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("login")
@PageTitle("Login | Web Scraping Api")
@AnonymousAllowed

public class GuiWelcomePage extends VerticalLayout {

    private static final String OAUTH_URL_GOOGLE = "/oauth2/authorization/google";
    private static final String OAUTH_URL_GITHUB = "/oauth2/authorization/github";

    public GuiWelcomePage() {
        H1 header = new H1("Witaj w Web Scraping API");
        Button googleSignInButton = new Button("Zaloguj przez Google");
        googleSignInButton.addClassName("google-btn");
        Button gitHubSignInButton = new Button("Zaloguj przez GitHub");

        gitHubSignInButton.setAutofocus(true);
        googleSignInButton.setAutofocus(true);
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        Anchor loginLinkGithub = new Anchor(OAUTH_URL_GITHUB);
        Anchor loginLinkGoogle = new Anchor(OAUTH_URL_GOOGLE);
        // Set router-ignore attribute so that Vaadin router doesn't handle the login request
        loginLinkGoogle.getElement().setAttribute("router-ignore", true);
        loginLinkGoogle.add(googleSignInButton);
        loginLinkGithub.getElement().setAttribute("router-ignore", true);
        loginLinkGithub.add(gitHubSignInButton);
        add(header, loginLinkGoogle, loginLinkGithub, loginLinkGithub);
        getStyle().set("padding", "200px");
        setAlignItems(Alignment.CENTER);
    }
}

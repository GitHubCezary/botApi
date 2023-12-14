package pl.aplikacja.bot.botApi;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;


@Route("login")
@PageTitle("Login | Web Scraping Api")
@AnonymousAllowed
class GuiWelcomePage extends VerticalLayout {

    private static final String OAUTH_URL_GOOGLE = "/oauth2/authorization/google";
    private static final String OAUTH_URL_GITHUB = "https://github.com/login/oauth/authorize";

    public GuiWelcomePage() {
        H1 heder = new H1("Witaj w Web Scraping API");
        Button loginButtonGoogle = new Button("Login via Google");
        Button loginButtonGithub = new Button("Login via Github");
        loginButtonGithub.setAutofocus(true);
        loginButtonGoogle.setAutofocus(true);
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        Anchor loginLinkGithub = new Anchor(OAUTH_URL_GITHUB,"sdgsdthfsdg");
        Anchor loginLinkGoogle = new Anchor(OAUTH_URL_GOOGLE);
        // Set router-ignore attribute so that Vaadin router doesn't handle the login request
        loginLinkGoogle.getElement().setAttribute("router-ignore", true);
        loginLinkGoogle.add(loginButtonGoogle);
        loginLinkGithub.getElement().setAttribute("router-ignore",true);
        loginLinkGithub.add(loginButtonGithub);
        add(heder, loginLinkGoogle,loginLinkGithub,loginLinkGithub);
        getStyle().set("padding", "200px");
        setAlignItems(FlexComponent.Alignment.CENTER);
    }
}


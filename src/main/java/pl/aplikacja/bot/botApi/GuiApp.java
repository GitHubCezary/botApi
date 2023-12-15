package pl.aplikacja.bot.botApi;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;


@Route("testApi")
@PermitAll
public class GuiApp extends VerticalLayout {

    private static final String LOGOUT_SUCCESS_URL = "/login";

    public GuiApp() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticatedPrincipal principal = (OAuth2AuthenticatedPrincipal) authentication.getPrincipal();

        String givenName = principal.getAttribute("name");
        String familyName = principal.getAttribute("family_name");
        String email = principal.getAttribute("email");
        String picture = principal.getAttribute("picture");

        H2 header = new H2("Hello " + givenName + " " + familyName + " (" + email + ")");


        Button logoutButton = new Button("Logout", click -> {
//
            UI.getCurrent().getPage().setLocation(LOGOUT_SUCCESS_URL);
            HttpServletRequest request = (HttpServletRequest) UI.getCurrent().getSession().getAttribute(HttpServletRequest.class);
            SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
            logoutHandler.logout(request, null, null);
            SecurityContextHolder.getContext().setAuthentication(null);
        });


        setAlignItems(Alignment.CENTER);
        add(logoutButton, header);
    }
}



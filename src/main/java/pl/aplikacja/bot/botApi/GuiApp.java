package pl.aplikacja.bot.botApi;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinServletRequest;
import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Route("testApi")
@PermitAll
public class GuiApp extends VerticalLayout {

    private static final String LOGOUT_SUCCESS_URL = "/login";

    @Autowired
    public GuiApp(QuoteGeneratorTelegramBot telegramBot) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticatedPrincipal principal = (OAuth2AuthenticatedPrincipal) authentication.getPrincipal();

        String givenName = principal.getAttribute("name");
        String familyName = principal.getAttribute("family_name");
        String email = principal.getAttribute("email");

        H2 header = new H2("Hello " + givenName + " " + familyName + " (" + email + ")");

        Button buttonSendMessageTelegram = new Button("Wyślij Wiadomość na telegramie", buttonClickEvent -> {
            try {
                telegramBot.sendScheduledQuote();
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        });
        Button logoutButton = new Button("Logout", click -> {



            UI.getCurrent().getPage().setLocation(LOGOUT_SUCCESS_URL);
            VaadinServletRequest vaadinServletRequest = (VaadinServletRequest) VaadinRequest.getCurrent();
            HttpServletRequest request = vaadinServletRequest.getHttpServletRequest();

            SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
            logoutHandler.logout(request, null, null);
            SecurityContextHolder.getContext().setAuthentication(null);

        });

        setAlignItems(Alignment.CENTER);
        add(logoutButton, header, buttonSendMessageTelegram);
    }
}



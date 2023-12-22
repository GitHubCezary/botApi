package pl.aplikacja.bot.botApi;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
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


@Route("testApi")
@PermitAll
public class GuiApp extends VerticalLayout {

    private static final String LOGOUT_SUCCESS_URL = "/login";
    private static final String url = "https://www.twitch.tv/";
    private static String streamerName;


    @Autowired
    public GuiApp() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticatedPrincipal principal = (OAuth2AuthenticatedPrincipal) authentication.getPrincipal();


        String givenName = principal.getAttribute("name");
        String email = principal.getAttribute("email");

        H2 header = new H2("Hello " + givenName);


        H3 headerBottom = new H3("Jesteś zalogowany jako: " + givenName + " " + " (" + email + ")");


        H3 streamerNameInput = new H3("Wprowadź nazwe Streamera");
        MessageInput input = new MessageInput();


        input.addSubmitListener(submitEvent -> {
            streamerName = submitEvent.getValue().trim();
            if (getStreamerLink().equals(url)) {
                Notification.show("Nie poprawna nazwa",
                        3000, Notification.Position.MIDDLE);
            } else {
                if (SeleniumConfig.checkStreamerPage(getStreamerLink()).equals("correct")) {

                    Notification.show("Odnaleziono Streamera TwitchTV: "
                                    + submitEvent.getValue() + " jest: "
                                    + SeleniumConfig.printStatus(getStreamerLink()),
                            3000, Notification.Position.MIDDLE);
                } else {
                    Notification.show("Nie znaleziono Streamera TwitchTV: " + submitEvent.getValue(),
                            3000, Notification.Position.MIDDLE);
                }
                SelleniumDriver.closeWebDriver();
            }
        });
        H3 botTelegramHeader = new H3("Ustaw bota aby sprawdzić kiedy twój streamer bedzie online");
        IntegerField integerTimeBotTelegram = new IntegerField();
        integerTimeBotTelegram.setLabel("Czas działania bota");
        integerTimeBotTelegram.setHelperText("max 60 minut");
        integerTimeBotTelegram.setMin(0);
        integerTimeBotTelegram.setMax(60);
        integerTimeBotTelegram.setStepButtonsVisible(true);
        Button buttonSendMessageTelegram = new Button("Uruchom bota", buttonClickEvent -> {

            ScheduledTaskMenager scheduledTaskMenager = new ScheduledTaskMenager();
            scheduledTaskMenager.startScheduledTask(integerTimeBotTelegram.getValue());

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
        add(header, streamerNameInput, input, botTelegramHeader, integerTimeBotTelegram, buttonSendMessageTelegram, headerBottom, logoutButton);
    }

    public static String getStreamerLink() {
        return url + streamerName;
    }
}



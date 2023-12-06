package pl.aplikacja.bot.botApi;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/test") // map view to the root
class UserGui extends VerticalLayout {
    UserGui() {
        add(new H1("Hello, world"));
    }
}


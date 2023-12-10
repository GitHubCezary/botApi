package pl.aplikacja.bot.botApi;
import com.vaadin.flow.i18n.I18NProvider;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("hello")
class UserGui extends VerticalLayout {


    public UserGui() {
        TextField textField = new TextField("hello");
        Button button = new Button("click", new Icon(VaadinIcon.ABACUS));
        Label label = new Label();
        button.addClickListener(buttonClickEvent ->
                label.setText("hello" + textField.getValue()));
        add(textField, button, label);
    }


}


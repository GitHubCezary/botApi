package pl.aplikacja.bot.botApi;

import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@Configuration

public class WebSecurityConfig extends VaadinWebSecurity {
    private static final String LOGIN_URL = "/login";
    private static final String TARGET_URL = "/testApi";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.oauth2Login().loginPage(LOGIN_URL)
                .defaultSuccessUrl(TARGET_URL, true);
    }
}





package pl.aplikacja.bot.botApi;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class testApi {


    @GetMapping("/test1")
    public String get() {
        return ("dla wszystkich");
    }

    @GetMapping("/test2")
    public String get2() {

        return ("dla zalogowanych ");
    }

    @RequestMapping(method = GET)
    public List<String> read(OAuth2Authentication auth) {
        auth.getOAuth2Request().getClientId();
        return read(auth);
    }
}


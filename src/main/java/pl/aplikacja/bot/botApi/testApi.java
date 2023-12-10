package pl.aplikacja.bot.botApi;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testApi {

    @GetMapping("/test1")
    public String get1() {
        return "sadsfasf";
    }


    @GetMapping("/test2")
    public String get2() {
        return ("/test1");
    }

    @RequestMapping("/test3")
    public String read(@AuthenticationPrincipal OAuth2User principal) {
        return principal.getAttribute("name");
    }
}


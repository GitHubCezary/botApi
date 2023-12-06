package pl.aplikacja.bot.botApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testApi {

    @GetMapping("/test1")
    public String get(){
        return ("dla wszystkich");
    }

    @GetMapping("/test2")
    public String get2(){
        return ("dla zalogowanych");
    }
}

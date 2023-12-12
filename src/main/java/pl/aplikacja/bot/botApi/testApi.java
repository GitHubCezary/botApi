package pl.aplikacja.bot.botApi;

import org.springframework.web.bind.annotation.GetMapping;
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

//    @RequestMapping("/test3")
//    public String read( @AuthenticationPrincipal OAuth2User principal) {
//        OAuth2User p2 = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return p2.getAttribute("name");
//    }


}


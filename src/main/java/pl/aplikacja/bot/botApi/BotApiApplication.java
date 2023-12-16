package pl.aplikacja.bot.botApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class BotApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotApiApplication.class, args);

SeleniumConfig seleniumConfig = new SeleniumConfig();
        try {
            seleniumConfig.printLinks();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}


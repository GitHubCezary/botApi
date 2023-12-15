package pl.aplikacja.bot.botApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication()
//@EnableScheduling
public class BotApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotApiApplication.class, args);
    }

}


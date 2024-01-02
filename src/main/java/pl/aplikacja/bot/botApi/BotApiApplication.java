package pl.aplikacja.bot.botApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication()
@EnableScheduling
@EnableAutoConfiguration
public class BotApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BotApiApplication.class, args);

    }
}






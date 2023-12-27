package pl.aplikacja.bot.botApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTaskMenager {

    private static ScheduledExecutorService scheduler;
    private static String status;
    public QuoteGeneratorTelegramBot quoteGeneratorTelegramBot;
    TelegramBot telegramBot = new TelegramBot();
    QuoteService quoteService = new QuoteService();


    @Autowired
    public ScheduledTaskMenager() {
        quoteGeneratorTelegramBot = new QuoteGeneratorTelegramBot(telegramBot, quoteService);
    }

    public void startScheduledTask(int value) {
        scheduler = Executors.newScheduledThreadPool(1);
        WebDriver driver = SelleniumDriver.initializeWebDriver();

        Runnable task = () -> {
            try {
                driver.get(GuiApp.getStreamerLink());
                WebElement webElement = driver.findElement(By.cssSelector("a.ScHalo-sc-18imt3g-0"));
                status = webElement.getAttribute("status");
                System.out.println("Zadanie wykonywane: " + status);
                if ("live".equals(status)) {
                    quoteGeneratorTelegramBot.sendScheduledQuote(status);
                    SelleniumDriver.closeWebDriver();
                    scheduler.shutdownNow();
                    System.out.println("Zakończono wątek - stream online");
                    reset();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // Zaplanowanie zadania wykonywanego co 10 sekund
        scheduler.scheduleAtFixedRate(task, 0, 10, TimeUnit.SECONDS);

        // Zaplanowanie zadania zamykającego wątek po upływie 2 minut
        scheduler.schedule(() -> {
            SelleniumDriver.closeWebDriver();
            try {
                quoteGeneratorTelegramBot.sendScheduledQuote(status);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Zakończono wątek po upływie " + value);
            reset();
            scheduler.shutdown();
        }, value, TimeUnit.MINUTES);
    }

    public void reset() {
        status = null;
    }
}

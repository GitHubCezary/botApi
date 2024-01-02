package pl.aplikacja.bot.botApi.scheduled;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import pl.aplikacja.bot.botApi.sellenium.SelleniumDriver;
import pl.aplikacja.bot.botApi.telegram.QuoteGeneratorTelegramBot;
import pl.aplikacja.bot.botApi.vaadin.GuiApp;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Controller
public class ScheduledTaskManager {

    private final QuoteGeneratorTelegramBot quoteGeneratorTelegramBot;
    private ScheduledExecutorService scheduler;
    private String status;

    @Autowired
    public ScheduledTaskManager(QuoteGeneratorTelegramBot quoteGeneratorTelegramBot) {
        this.quoteGeneratorTelegramBot = quoteGeneratorTelegramBot;
    }

    public void startScheduledTask(int value) {
        scheduler = Executors.newScheduledThreadPool(1);
        WebDriver driver = SelleniumDriver.initializeWebDriver();

        Runnable task = () -> {
            try {
                processTask(driver);
            } catch (Exception e) {
                handleTaskError(e);
            }
        };

        scheduler.scheduleAtFixedRate(task, 0, 10, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            SelleniumDriver.closeWebDriver();
            handleTaskCompletion(value);
            scheduler.shutdown();
        }, value, TimeUnit.MINUTES);
    }

    private void processTask(WebDriver driver) throws TelegramApiException {
        driver.get(GuiApp.getStreamerLink());
        WebElement webElement = driver.findElement(By.cssSelector("a.ScHalo-sc-18imt3g-0"));
        status = webElement.getAttribute("status");
        System.out.println("Zadanie wykonywane: " + status);
        if ("live".equals(status)) {
            quoteGeneratorTelegramBot.sendScheduledQuote(status);
            SelleniumDriver.closeWebDriver();
            scheduler.shutdownNow();
            System.out.println("Zakończono wątek - stream online");
            resetStatus();
        }
    }

    private void handleTaskError(Exception e) {
        e.printStackTrace();

    }

    private void handleTaskCompletion(int value) {
        try {
            quoteGeneratorTelegramBot.sendScheduledQuote(status);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Zakończono wątek po upływie " + value);
        resetStatus();
    }

    private void resetStatus() {
        status = null;
    }
}

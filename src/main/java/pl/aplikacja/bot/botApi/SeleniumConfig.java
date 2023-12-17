package pl.aplikacja.bot.botApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SeleniumConfig {

    private String url = "https://www.twitch.tv/tazasi";

    @Scheduled(fixedRate = 5000)
    public void printLinks() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Cezary\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(url);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement divElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Layout-sc-1xcs6mc-0")));

        WebElement twitchElement = driver.findElement(By.cssSelector("div[aria-label='Kanał jest offline']"));
        String channelStatusText = twitchElement.getAttribute("aria-label");

        if (twitchElement != null) {
            System.out.println("znaleziono : " + channelStatusText);
        } else
            System.out.println("nie znalezione");
    }
}

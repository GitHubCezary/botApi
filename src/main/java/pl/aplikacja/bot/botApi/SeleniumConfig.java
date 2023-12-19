package pl.aplikacja.bot.botApi;

import jakarta.annotation.PostConstruct;
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
    private WebDriver driver;

    @PostConstruct
    public void initializeWebDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Cezary\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        driver.get(url);
    }

    @Scheduled(fixedRate = 5000)
    public void printStatus() {
        try {

            WebElement aElement = driver.findElement(By.cssSelector("a.ScHalo-sc-18imt3g-0"));
            String statusValue = aElement.getAttribute("status");
            System.out.println("Wartość atrybutu 'status': " + statusValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

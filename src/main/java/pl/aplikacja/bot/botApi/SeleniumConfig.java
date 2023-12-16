package pl.aplikacja.bot.botApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Sleeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class SeleniumConfig {

    private String url = "https://www.twitch.tv/tazasi";


    public void printLinks() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Cezary\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

//        WebElement sf = driver.findElement(By.id("L2AGLb"));
//        sf.click();
//        WebElement pusty = driver.findElement(By.cssSelector("textarea.gLFyf"));
//        pusty.sendKeys("Smieszne koty");
//        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
//        pusty.submit();
//        Thread.sleep(3000);
//        WebElement firstLink = driver.findElement(By.cssSelector("div#search a"));
//
//        String firstLinkUrl = firstLink.getAttribute("href");
//        System.out.println("Pierwszy link w wynikach wyszukiwania: " + firstLinkUrl);
//        driver.quit();
    }
}

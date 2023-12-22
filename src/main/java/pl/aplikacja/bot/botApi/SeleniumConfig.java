package pl.aplikacja.bot.botApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static pl.aplikacja.bot.botApi.SelleniumDriver.initializeWebDriver;


public class SeleniumConfig {

    private static WebDriver driver;
    private static String correctUrl;

    public static String checkStreamerPage(String url) {
        driver = initializeWebDriver();
        driver.get(url);
        try {

            WebElement webElement = driver.findElement(By.cssSelector(".CoreText-sc-1txzju1-0.ErZg"));
            correctUrl = "incorrect";
        } catch (Exception e) {
            correctUrl = "correct";
        }
        return correctUrl;
    }


    public static String printStatus(String url) {

        driver.get(url);
        try {
            WebElement webElement = driver.findElement(By.cssSelector("a.ScHalo-sc-18imt3g-0"));
            return webElement.getAttribute("status");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


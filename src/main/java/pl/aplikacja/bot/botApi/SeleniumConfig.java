package pl.aplikacja.bot.botApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SeleniumConfig {

    private static WebDriver driver;
    private static String correctUrl;


    public static void initializeWebDriver(String url) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Cezary\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        driver.get(url);
    }

    public static String checkStreamerPage(String url) {
        initializeWebDriver(url);
        try {
            WebElement webElement = driver.findElement(By.cssSelector(".CoreText-sc-1txzju1-0.ErZg"));
            correctUrl = "incorrect";
        } catch (Exception e) {
            correctUrl = "correct";
        } finally {
            driver.quit();
        }
        return correctUrl;
    }


    public static String printStatus(String url) {
        initializeWebDriver(url);
        try {
            WebElement webElement = driver.findElement(By.cssSelector("a.ScHalo-sc-18imt3g-0"));
             String statusValue = webElement.getAttribute("status");
            return statusValue;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}

package pl.aplikacja.bot.botApi.sellenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class SelleniumDriver {


    private static WebDriver driver;


    public static WebDriver initializeWebDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "PATH TO WEBDRIVER HERE");
        driver = new ChromeDriver(chromeOptions);
        return driver;
    }


    public static void closeWebDriver() {
        driver.close();
        driver.quit();
    }

}

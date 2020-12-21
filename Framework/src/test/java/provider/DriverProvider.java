package provider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverProvider {
    private static WebDriver driver;

    public static void shutDriver() {
            driver.close();
            driver.quit();
            driver = null;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            LoggerProvider.getLog().info("Open browser");
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("disable-gpu");
            chromeOptions.addArguments("window-size=1280,720");
            driver = new ChromeDriver(chromeOptions);
        }
        return driver;
    }
}
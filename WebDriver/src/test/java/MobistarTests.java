import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import page.LandingPage;
import page.SearchResultPage;

import java.time.Duration;


public class MobistarTests {

    WebDriver driver;
    LandingPage landingPage;
    SearchResultPage searchResultPage;

    @BeforeClass
    public void setUp(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("disable-gpu");
        chromeOptions.addArguments("window-size=1920,1080");
        driver = new ChromeDriver(chromeOptions);
        landingPage = new LandingPage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @Test
    public void searchTest(){

        driver.get("http://mobistar.by");

        landingPage.enterSearchData("IPhone 7");
        landingPage.startSearch();

        String name = searchResultPage.getDeviceName();
        boolean contains = name.toLowerCase().contains("IPhone 7".toLowerCase());

        Assert.assertTrue(contains);
    }

    @Test
    public void cartTest(){

        driver.get("http://mobistar.by/catalog/smartfon-apple-iphone-7-128gb-gold");

        WebElement toCartBtn = driver.findElement(By.xpath("//button[@data-offer-id=\"9949\"]"));
        toCartBtn.click();

        new WebDriverWait(driver, Duration.ofSeconds(10).toSeconds())
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href=\"/basket\"]")));

        WebElement toCheckout = driver.findElement(By.xpath("//a[@href=\"/basket\"]"));
        toCheckout.click();

        String price = driver.findElement(By.xpath("//span[@class=\"price\"]")).getText();

        Assert.assertEquals("1 030,00 руб", price);
    }

    @AfterClass
    public void quitWebDriver(){

        driver.quit();
    }
}

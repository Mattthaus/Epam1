import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LandingPage;
import page.ProductPage;


public class MobistarTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("disable-gpu");
        chromeOptions.addArguments("window-size=1920,1080");
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public void searchIphoneFoundTest(){

        String testDevice = "смартфон apple iphone 7 128gb gold";

        String deviceName = new LandingPage(driver)
                .openPage()
                .enterSearchData(testDevice)
                .startSearch()
                .getDeviceName();

        Assert.assertEquals(testDevice.toLowerCase(),deviceName.toLowerCase());
    }

    @Test
    public void cartTest(){

        String productPage = "http://mobistar.by/catalog/smartfon-apple-iphone-7-128gb-gold";
        String expectedPrice = "1 030,00 руб";

        String price = new ProductPage(driver)
                .openPage(productPage)
                .addToCart()
                .openCart()
                .getProductPrice();

        Assert.assertEquals(expectedPrice, price);
    }

    @AfterMethod
    public void quitWebDriver(){

        driver.quit();
    }
}

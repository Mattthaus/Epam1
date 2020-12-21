package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class CommonPage {
    public static final String SITE_URL = "http://mobistar.by";

    public static final String CART_URL = "http://mobistar.by/basket";

    protected final WebDriver driver;

    public CommonPage(WebDriver driver){

        this.driver = driver;
    }

    public void waitForElement(String xpath) {
        new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds())
                .until(
                        ExpectedConditions.presenceOfElementLocated(
                                By.xpath(xpath)
                        )
                );
    }
}

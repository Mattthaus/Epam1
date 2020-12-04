package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private final WebDriver driver;

    public ProductPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@data-offer-id=\"9949\"]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@href=\"/basket\"]")
    private WebElement cartButton;

    public ProductPage openPage(String productPage){

        driver.get(productPage);
        return this;
    }

    public ProductPage addToCart(){

        addToCartButton.click();
        return this;
    }

    public CartPage openCart(){

        new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds())
                .until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
        return new CartPage(driver);
    }
}

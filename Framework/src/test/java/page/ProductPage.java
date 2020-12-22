package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import provider.LoggerProvider;

public class ProductPage extends CommonPage{

    @FindBy(xpath = "//button[@data-offer-id='9949']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='count_up count_vis']")
    private WebElement watchedListCounter;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ProductPage openPage(String productPage){
        LoggerProvider.getLog().info("Opening page");
        driver.get(productPage);
        return this;
    }

    public ProductPage addToCart(){
        LoggerProvider.getLog().info("Adding to cart");
        addToCartButton.click();
        return this;
    }

    public CartPage openCart(){
        LoggerProvider.getLog().info("Opening cart");
        driver.get(CART_URL);
        return new CartPage(driver);
    }

    public String getWatchedListCounterValue() {
        LoggerProvider.getLog().info("Getting watched list");
        return watchedListCounter.getText();
    }
}

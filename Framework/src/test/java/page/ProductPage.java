package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        driver.get(productPage);
        return this;
    }

    public ProductPage addToCart(){
        addToCartButton.click();
        return this;
    }

    public CartPage openCart(){
        driver.get(CART_URL);
        return new CartPage(driver);
    }

    public String getWatchedListCounterValue() {
        return watchedListCounter.getText();
    }
}

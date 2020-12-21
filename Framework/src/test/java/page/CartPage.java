package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CommonPage {
    public static final String PRODUCT_INCREASE_TEMPLATE
            = "//a[@href='(product)']/../..//span[@class='input-group-addon cart-count-plus']";

    @FindBy(xpath = "//span[@class='ajax_cart_quantity']")
    private WebElement counterValueElement;

    @FindBy(xpath = "//span[@class='price']")
    private WebElement finalPriceElement;

    @FindBy(xpath = "//span[@class='price']")
    private WebElement price;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductPrice() {
        return price.getText();
    }

    public CartPage increaseProductNumber(String product) {
        product = product.replace(SITE_URL, "");
        String buttonPath = PRODUCT_INCREASE_TEMPLATE.replace("(product)", product);
        WebElement increaseButton = driver.findElement(By.xpath(buttonPath));
        increaseButton.click();
        return this;
    }

    public double getFinalPrice() {
        String priceStr = finalPriceElement.getText();
        priceStr = priceStr.replace(" ", "").split(",")[0];
        return Double.parseDouble(priceStr);
    }

    public String getCounterValue() {
        return counterValueElement.getText();
    }
}

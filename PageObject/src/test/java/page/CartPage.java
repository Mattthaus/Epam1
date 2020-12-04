package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private final WebDriver driver;

    public CartPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//span[@class=\"price\"]")
    private WebElement price;

    public String getProductPrice(){

        return price.getText();
    }
}

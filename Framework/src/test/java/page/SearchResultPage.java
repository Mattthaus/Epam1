package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage extends CommonPage {
    private final static String ITEM_PRICE_TEMPLATE
            = "//ul[@class='product_list  grid row']//li[(item)]//span[contains(@class, 'new_price')]";

    private final static String PRODUCT_LINK = "//a[@itemprop='url']";

    @FindBy(xpath = "//div[@itemtype='http://schema.org/Product']")
    private List<WebElement> devicesList;

    @FindBy(xpath = "//button[contains(@class, 'btn-info-sel')]")
    private WebElement sortSelector;

    @FindBy(xpath = "//span[text()='По цене']/..")
    private WebElement sortByPriceOption;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getDeviceName(){
        return devicesList.get(0)
                .findElement(By.xpath(PRODUCT_LINK))
                .getAttribute("title");
    }

    public SearchResultPage sortByPrice(){
        sortSelector.click();
        sortByPriceOption.click();
        return this;
    }

    public double getItemPrice(int item){
        String itemPath = ITEM_PRICE_TEMPLATE.replace("(item)", String.valueOf(item));
        String itemPriceStr = driver.findElement(By.xpath(itemPath)).getText();
        itemPriceStr = itemPriceStr.split(",")[0];
        return Double.parseDouble(itemPriceStr);
    }
}

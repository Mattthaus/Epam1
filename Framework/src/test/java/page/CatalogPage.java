package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import provider.LoggerProvider;

public class CatalogPage extends CommonPage {

    public static final String CATALOG_URL = "http://mobistar.by/catalogs/mobilinie-telefoni";

    public static final String CHECKBOX_MANUFACTURER_TEMPLATE = "//li//div//span[text()='(manufacturer)']";

    public static final String PRODUCT_LINK_NAME_TEMPLATE
            = "//ul[contains(@class, 'product_list')]/li[(product)]//h5/a";

    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CatalogPage openPage() {
        LoggerProvider.getLog().info("Open Page");
        driver.get(CATALOG_URL);
        return this;
    }

    public CatalogPage checkManufacturer(String manufacturer) {
        LoggerProvider.getLog().info("Checking manufacturer");
        String checkBoxPath = CHECKBOX_MANUFACTURER_TEMPLATE.replace("(manufacturer)", manufacturer);
        WebElement checkBox = driver.findElement(By.xpath(checkBoxPath));
        checkBox.click();
        return this;
    }

    public CatalogPage waitForFilterApply(String manufacturer) {
        LoggerProvider.getLog().info("Waiting for filter apply");
        String path = PRODUCT_LINK_NAME_TEMPLATE + "[contains(text(), '" + manufacturer + "')]";
        path = path.replace("(product)", String.valueOf(1));
        waitForElement(path);
        return this;
    }

    public String getNameOfProduct(int product) {
        LoggerProvider.getLog().info("Getting name of product");
        String namePath = PRODUCT_LINK_NAME_TEMPLATE.replace("(product)", String.valueOf(product));
        WebElement nameLink = driver.findElement(By.xpath(namePath));
        return nameLink.getText();
    }
}

package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class SearchResultPage {

    public SearchResultPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@itemtype=\"http://schema.org/Product\"]")
    private List<WebElement> devices;

    public String getDeviceName(){

        return devices.get(0).findElement(By.xpath("//a[@itemprop=\"url\"]")).getAttribute("title");
    }
}

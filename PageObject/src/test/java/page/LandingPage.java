package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    private final WebDriver driver;

    public LandingPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id=\"search_query_top\"]")
    private WebElement searchField;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement searchButton;

    public LandingPage enterSearchData(String data){

        searchField.sendKeys(data);
        return this;
    }

    public SearchResultPage startSearch(){

        searchButton.click();
        return  new SearchResultPage(driver);
    }

    public LandingPage openPage(){

        driver.get("http://mobistar.by");
        return this;
    }
}



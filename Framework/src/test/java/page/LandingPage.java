package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import provider.LoggerProvider;

public class LandingPage extends CommonPage{

    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LandingPage enterSearchData(String data){
        LoggerProvider.getLog().info("Entering search data");
        searchField.sendKeys(data);
        return this;
    }

    public SearchResultPage startSearch(){
        LoggerProvider.getLog().info("Start searching");
        searchButton.click();
        return  new SearchResultPage(driver);
    }

    public LandingPage openPage(){
        LoggerProvider.getLog().info("Opening page");
        driver.get("http://mobistar.by");
        return this;
    }
}



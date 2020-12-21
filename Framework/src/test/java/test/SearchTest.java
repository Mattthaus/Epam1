package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LandingPage;
import page.SearchResultPage;
import provider.DriverProvider;
import provider.TestDataProvider;

public class SearchTest extends CommonDriverTest {

    private final static String COMMON_SEARCH_KEY = "IPhone";

    @Test(dataProvider = "getTestDeviceName", dataProviderClass = TestDataProvider.class)
    public void searchPhoneFoundTest(String testDevice){

        String deviceName = new LandingPage(DriverProvider.getDriver())
                .openPage()
                .enterSearchData(testDevice)
                .startSearch()
                .getDeviceName();

        Assert.assertEquals(testDevice.toLowerCase(),deviceName.toLowerCase());
    }

    @Test
    public void sortByPriceTest(){

        SearchResultPage page = new LandingPage(DriverProvider.getDriver())
                .openPage()
                .enterSearchData(COMMON_SEARCH_KEY)
                .startSearch()
                .sortByPrice();

        double firstItemPrice = page.getItemPrice(1);
        double secondItemPrice = page.getItemPrice(2);

        Assert.assertTrue(firstItemPrice > secondItemPrice
                , "First item should be greater than second one");
    }
}

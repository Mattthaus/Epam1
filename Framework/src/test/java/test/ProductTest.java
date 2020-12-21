package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;
import provider.DriverProvider;
import provider.TestDataProvider;

public class ProductTest extends CommonDriverTest {

    @Test(dataProvider = "getProducts", dataProviderClass = TestDataProvider.class)
    public void correctWatchedListCounterIncreaseTest(String productPage){
        String counterValue = new ProductPage(DriverProvider.getDriver())
                .openPage(productPage)
                .getWatchedListCounterValue();
        Assert.assertEquals(counterValue, String.valueOf(1));
    }
}

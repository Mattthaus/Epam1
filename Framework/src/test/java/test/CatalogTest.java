package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CatalogPage;
import provider.DriverProvider;
import provider.LoggerProvider;
import provider.TestDataProvider;

public class CatalogTest extends CommonDriverTest {

    @Test(dataProvider = "getManufacturersNames", dataProviderClass = TestDataProvider.class)
    public void correctCatalogFilterTest(String manufacturer){
        String productName = new CatalogPage(DriverProvider.getDriver())
                .openPage()
                .checkManufacturer(manufacturer)
                .waitForFilterApply(manufacturer)
                .getNameOfProduct(1);

        LoggerProvider.getLog().info(productName);
        Assert.assertTrue(
                (productName.toLowerCase()).contains(manufacturer.toLowerCase()),
                "Product name should contain manufacturer"
        );
    }
}

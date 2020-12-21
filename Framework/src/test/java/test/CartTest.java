package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;
import provider.DriverProvider;
import provider.TestDataProvider;

public class CartTest extends CommonDriverTest {

    @Test(dataProvider = "getProductAndPrice", dataProviderClass = TestDataProvider.class)
    public void correctProductPriceInCartTest(String productPage, String expectedPrice){
        String price = new ProductPage(DriverProvider.getDriver())
                .openPage(productPage)
                .addToCart()
                .openCart()
                .getProductPrice();
        Assert.assertEquals(expectedPrice, price);
    }

    @Test(dataProvider = "getProducts", dataProviderClass = TestDataProvider.class)
    public void correctProductCounterIncreaseTest(String productPage){
        String counterValue = new ProductPage(DriverProvider.getDriver())
                .openPage(productPage)
                .addToCart()
                .openCart()
                .getCounterValue();
        Assert.assertEquals(counterValue, String.valueOf(1));
    }

    @Test(dataProvider = "getProductAndPrice", dataProviderClass = TestDataProvider.class)
    public void correctProductPriceIncreaseWithProductsTest(String productPage, String productPriceStr){
        double finalPrice = new ProductPage(DriverProvider.getDriver())
                .openPage(productPage)
                .addToCart()
                .openCart()
                .increaseProductNumber(productPage)
                .getFinalPrice();

        productPriceStr = productPriceStr.replace(" ", "").split(",")[0];
        double expectedPrice = Double.parseDouble(productPriceStr);

        Assert.assertEquals(finalPrice, expectedPrice);
    }
}

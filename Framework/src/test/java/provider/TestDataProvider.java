package provider;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider
    public static Object[][] getProducts() {
        return new Object[][] {
                {"http://mobistar.by/catalog/smartfon-apple-iphone-7-128gb-gold"}
        };
    }

    @DataProvider
    public static Object[][] getProductAndPrice() {
        return new Object[][] {
                {"http://mobistar.by/catalog/smartfon-apple-iphone-7-128gb-gold", "1 030,00 руб"}
            };
        }

    @DataProvider
    public static Object[][] getTestDeviceName() {
        return new Object[][] {
                {"смартфон apple iphone 7 128gb gold"}
        };
    }

    @DataProvider
    public static Object[][] getManufacturersNames() {
        return new Object[][] {
                {"Samsung"},
                {"Alcatel"}
        };
    }
}


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriver webdriver = new ChromeDriver();
        webdriver.get("http://mobistar.by/catalog/smartfon-apple-iphone-7-128gb-gold");
        Thread.sleep(2000);

        WebElement toCartBtn = webdriver.findElement(By.xpath("//*[@id=\"product_full\"]/div[1]/div[2]/div[7]/div/button"));
        toCartBtn.click();
        Thread.sleep(2000);

        WebElement toCheckout = webdriver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div[1]/div/div/div[2]/div/div/ul/li/div/div/div/div[2]/div/a"));
        toCheckout.click();
        Thread.sleep(2000);

        webdriver.quit();
    }

    @Test
    public void cartTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriver webdriver = new ChromeDriver();
        webdriver.get("http://mobistar.by/catalog/smartfon-apple-iphone-7-128gb-gold");

        WebElement toCartBtn = webdriver.findElement(By.xpath("//*[@id=\"product_full\"]/div[1]/div[2]/div[7]/div/button"));
        toCartBtn.click();
        Thread.sleep(2000);

        WebElement toCheckout = webdriver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div[1]/div/div/div[2]/div/div/ul/li/div/div/div/div[2]/div/a"));
        toCheckout.click();
        Thread.sleep(2000);

        String price = webdriver.findElement(By.xpath("//*[@id=\"sidebar-main\"]/div/form/div/div[2]/div[2]/span[1]")).getText();

        Assert.assertEquals("1 030,00 руб", price);

        webdriver.quit();
    }
}

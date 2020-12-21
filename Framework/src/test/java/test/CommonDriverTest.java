package test;

import listener.TestScreenshotListener;
import provider.DriverProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import provider.LoggerProvider;

@Listeners({TestScreenshotListener.class})
public abstract class CommonDriverTest {

    @AfterMethod(alwaysRun = true)
    public void browserDriverShutDown(){
        LoggerProvider.getLog().info("Shut down browser");
        DriverProvider.shutDriver();
    }
}
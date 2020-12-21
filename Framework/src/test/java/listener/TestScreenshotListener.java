package listener;

import provider.DriverProvider;
import provider.LoggerProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        LoggerProvider.getLog().info("Making screenshot on test failure");
        this.saveScreenshot();
    }

    private void saveScreenshot() {
        File screenshot = ((TakesScreenshot) DriverProvider.getDriver())
                .getScreenshotAs(OutputType.FILE);
        try{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd_HH-mm-ss");
            String savePath = "./target/screenshot/" + dtf.format(LocalDateTime.now()) + ".png";
            FileUtils.copyFile(screenshot, new File(savePath));
        }
        catch (IOException e) {
            LoggerProvider.getLog().error("Can't save screenshot");
        }
    }
}
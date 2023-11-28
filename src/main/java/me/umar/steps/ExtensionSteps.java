package me.umar.steps;

import io.qameta.allure.Attachment;
import me.umar.DriverInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ExtensionSteps {

    @Attachment("{screenName}")
    public byte[] takeScreenShot(String screenName){
        return ((TakesScreenshot) DriverInfo.driver).getScreenshotAs(OutputType.BYTES);
    }
}

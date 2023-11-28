package me.umar;

import org.openqa.selenium.WebDriver;

public class DriverInfo {
    public static WebDriver driver;

    public static void setDriver(WebDriver driver){
        DriverInfo.driver = driver;
    }
}

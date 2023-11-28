package me.umar;

import me.umar.steps.ExtensionSteps;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    WebDriver driver;

    @Before()
    public void before() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src//test//resources//application.properties"));
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));

        //устанавливаем параметры запуска браузера
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--start-maximized"
        );
        driver = new ChromeDriver(options);

        //устанавливаем неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //переходим на стартовую страницу
        driver.navigate().to("https://mir-kvestov.ru/");

        DriverInfo.setDriver(driver);
    }

    public void after(){
        driver.close();
    }

    /**
     * Метод ниже прикрепляет к allure отчету скрин при падении теста
     */
    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            new ExtensionSteps().takeScreenShot("Скрин при падении");
        }

        @Override
        protected void finished(Description description){
            after();
        }
    };
}

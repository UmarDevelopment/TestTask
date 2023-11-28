package me.umar.steps;

import io.qameta.allure.Step;
import me.umar.DriverInfo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MirKvestovSteps {
    public MirKvestovSteps() {
        PageFactory.initElements(DriverInfo.driver, this);
    }

    @FindBy(xpath = "(//a/i[@class='fa fa-angle-down'])[3]")
    WebElement chooseCityDropdown;
    String cityInDropdownXpath = "//li[@class='dropdown navbar__dropdown-cities open']/ul[@class=\"dropdown-menu\"]//a[text()='%s']";

    @FindBy(xpath = "(//div[@class='item-box-desc quest-tile-1__content']/h4/a)[1]")
    WebElement firstKvestInPage;

    @FindBy(xpath = "//button[@class='close']")
    WebElement closeBannerButton;

    @Step("Выбор города {city}")
    public MirKvestovSteps chooseCity(String city) {
        chooseCityDropdown.click();
        DriverInfo.driver.findElement(By.xpath(String.format(cityInDropdownXpath, city))).click();
        return this;
    }

    @Step("Проверка что в url присутствует '{expectedURL}'")
    public MirKvestovSteps checkURL(String expectedURL) {
        Assert.assertTrue(DriverInfo.driver.getCurrentUrl().contains(expectedURL));
        return this;
    }

    @Step("Клик по первому квесту на странице")
    public MirKvestovSteps clickOnFirstQuest() {
        firstKvestInPage.click();
        return this;
    }

    /**
     * Иногда вылазит баннер с предложение квеста в подарок.
     * Метод ниже по идее должен его закрывать.
     */
    @Step("Закрыть баннер с предложением квеста в подарок")
    public MirKvestovSteps closeBannerIfExists() {
        try {
            closeBannerButton.click();
            DriverInfo.driver.switchTo().defaultContent();
        } catch (Exception ex) {
            //Все нормально, значит баннера нет
        }
        return this;
    }
}

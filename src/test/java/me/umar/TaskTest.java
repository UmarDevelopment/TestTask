package me.umar;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import me.umar.steps.ExtensionSteps;
import me.umar.steps.MirKvestovSteps;
import org.junit.Test;

public class TaskTest extends BaseTest{

    @Feature("Тестовое задание")
    @Story("Выбор квеста в ЕКБ")
    @Test
    public void tc1(){
        new MirKvestovSteps()
                .chooseCity("Екатеринбург")
                .closeBannerIfExists()
                .clickOnFirstQuest()
                .checkURL("https://ekb.mir-kvestov.ru/"); //проверяем что квест действительно в ЕКБ (меняется URL)
        new ExtensionSteps().takeScreenShot("Результат выполнения теста");
    }
}

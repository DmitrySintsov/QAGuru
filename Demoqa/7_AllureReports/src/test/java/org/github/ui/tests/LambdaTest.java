package org.github.ui.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTest {

    @Test
    @DisplayName("1. Проверка названия Issue. Лямбда шаги через step")
    public void testIssueSectionName() {

        SelenideLogger.addListener("allure",new AllureSelenide());

        step("Открытие главной страницы",() -> {
            open("https://github.com");
        });

        step("Поиск GitHub", () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue("DmitrySintsov/QAGuru");
            $(".header-search-input").submit();
        });

        step("Выбор найденного репозитария", () -> {
            $(By.linkText("DmitrySintsov/QAGuru")).click();
        });

        step("Переход в Issues",()-> {
            $(By.partialLinkText("Issues")).click();
        });

        step("Проверка названия Issue", ()-> {
            $("#issue_3").shouldHave(Condition.text("Test Allure Name Issue"));
        });

    }

}

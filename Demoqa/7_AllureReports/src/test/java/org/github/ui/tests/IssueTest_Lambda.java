package org.github.ui.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IssueSectionTest {

    @DisplayName("1. Проверка названия Issue. Чистый Selenide (с Listener)")
    @Test

    public void testIssueSectionName() {

        SelenideLogger.addListener("allure",new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").setValue("DmitrySintsov/QAGuru");
        $(".header-search-input").submit();

        $(By.linkText("DmitrySintsov/QAGuru")).click();
        $(By.partialLinkText("Issues")).click();


        $("#issue_3").shouldHave(Condition.text("Test Allure Name Issue"));

    }



}

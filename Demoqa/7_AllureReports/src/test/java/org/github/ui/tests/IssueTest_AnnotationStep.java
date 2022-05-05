package org.github.ui.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.github.ui.pages.Main;
import org.github.ui.pages.Repository;
import org.github.ui.pages.Search;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class IssueTest_AnnotationStep {

    @DisplayName("1. Проверка названия Issue. Шаги с аннотацией @Step")
    @Test

    public void testIssueSectionName() {

        SelenideLogger.addListener("allure",new AllureSelenide());

        new Main()
                .openPage()
                .searchGitHub("DmitrySintsov/QAGuru");

        new Search()
                .select("DmitrySintsov/QAGuru");

        new Repository()
                .goToIssues()
                .issue().shouldHave(Condition.text("Test Allure Name Issue"));

    }

}

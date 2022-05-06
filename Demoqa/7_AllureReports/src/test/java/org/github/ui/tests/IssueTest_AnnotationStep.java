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
        String repository = "DmitrySintsov/QAGuru";

        new Main()
                .openPage()
                .searchGitHub(repository);

        new Search()
                .select(repository);

        new Repository()
                .goToIssues()
                .isCorrectIssueName("Test Allure Name Issue");

    }

}

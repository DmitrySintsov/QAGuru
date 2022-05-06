package org.github.ui.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.github.ui.pages.MainPage;
import org.github.ui.pages.RepositoryPage;
import org.github.ui.pages.SearchPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AnnotationStepTest {

    @Test
    @DisplayName("1. Проверка названия Issue. Шаги с аннотацией @Step")
    public void testIssueSectionName() {

        SelenideLogger.addListener("allure",new AllureSelenide());
        String repository = "DmitrySintsov/QAGuru";

        new MainPage()
                .openPage("https://github.com")
                .searchGitHub(repository);

        new SearchPage()
                .select(repository);

        new RepositoryPage()
                .goToIssues()
                .isCorrectIssueName("Test Allure Name Issue");

    }

}

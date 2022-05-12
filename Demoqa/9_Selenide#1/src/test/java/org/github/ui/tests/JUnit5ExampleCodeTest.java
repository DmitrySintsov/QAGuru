package org.github.ui.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.github.ui.pages.MainPage;
import org.github.ui.pages.RepositoryPage;
import org.github.ui.pages.SearchPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnit5ExampleCodeTest {

    @Test
    @DisplayName("Проверка наличия примера кода для JUnit5 на странице SoftAssertions")
    public void testJUnit5code(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        String repo = "selenide/selenide";

        new MainPage()
                .openPage("https://github.com")
                .searchGitHub(repo);

        new SearchPage()
                .select(repo);

        new RepositoryPage()
                .goTo("Wiki")
                .openWikiPage("Soft assertions")
                .isPresent("Using JUnit5 extend test class");
    }
}

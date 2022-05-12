package org.github.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class RepositoryPage {

    @Step("Переход в Issues")
    public RepositoryPage goToIssues() {
        $(By.partialLinkText("Issues")).click();
        return this;
    }

    @Step ("Проверка названия Issue")
    public SelenideElement isCorrectIssueName(String issueName) {
        return $("#issue_3").shouldHave(Condition.text(issueName));
    }

    @Step("Переход в {page}")
    public RepositoryPage goTo(String page) {
        $(By.partialLinkText(page)).click();
        return this;
    }

    @Step("Поиск примера кода для JUnit5")
    public SelenideElement isPresent(String text) {
        return  $(".markdown-body").shouldBe(Condition.text(text));
    }

    @Step("Проверка наличия раздела Soft assertions")
    public RepositoryPage openWikiPage(String page) {
        $(withTagAndText("a", "Soft assertions")).click();
        return this;
    }
}

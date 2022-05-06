package org.github.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Repository {

    @Step("Переход в Issues")

    public Repository goToIssues() {
        $(By.partialLinkText("Issues")).click();
        return this;
    }


    @Step ("Проверка названия Issue")

    public SelenideElement isCorrectIssueName(String issueName) {

        return $("#issue_3").shouldHave(Condition.text(issueName));
    }

}

package org.github.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    @Step ("Выбор найденного репозитария")
    public void select(String repo){

        $(By.linkText(repo)).click();
    }
}

package org.github.ui.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    @Step("Открытие главной страницы")
     public MainPage openPage(String page) {
        open(page);
        return this;
    }

    @Step("Поиск GitHub")
    public void searchGitHub(String github) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(github);
        $(".header-search-input").submit();

    }
}

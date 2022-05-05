package org.github.ui.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Main {

    @Step("Открытие главной страницы")
     public Main openPage() {

        open("https://github.com");
        return this;
    }

    @Step("Поиск GitHub")
    public void searchGitHub(String github) {

        $(".header-search-input").click();
        $(".header-search-input").setValue(github);
        $(".header-search-input").submit();

    }

}

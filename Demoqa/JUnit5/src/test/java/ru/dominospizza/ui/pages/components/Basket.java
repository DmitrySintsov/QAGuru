package ru.dominospizza.ui.pages.components;

import com.codeborne.selenide.Conditional;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Basket {

    SelenideElement basketContainer = $(".sc-1vciwzu-3.gVeGlx");

    public SelenideElement open() {

        $("button[data-testid='header_cart_toggle_button']").click();

        return basketContainer;
    }

    public SelenideElement delete() {

        basketContainer.$("button[data-testid*='decrease']").click();

        return basketContainer;
    }
}

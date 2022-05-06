package ru.dominospizza.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HalvesPizza {
    public HalvesPizza open(String url) {

        Selenide.open(url);
        return new HalvesPizza();
    }


    public HalvesPizza selectHalvesPizza(String size, String dough, String pizza1, String pizza2) {

        selectSize(size);
        selectDough(dough);
        selectPizza(pizza1);
        selectPizza(pizza2);
        
        return this;
    }

    private void selectSize(String size) {

        $$("button[data-testid^='1_size']").findBy(text(size)).click();
    }

    private void selectDough(String dough) {
        $$("button[data-testid^='2_size']").findBy(text(dough)).click();
    }


    private void selectPizza(String pizza) {

        $(byText(pizza))
                .parent()
                .scrollIntoView(true)
                .click();
    }


    public void addToBasket() {

        $(withText("В корзину"))
                .parent()
                .scrollIntoView(false)
                .click();
    }
}

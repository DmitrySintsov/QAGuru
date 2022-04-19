package ru.dominospizza.ui.pages;

import com.codeborne.selenide.Selenide;

public class HalvesPizza {
    public HalvesPizza open(String url) {

        Selenide.open(url);
        return new HalvesPizza();
    }


    public HalvesPizza selectHalvesPizza(String size, String dough, String pizza1, String pizza2) {

        selectSize(size);
        selectDough(dough);
        selectPizza1(pizza1);
        selectPizza2(pizza2);
        
        return this;

    }

    private void selectPizza2(String pizza2) {
    }

    private void selectPizza1(String pizza1) {
    }

    private void selectDough(String dough) {
    }

    private void selectSize(String size) {
    }

    public void addToBasket() {


    }
}

package ru.dominospizza.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Cart {

    SelenideElement cartContainer = $(".sc-1vciwzu-3.gVeGlx");

    public Cart open() {

        $("button[data-testid='header_cart_toggle_button']").click();

        return this;
    }

    public Cart decreasePosition(int position, int count) {


      while(count > 0) {
           cartContainer.$("button[data-testid$='"+position+"_decrease_button']").click();
           count--;
       }
        return this;
    }

    public Cart deletePosition(int position) {

        int currentCount = Integer.parseInt($(".sc-9lmyig-2.hWFDze").getValue());

        while(currentCount > 0) {
            cartContainer.$("button[data-testid$='"+position+"_decrease_button']").click();
            currentCount--;
        }
        return this;

    }

    public Cart increasePosition(int position, int count) {

       while(count > 1) {
                cartContainer.$("button[data-testid$='"+position+"_increase_button']").click();
                count--;
        }

        return this;
    }

    public SelenideElement product(int position) {

          return cartContainer.$("div[data-testid$='"+position+"']");

    }

    public SelenideElement productPrice(int position) {

        return cartContainer.$("div[data-testid$='"+position+"']")
                            .$("div[data-testid$='" + position + "_price']").shouldHave(Condition.enabled, Condition.visible );
    }




}

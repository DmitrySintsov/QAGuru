package ru.dominospizza.ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.dominospizza.ui.pages.HalvesPizza;
import ru.dominospizza.ui.pages.Cart;

public class CartTests extends TestBase{

    @BeforeEach
    @DisplayName("Добавляем товар в корзину")
    public void addProductToCart() {

        new HalvesPizza()
                .open("/halves-selection")
                .selectHalvesPizza("28","Тонкое","Жюльен","Хот-дог")
                .addToBasket();
    }

    @ParameterizedTest(name = "Проверка пересчета стоимости корзины при изменении кол-ва позиций на {0} шт")
    @ValueSource(ints = { 5, 8, 10 })
    public void testCartProductPrice(int count) {

        String beginPrice = new Cart()
                .open()
                .productPrice(0).getText();

        String totalPrice = new Cart()
                .increasePosition(0,count)
                .productPrice(0).getText();

//        new Cart()
//                .decreasePosition(0,count);


   //     System.out.println("total = " + Integer.parseInt(totalPrice.substring(0,totalPrice.indexOf(" "))));
   //     System.out.println("first = " + Integer.parseInt(beginPrice.substring(0,beginPrice.indexOf(" "))));
   //     System.out.println("must = "  + Integer.parseInt(beginPrice.substring(0,beginPrice.indexOf(" "))) * count);

        Assertions.assertEquals(Integer.parseInt(totalPrice.substring(0,totalPrice.indexOf(" "))),
                          Integer.parseInt(beginPrice.substring(0,beginPrice.indexOf(" "))) * count);



    }

    @AfterEach
    @DisplayName("Удаляем товар из корзины")
    public void clearCart() {

        new Cart()
                .deletePosition(0);

    }

}

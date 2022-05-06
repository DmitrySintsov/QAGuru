package ru.dominospizza.ui.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.dominospizza.ui.pages.Cart;
import ru.dominospizza.ui.pages.HalvesPizza;

public class HalvesSelectionTests extends TestBase {

    @DisplayName("Проверка добавления пицца-половинки в корзину")

    @ParameterizedTest
    @CsvSource({
            "28,Тонкое,Жюльен,Хот-дог",
            "28,Классическое,Пепперони по-деревенски,Гавайская",
            "33,Тонкое,Маргарита,Мясная",
            "33,Классическое,Хот-дог,Диабло"

    })
    public void testAddSelectedHalvesToBasket(String size, String dough, String pizza1, String pizza2) {

        new HalvesPizza()
                .open("/halves-selection")
                .selectHalvesPizza(size,dough,pizza1,pizza2)
                .addToBasket();

        new Cart()
                .open()
                .product(0)
                .shouldHave(Condition.text(pizza1 +" + "+pizza2));

    }

    @AfterEach
    @DisplayName("Удаляем товар из корзины")
    public void clearCart() {

        new Cart()
                .deletePosition(0);

    }

}

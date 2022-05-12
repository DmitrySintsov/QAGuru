package com.herokuapp.theinternet.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class DragAndDropTest {

    @Test
    @DisplayName("Drag&Drop с помощью Selenide.actions()")
    public void testDragAndDrop(){
        SelenideLogger.addListener("allure",new AllureSelenide());

        step("Открытие страницы",() -> {
            open("https://the-internet.herokuapp.com/drag_and_drop");
        });
        step("Перетаскиваем квадрат A на место квадрата B",() -> {
            $("#column-a").dragAndDropTo("#column-b");
        });
        step("Проверка, что треугольники поменялись",() -> {
            $("#column-a").shouldHave(text("B"));
            $("#column-b").shouldHave(text("A"));
        });
    }
}

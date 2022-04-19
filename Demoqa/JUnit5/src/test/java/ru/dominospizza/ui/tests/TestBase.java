package ru.dominospizza.ui.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

   @BeforeAll

    public static void setUp() {

       Configuration.browser = "chrome";
       Configuration.baseUrl = "https://dominospizza.ru/";
       Configuration.timeout = 5000;
       Configuration.browserSize = "1920x1080";

   }

}




package guru.qa.ui.lesson2;

import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;

public class TestBase {

   @BeforeAll

    public static void setUp() {

       Configuration.browser = "chrome";
       Configuration.baseUrl = "https://demoqa.com";
       Configuration.timeout = 5000;
       Configuration.browserSize = "1920x1080";

   }

}




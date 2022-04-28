package org.github.ui.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll

    public static void setUp() {

        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://github.com/DmitrySintsov/QAGuru/";
        Configuration.timeout = 5000;
        Configuration.browserSize = "1920x1080";

    }


}

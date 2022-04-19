package com.demoqa.ui.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    public PracticeForm open(String url) {

        Selenide.open(url);
        return new PracticeForm();

    }

    public PracticeForm fillForm() {

      FristName("Ivan");
      LastName("Ivanov");
      UserEmail("User@mail.com");
      Gender("Male");
      Mobile("1234567890");
      BirthDate("03","January","2000");
      Subject("English");
      Hobbies("Music");
      PictureFromFile("test.png");
      CurrentAddress("Test Address");
      StateCity("Haryana", "Panipat");


        return page(PracticeForm.class);
    }

    private void StateCity(String state, String city) {

        $("div#state").scrollIntoView(true).click();
        $("div#stateCity-wrapper").$(byText(state)).click();

        $("div#city").scrollIntoView(true).click();
        $("div#stateCity-wrapper").$(byText(city)).click();

    }

    private void CurrentAddress(String value) {

        $("textarea#currentAddress").setValue(value);

    }

    private void PictureFromFile(String value) {

        $("input#uploadPicture").uploadFromClasspath(value);

    }


    public void submit() {

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("button#submit").click();

    }


    private void FristName(String value) {

        $("input#firstName").setValue(value);

    }

    private void LastName(String value) {

        $("input#lastName").setValue(value);

    }

    private void UserEmail(String value) {

        $("input#userEmail").setValue(value);

    }

    private void Gender(String value) {

        $$(By.cssSelector("label[for^='gender-radio']"))
                .findBy(text(value))
                .click();

    }


    private void Mobile(String value) {

        $("input#userNumber").setValue(value);
    }

    private void BirthDate(String day, String month, String year) {

        $("input#dateOfBirthInput").click();
        $("select.react-datepicker__month-select").selectOption(month);
        $("select.react-datepicker__year-select") .selectOption(year);
        $(".react-datepicker__day--0"+day+":not(.react-datepicker__day--outside-month").click();

    }

    private void Subject(String value) {

        $("input#subjectsInput").setValue(value).pressEnter();

    }

    private void Hobbies(String value) {

        $$(By.cssSelector("label[for^=hobbies-checkbox]"))
                .findBy(text(value))
                .click();

    }

}

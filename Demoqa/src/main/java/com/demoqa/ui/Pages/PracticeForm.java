package com.demoqa.ui.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.ui.Helpers.Dates;
import com.demoqa.ui.Models.Student;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm extends BasePages{

    public PracticeForm open(String url) {

        Selenide.open(url);
        return new PracticeForm();

    }

    public PracticeForm fillForm(Student user) {

      setFristName(user.getFirstName());
      setLastName(user.getLastName());
      setUserEmail(user.getEmail());
      setGender(user.getGender());
      setMobile(user.getMobile());
      //setBirthDate("03","January","2000");
        setBirthDate(Integer.toString(new Dates().getMonthDate(user.getBirthday())),
                     new Dates().getMonth(user.getBirthday()),
                     Integer.toString(new Dates().getYear(user.getBirthday())));
      setSubject(user.getSubjects());
      setHobbies(user.getHobbies());
      setPictureFromFile("test.png");
      setCurrentAddress(user.getAddress());
      setStateCity(user.getState(), "Panipat");

        System.out.println("");
        return page(PracticeForm.class);
    }

    private void setStateCity(String state, String city) {

        $("div#state").scrollIntoView(true).click();
        $("div#stateCity-wrapper").$(byText(state)).click();

        $("div#city").scrollIntoView(true).click();
        $("div#stateCity-wrapper").$(byId("0")).click();

    }

    private void setCurrentAddress(String value) {

        $("textarea#currentAddress").setValue(value);

    }

    private void setPictureFromFile(String value) {

        $("input#uploadPicture").uploadFromClasspath(value);

    }


    public void submit() {

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("button#submit").click();

    }


    private void setFristName(String value) {

        $("input#firstName").setValue(value);

    }

    private void setLastName(String value) {

        $("input#lastName").setValue(value);

    }

    private void setUserEmail(String value) {

        $("input#userEmail").setValue(value);

    }

    private void setGender(String value) {

        $$(By.cssSelector("label[for^='gender-radio']"))
                .findBy(text(value))
                .click();

    }


    private void setMobile(String value) {

        $("input#userNumber").setValue(value);
    }

    private void setBirthDate(String day, String month, String year) {

        $("input#dateOfBirthInput").click();
        $("select.react-datepicker__month-select").selectOption(month);
        $("select.react-datepicker__year-select") .selectOption(year);
        $(".react-datepicker__day--0"+day+":not(.react-datepicker__day--outside-month").scrollIntoView(true).click();

    }

    private void setSubject(List<String> value) {

        SelenideElement subject = $("input#subjectsInput");

        for(String sub : value) {
            subject.setValue(sub).pressEnter();
        }

    }

    private void setHobbies(List<String> value) {

        ElementsCollection hobbies = $$(By.cssSelector("label[for^=hobbies-checkbox]"));

        for(String hobby:value) {
                 hobbies
                         .findBy(text(hobby))
                         .click();
        }

    }

}

package guru.ga.lesson2.Pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm extends BasePages{

    public PracticeForm open(String url) {

        Selenide.open(url);
        return new PracticeForm();

    }

    public PracticeForm fillForm() {

      setFristName("Ivan");
      setLastName("Ivanov");
      setUserEmail("User@mail.com");
      setGender("Male");
      setMobile("1234567890");
      setBirthDate("03","January","2000");
      setSubject("English");
      setHobbies("Music");
      setPictureFromFile("test.png");
      setCurrentAddress("Test Address");
      setStateCity("Haryana", "Panipat");




        //.setValue(new Date().toString());

//        $("input#hobbies-checkbox-1").;
        $("textarea#currentAddress").setValue("Test Address");



        return page(PracticeForm.class);
    }

    private void setStateCity(String state, String city) {

        $("div#state").scrollIntoView(true).click();
        $("div#stateCity-wrapper").$(byText(state)).click();

        $("div#city").scrollIntoView(true).click();
        $("div#stateCity-wrapper").$(byText(city)).click();

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
        $(".react-datepicker__day--0"+day+":not(.react-datepicker__day--outside-month").click();

    }

    private void setSubject(String value) {

        $("input#subjectsInput").setValue(value).pressEnter();

    }

    private void setHobbies(String value) {

        $$(By.cssSelector("label[for^=hobbies-checkbox]"))
                .findBy(text(value))
                .click();

    }

}

package com.demoqa.ui.tests;

import com.demoqa.ui.forms.SubmitModalForm;
import com.demoqa.ui.pages.PracticeForm;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;

public class StudentRegistrationFormTests extends TestBase {

    @Test

    public void testValidStudentRegistration() {

        new PracticeForm()
                .open("/automation-practice-form")
                .fillForm()
                .submit();

        new SubmitModalForm()
                .studentForm().shouldHave(text("Thanks for submitting the form"),
                                          text("Ivan"),
                                          text("Ivanov"),
                                          text("User@mail.com"),
                                          text("Male"),
                                          text("1234567890"),
                                          text("English"),
                                          text("Music"),
                                          text("Test Address"));

    }

}

package com.demoqa.ui.tests;

import com.demoqa.ui.forms.SubmitModalForm;
import com.demoqa.ui.models.Student;
import com.demoqa.ui.pages.PracticeForm;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;

public class StudentRegistrationFormTests extends TestBase {

    @Test

    public void testValidStudentRegistration() {

        Student testStudent = new Student();

        new PracticeForm()
                .open("/automation-practice-form")
                .fillForm(testStudent)
                .submit();

        new SubmitModalForm()
                .studentForm().shouldHave(text("Thanks for submitting the form"),
                                          text(testStudent.getFirstName()),
                                          text(testStudent.getLastName()),
                                          text(testStudent.getEmail()),
                                          text(testStudent.getAddress()),
                                          text(testStudent.getMobile()),
                                          text(testStudent.getGender()),
                                          text(testStudent.getHobbies().get(0)),
                                          text(testStudent.getAddress()));

    }

}

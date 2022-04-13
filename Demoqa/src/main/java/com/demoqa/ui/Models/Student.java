package com.demoqa.ui.Models;

import com.demoqa.ui.Helpers.Dates;
import com.demoqa.ui.Helpers.Randomizer;
import com.github.javafaker.Faker;

import java.text.ParseException;
import java.util.*;

public class Student {

    private String   firstName,
                     lastName,
                     email,
                     gender,
                     mobile,
                     address,
                     state,
                     city;
    private Date     birthday;
    private List<String> subjects,
                     hobbies;


    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getGender() {
        return gender;
    }
    public String getMobile() {
        return mobile;
    }
    public String getAddress() {
        return address;
    }
    public String getState() {
        return state;
    }
    public String getCity() {
        return city;
    }
    public Date getBirthday() {
        return birthday;
    }
    public List<String> getSubjects() {
        return subjects;
    }
    public List<String> getHobbies() {
        return hobbies;
    }


    public Student() {

        Faker faker = new Faker(new Locale("en-US"));

        this.firstName  = faker.name().firstName();
        this.lastName   = faker.name().lastName();
        this.email      = faker.internet().emailAddress();
        this.gender     = new Randomizer().getRandomString(new String[]{"Male","Female","Other"});
        this.mobile     = faker.number().digits(10);
        this.birthday   = new Dates().getDate(faker.date().birthday(),"dd/MM/yyyy") ;
        this.address    = faker.address().fullAddress();
        this.state      = new Randomizer().getRandomString(new String[]{"NCR","Uttar Pradesh","Haryana","Rajasthan"});
        this.city       = "";
        this.subjects   = new Randomizer().getRandomStringList(Arrays.asList("NCR","Uttar Pradesh","Haryana","Rajasthan"));
        this.hobbies    = new Randomizer().getRandomStringList(Arrays.asList("Sports","Reading","Music"));
    }

}

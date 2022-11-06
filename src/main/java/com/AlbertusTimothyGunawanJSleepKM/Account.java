package com.AlbertusTimothyGunawanJSleepKM;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Serializable {
    public String name;
    public String email;
    public String password;
    public static final String REGEX_EMAIL = "^[A-Za-z0-9]+(?:\\.[\\w`~!#$%^&*’_+={}|:;',./<>?]+)*@(?:[a-zA-Z]+\\.)+[a-zA-Z]{1,}$";
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=\\S+$).{8,}$";

    public Account(String name, String email, String password) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String toString() {
        return "Account ID: " + this.id + "\nAccount Name: " + this.name + "\nAccount Email: " + this.email + "\nAccount Password: " + this.password;
    }

    public Boolean validate() {
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(this.email);

        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(this.password);

        return matcherEmail.find() && matcherPassword.find();
    }
}



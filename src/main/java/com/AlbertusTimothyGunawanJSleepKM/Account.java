package com.AlbertusTimothyGunawanJSleepKM;


import com.AlbertusTimothyGunawanJSleepKM.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Serializable {
    public String name;
    public String email;
    public String password;
    public double balance;
    public Renter renter;
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[.a-zA-Z][a-zA-Z]$";
    public static final String REGEX_PASSWORD = "^(?=.[A-Z])(?=.[0-9])(?=.[a-z])(?=\\S+$).{8,}$";

    /**
     * Constructs a new `Account` object with the specified `name`, `email`,
     * and `password`. The initial balance of the `Account` is set to `0`.
     *
     * @param name the name of the account holder
     * @param email the email address of the account holder
     * @param password the password for the account
     * @author Albertus Timothy
     */
    public Account(String name, String email, String password) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = 0;
    }

    /**
     * Returns a string representation of the account.
     *
     * @return a string containing the account ID, name, email, and password
     * @author Albertus Timothy
     */
    public String toString() {
        return "Account ID: " + this.id + "\nAccount Name: " + this.name + "\nAccount Email: " + this.email + "\nAccount Password: " + this.password;
    }

    /**
     * Validates the email and password of this `Account` object against
     * the specified regular expressions. Returns `true` if both the email
     * and password are valid, and `false` otherwise.
     *
     * @return `true` if both the email and password are valid, and
     * `false` otherwise
     * @author Albertus Timothy
     */
    public Boolean validate() {
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(this.email);

        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(this.password);

        return matcherEmail.find() && matcherPassword.find();
    }
}



package com.AlbertusTimothyGunawanJSleepKM;

import com.AlbertusTimothyGunawanJSleepKM.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Renter extends Serializable {
    public String phoneNumber;
    public String address = "";
    public String username;
    public static final String REGEX_NAME = "^[A-Z][a-z0-9_]{4,20}$";
    public static final String REGEX_PHONE = "^[0-9]{9,12}$";

    public Renter(String username, String phoneNumber, String address) {
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public boolean validate() {
        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matcherName = patternName.matcher(this.username);

        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = patternPhone.matcher(this.phoneNumber);

        return matcherName.find() && matcherPhone.find();
    }

//    public Renter(String username) {
//        super();
//        this.username = username;
//    }
//
//    public Renter(String username, String address) {
//        super();
//        this.username = username;
//        this.address = address;
//    }
//
//    public Renter(String username, int phoneNumber) {
//        super();
//        this.username = username;
//        this.phoneNumber = phoneNumber;
//    }
//
//    public Renter(String username, int phoneNumber, String address) {
//        super();
//        this.username = username;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//    }
}
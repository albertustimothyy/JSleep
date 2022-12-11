package com.AlbertusTimothyGunawanJSleepKM.controller;

import com.AlbertusTimothyGunawanJSleepKM.Account;
import com.AlbertusTimothyGunawanJSleepKM.Algorithm;
import com.AlbertusTimothyGunawanJSleepKM.Renter;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonAutowired;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[.a-zA-Z][a-zA-Z]$";
    public static final String REGEX_PASSWORD = "^(?=.[A-Z])(?=.[0-9])(?=.[a-z])(?=\\S+$).{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern  REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    @JsonAutowired(value = Account.class, filepath = "src/json/account.json")
    public static JsonTable<Account> accountTable;

    /**
     * Tops up the balance of the account with the specified ID by the specified amount.
     *
     * @param id the ID of the account to top up
     * @param balance the amount to add to the account's balance
     * @return true if the balance was topped up successfully, or false if the account could not be found
     * @author Albertus Timothy
     */
    @PostMapping("/{id}/topUp")
    boolean topUp (
            @PathVariable int id,
            @RequestParam double balance
    ) {
        for(Account singleAccount : accountTable) {
            if(singleAccount.id == id) {
                singleAccount.balance += balance;
                return true;
            }
        }
        return false;
    }

    /**
     * Registers a new account with the specified name, email, and password. The password is hashed using the MD5 algorithm.
     *
     * @param name the name of the new account
     * @param email the email address of the new account
     * @param password the password of the new account
     * @return the newly created Account, or null if the email address is already in use or the name is blank
     * @author Albertus Timothy
     */
    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ) {
        String generatedPassword = null;
        for (Account account : accountTable){
            if(account.email.equals(email) || (name.isBlank()) || account.validate()){
                return null;
            }
        }
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Account newAccount = new Account(name, email, generatedPassword);
        accountTable.add(newAccount);
        return newAccount;
    }

    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    /**
     * Logs in a user with the given email and password.
     *
     * @param email the email address of the user
     * @param password the password of the user
     * @return the account of the logged in user, or null if the login failed
     * @author Albertus Timothy
     */
    @PostMapping("/login")
    Account login (
            @RequestParam String email,
            @RequestParam String password
    ) {
        String generatedPassword = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            generatedPassword = sb.toString();
        }
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        String newPassword = generatedPassword;
        return Algorithm.<Account>find(accountTable, temp -> (temp.email.equals(email)) && temp.password.equals(newPassword));
    }

    /**
     * Registers a new renter for the specified account.
     *
     * @param id the ID of the account
     * @param username the username of the renter
     * @param address the address of the renter
     * @param phoneNumber the phone number of the renter
     * @return the newly created renter, or null if the registration failed
     * @author Albertus Timothy
     */
    @PostMapping("/{id}/registerRenter")
    Renter registerRenter (
            @PathVariable int id,
            @RequestParam String username,
            @RequestParam  String address,
            @RequestParam String phoneNumber
    ) {
        for (Account account : accountTable){
            if((account != null) && (account.renter == null)){
                account.renter = new Renter(username, phoneNumber, address);
                return account.renter;
            }
        }
        return null;
    }
}

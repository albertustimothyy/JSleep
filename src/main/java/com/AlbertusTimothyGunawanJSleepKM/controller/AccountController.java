package com.AlbertusTimothyGunawanJSleepKM.controller;

import com.AlbertusTimothyGunawanJSleepKM.Account;
import com.AlbertusTimothyGunawanJSleepKM.Algorithm;
import com.AlbertusTimothyGunawanJSleepKM.Renter;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonAutowired;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    public static final String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z.]+[^.]$";
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern  REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    @JsonAutowired(value = Account.class, filepath = "src/json/account.json")
    public static JsonTable<Account> accountTable;


    public AccountController() {

    }

    @PostMapping("/{id}/topUp")
    boolean topUp (@RequestParam int id, @RequestParam double balance) {
        for(Account singleAccount : accountTable) {
            if(singleAccount.id == id) {
                singleAccount.balance += balance;
                return true;
            }
        }
        return false;
    }

    @PostMapping("/register")
    Account register( @RequestParam String name, @RequestParam String email, @RequestParam String password) {
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
        accountTable.add(new Account(name, email, generatedPassword));
        return new Account(name, email, generatedPassword);
    }

    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/login")
    Account login(@RequestParam String email, @RequestParam String password) {
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

    @PostMapping("/{id}/registerRenter")
    Renter registerRenter (@RequestParam int id, @RequestParam String username, @RequestParam  String address, @RequestParam String phoneNumber) {
        for (Account account : accountTable){
            if((account.id == id) && (account.renter == null)){
                return(new Renter(username, phoneNumber, address));
            }
        }
        return null;
    }
//    @GetMapping
//    String index() { return "account page"; }
//
//    @PostMapping("/register")
//    Account register
//            (
//                    @RequestParam String name,
//                    @RequestParam String email,
//                    @RequestParam String password
//            )
//    {
//        return new Account(name, email, password);
//    }
//
//    @GetMapping("/{id}")
//    String getById(@PathVariable int id) { return "account id " + id + " not found!"; }
}

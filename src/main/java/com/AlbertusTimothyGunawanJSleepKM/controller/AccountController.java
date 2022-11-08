package com.AlbertusTimothyGunawanJSleepKM.controller;

import com.AlbertusTimothyGunawanJSleepKM.Account;
import com.AlbertusTimothyGunawanJSleepKM.Renter;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonAutowired;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public static final String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z.]+[^.]$";
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern  REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    @JsonAutowired(value = Account.class, filepath = "src/json/account.json")
    public static JsonTable<Account> accountTable;


    public AccountController() {

    }

    @PostMapping("/{id}/topUp")
    public boolean topUp (@RequestParam int id, @RequestParam double balance) {
        return false;
    }

    @PostMapping("/register")
    public Account register( @RequestParam String name, @RequestParam String email, @RequestParam String password) {
        Account newAccount = new Account(name, email, password);
        if ((name.isBlank()) == false) {
            if (REGEX_PATTERN_EMAIL.matcher(email).matches() && REGEX_PATTERN_PASSWORD.matcher(password).matches()) {
                for (Account account : getJsonTable()) {
                    if (account.email.equals(email)) {
                        break;
                    }
                    accountTable.add(account);
                    return newAccount;
                }
            }
        }
        return null;
    }

    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/login")
    public Account login( @RequestParam String email, @RequestParam String password) {
        for (Account account : getJsonTable()) {
            if (account.email.equals(email) && account.password.equals(password)) {
                return account;
            }
        }
        return null;
    }

    @PostMapping("/{id}/registerRenter")
    public Renter registerRenter (@RequestParam int id, @RequestParam String username, @RequestParam  String address, @RequestParam String phoneNumber) {
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

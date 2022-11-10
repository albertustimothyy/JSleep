package com.AlbertusTimothyGunawanJSleepKM.controller;

import com.AlbertusTimothyGunawanJSleepKM.Payment;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonAutowired;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class, filepath = "src/json/payment.json")
    public static JsonTable<Payment> paymentTable;
    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }
    @PostMapping("/create")
    public Payment create (@RequestParam int buyerId, @RequestParam int renterId, @RequestParam int roomId, @RequestParam String from, @RequestParam String to) {
        return null;
    }
    @PostMapping("/{id}/cancel ")
    public boolean cancel (@RequestParam int id) {
        return false;
    }

    @PostMapping("/{id}/accept")
    public boolean accept(@RequestParam int id) {
        return false;
    }

}

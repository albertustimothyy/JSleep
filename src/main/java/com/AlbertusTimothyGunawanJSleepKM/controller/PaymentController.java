package com.AlbertusTimothyGunawanJSleepKM.controller;

import com.AlbertusTimothyGunawanJSleepKM.Payment;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonAutowired;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class, filepath = "src/json/payment.json")
    public static JsonTable<Payment> paymentTable;
    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }
    @PostMapping("/payment")
    public boolean cancel (@RequestParam int id) {
        return false;
    }
    @PostMapping("/payment")
    public Payment create (@RequestParam int buyerId, @RequestParam int renterId, @RequestParam int roomId, @RequestParam String from, @RequestParam String to) {
        return null;
    }
    @PostMapping("/{id}/accept")
    public boolean accept(@RequestParam int id) {
        return false;
    }
    @PostMapping("/payment")
    public boolean submit (int id, String receipt) {
        return false;
    }
}

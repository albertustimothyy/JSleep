package com.AlbertusTimothyGunawanJSleepKM.controller;

import com.AlbertusTimothyGunawanJSleepKM.*;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonAutowired;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public Payment create (
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ) throws ParseException {
        Account buyer = Algorithm.<Account>find(AccountController.accountTable, temp -> temp.id == buyerId);

        Room room = Algorithm.<Room>find(RoomController.roomTable, temp -> temp.id == roomId);
        double price = room.price.price;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);

        if (buyer == null || buyer.balance <= price || !Payment.availability(fromDate, toDate, room)) {
            return null;
        } else {
            Payment paymentCheck = new Payment(buyerId, renterId, roomId, fromDate, toDate);

            buyer.balance -= price;

            paymentCheck.status = Invoice.PaymentStatus.WAITING;
            Payment.makeBooking(fromDate, toDate, room);
            paymentTable.add(paymentCheck);

            return paymentCheck;
        }
    }
    @PostMapping("/{id}/cancel")
    public boolean cancel (
            @RequestParam int id
    ) {
        Payment payment = Algorithm.<Payment>find(getJsonTable(), temp -> temp.id == id);

        if (payment == null || payment.status != Invoice.PaymentStatus.WAITING) {
            return false;
        } else {
            Account buyer = Algorithm.<Account>find(AccountController.accountTable, account -> account.id == payment.buyerId);
            Room room = Algorithm.<Room>find(RoomController.roomTable, room1 -> room1.id == payment.getRoomId());
            payment.status = Invoice.PaymentStatus.FAILED;
            buyer.balance += room.price.price;
            return true;
        }
    }

    @PostMapping("/{id}/accept")
    public boolean accept (
            @RequestParam int id
    ) {
        Payment payment = Algorithm.<Payment>find(getJsonTable(), temp -> temp.id == id);

        if (payment == null || payment.status != Invoice.PaymentStatus.WAITING) {
            return false;
        } else {
            payment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
    }

}

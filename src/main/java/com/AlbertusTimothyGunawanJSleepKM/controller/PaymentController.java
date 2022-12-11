package com.AlbertusTimothyGunawanJSleepKM.controller;

import com.AlbertusTimothyGunawanJSleepKM.*;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonAutowired;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class, filepath = "src/json/payment.json")
    public static JsonTable<Payment> paymentTable;

    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    /**
     * Creates a new payment for a room booking.
     *
     * @param buyerId the ID of the buyer
     * @param renterId the ID of the renter
     * @param roomId the ID of the room
     * @param from the start date of the booking (in the format "yyyy-MM-dd")
     * @param to the end date of the booking (in the format "yyyy-MM-dd")
     * @return the newly created Payment object, or null if the payment could not be created
     * @throws ParseException if the date format is invalid
     * @author Albertus Timothy
     */
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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);
        Date fromTgl = sdf.parse(from);
        Date toTgl = sdf.parse(to);
        long day = toTgl.getTime() - fromTgl.getTime();
        double price = room.price.price * (TimeUnit.MILLISECONDS.toDays(day));

        if (buyer == null || buyer.balance <= price || !Payment.availability(fromDate, toDate, room)) {
            return null;
        } else {
            Payment paymentCheck = new Payment(buyerId, renterId, roomId, fromDate, toDate, price);

            buyer.balance -= price;
            paymentCheck.status = Invoice.PaymentStatus.WAITING;
            Payment.makeBooking(fromDate, toDate, room);
            paymentTable.add(paymentCheck);
            System.out.println(price);
            System.out.println(paymentCheck.totalPrice);

            return paymentCheck;
        }
    }

    /**
     * Cancels a payment with the given ID.
     *
     * @param id the ID of the payment to cancel
     * @return true if the payment was successfully canceled, false otherwise
     * @author Albertus Timothy
     */
    @PostMapping("/{id}/cancel")
    public boolean cancel (
            @PathVariable int id
    ) {
        Payment payment = Algorithm.<Payment>find(getJsonTable(), temp -> temp.id == id);

        if (payment == null || payment.status != Invoice.PaymentStatus.WAITING) {
            return false;
        } else {
            Account buyer = Algorithm.<Account>find(AccountController.accountTable, account -> account.id == payment.buyerId);
            Room room = Algorithm.<Room>find(RoomController.roomTable, room1 -> room1.id == payment.getRoomId());
            payment.status = Invoice.PaymentStatus.FAILED;
            buyer.balance += payment.totalPrice;
            return true;
        }
    }

    /**
     * Accepts the payment with the specified ID.
     *
     * @param id the ID of the payment to accept
     * @return true if the payment was successfully accepted, false otherwise
     * @author Albertus Timothy
     */
    @PostMapping("/{id}/accept")
    public boolean accept (
            @PathVariable int id
    ) {
        Payment payment = Algorithm.<Payment>find(getJsonTable(), temp -> temp.id == id);

        if (payment == null || payment.status != Invoice.PaymentStatus.WAITING) {
            return false;
        } else {
            payment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
    }
    /**
     * Returns a list of payments made by the renter with the given ID.
     *
     * @param renterId the ID of the renter
     * @return a list of payments made by the renter with the given ID
     * @author Albertus Timothy
     */
    @GetMapping("/getPaymentFromRenter")
    public List<Payment> getPaymentFromRenter (
            @RequestParam int renterId
    ){
        return Algorithm.<Payment>collect(getJsonTable(),pred -> pred.renterId == renterId);
    }
}

package com.AlbertusTimothyGunawanJSleepKM;

import java.util.Date;
import java.util.Calendar;

public class Payment extends Invoice{
    public Date to;
    public Date from;
    private int roomId;
    public double totalPrice;

    public Payment(int buyerId, int renterId, int roomId, Date from, Date to, double totalPrice) {
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
        this.totalPrice = totalPrice;
    }

    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to) {
        super(buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    public String print() {
        return "\nRoom Id: " + this.roomId + "\nFrom: " + this.from + "\nTo: " + this.to;
    }

    public int getRoomId() {
        return roomId;
    }

    public static boolean availability(Date from,Date to,Room room){
        Calendar start = Calendar.getInstance();
        start.setTime(from);
        Calendar end = Calendar.getInstance();
        end.setTime(to);
        if(start.after(end) || start.equals(end)){
            return false;
        }
        for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
            if(room.booked.contains(date)){
                return false;
            }
        }
        return true;
    }

    public static boolean makeBooking(Date from,Date to,Room room){
        if(availability(from, to, room)){
            Calendar start = Calendar.getInstance();
            start.setTime(from);
            Calendar end = Calendar.getInstance();
            end.setTime(to);
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                room.booked.add(date);
            }
            return true;
        }
        return false;
    }
}






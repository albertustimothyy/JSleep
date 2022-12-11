package com.AlbertusTimothyGunawanJSleepKM;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.Serializable;


public class Invoice extends Serializable {
    public int buyerId;
    public int renterId;

    public enum RoomRating {
        NONE, BAD, NEUTRAL, GOOD
    }

    public enum PaymentStatus {
        FAILED, WAITING, SUCCESS
    }

    public RoomRating rating;
    public PaymentStatus status;

    protected Invoice(int buyerId, int renterId) {
        super();
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    public Invoice(Account buyer, Renter renter) {
        super();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    public String print() {
        return "Buyer Id: " + this.buyerId + "\nRenter Id: " + this.renterId;
    }
}






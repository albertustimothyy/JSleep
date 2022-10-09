package AlbertusTimothyGunawanJSleepKM;
import java.util.Date;

public class Invoice extends Serializable {
    public int buyerId;
    public int renterId;
    public Date time;
    public enum RoomRating {
        NONE, BAD, NEUTRAL, GOOD
    }
    public enum PaymentStatus {
        FAILED, WAITING, SUCCESS
    }
    public RoomRating rating;
    public PaymentStatus status;

    protected Invoice(int id, int buyerId, int renterId) {
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = new Date();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    public Invoice(int id, Account buyer, Renter renter) {
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = new Date();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    public String print() {
        return "Buyer Id: " + this.buyerId + "\nRenter Id: " + this.renterId + "\nTime: " + this.time;
    }
}





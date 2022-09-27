package AlbertusTimothyGunawanJSleepKM;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice{
    public String to;
    public String from;
    private int roomid;

    Payment(int id, int buyerId, int renterId, String time, int roomId, String from, String to) {
        super(id, buyerId, renterId, time);
        this.roomid = roomId;
        this.from = from;
        this.to = to;
    }
    Payment(int id, Account buyer, Renter renter, String time, int roomId, String from, String to) {
        super(id, buyer, renter, time);
        this.roomid = roomId;
        this.from = from;
        this.to = to;
    }

    public String print() {
        return "\nRoom Id: " + this.roomid + "\nFrom: " + this.from + "\nTo: " + this.to;
    }

    public int getRoomid() {
        return roomid;
    }
}


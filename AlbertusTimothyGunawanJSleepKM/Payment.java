package AlbertusTimothyGunawanJSleepKM;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Payment extends Invoice{
    public Calendar to;
    public Calendar from;
    private int roomId;

    public Payment(int id, int buyerId, int renterId, int roomId) {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }
    public Payment(int id, Account buyer, Renter renter, String time, int roomId, String from, String to) {
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }

    public String print() {
        return "\nRoom Id: " + this.roomId + "\nFrom: " + this.from + "\nTo: " + this.to;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getDuration() {
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        String duration = SDFormat.format(from.getTime()) + " - " + SDFormat.format(to.getTime());
        return duration;
    }

    public String getTime() {
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        return SDFormat.format(time.getTime());
    }
}





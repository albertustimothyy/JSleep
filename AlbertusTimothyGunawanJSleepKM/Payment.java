package AlbertusTimothyGunawanJSleepKM;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment extends Invoice{
    public Date to;
    public Date from;
    private int roomId;

    public Payment(int id, int buyerId, int renterId, int roomId, Date from, Date to) {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    public Payment(int id, Account buyer, Renter renter, String time, int roomId, Date from, Date to) {
        super(id, buyer, renter);
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

    public String getTime() {
        SimpleDateFormat SDFormat = new SimpleDateFormat("'Formatted Date = 'dd MMMM yyyy");
        return SDFormat.format(time.getTime());
    }
    public static boolean availability(Date from, Date to, Room room) {
        for(Date i : room.booked){
            if (i.after(from) || i.equals(from)) {
                return false;
            }
        }
        return true;
    }

    public static boolean makeBooking(Date from, Date to, Room room) {
        if(from.after(to)){
            return false;
        }
        if (availability(from, to, room)) {
            room.booked.add(from);
            room.booked.add(to);
            return true;
        } else {
            return false;
        }
    }
}






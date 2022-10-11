package AlbertusTimothyGunawanJSleepKM;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

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
    public Payment(int id, Account buyer, Renter renter, int roomId, Date from, Date to) {
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
        if(from.after(to) || to.before(from) || from.equals(to)){
            return false;
        }

        for (Date i : room.booked) {

            if (from.equals(i)) {
                return false;
            } else if(from.before(i)){
                if(from.before(i) && to.after(i)){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean makeBooking(Date from, Date to, Room room) {
        if(availability(from, to, room)){
            while (from.before(to)){
                room.booked.add(from); // Assign ke array
                Calendar tempVar = Calendar.getInstance();
                tempVar.setTime(from);
                tempVar.add(Calendar.DATE, 1);
                from = tempVar.getTime();
            }
            return true;
        }
        else{
            return false;
        }
    }
}






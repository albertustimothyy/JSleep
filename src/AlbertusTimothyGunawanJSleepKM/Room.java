package AlbertusTimothyGunawanJSleepKM;
import java.util.ArrayList;
import java.util.Date;

public class Room extends Serializable implements FileParser{
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public BedType bedType;
    public City city;
    public String address;
    public ArrayList<Date> booked = new ArrayList<>();

    public Room(String name, int size, Price price, Facility facility, City city, String address) {
        super();
        this.size = size;
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.address = address;
        this.city = city;
        this.bedType = BedType.SINGLE;
    }

    public String toString() {
        return "Room ID: " + this.id + "\nRoom Name: " + this.name + "\nRoom Size: " + this.size + "\nRoom Facility: "
                + this.facility + "\n" + this.price + "\nAddress: " + this.address + "\nBed Type: " + this.bedType +
                "\nCity: " + this.city;
    }

    public Object write() {
        return null;
    }

    public boolean read(String s) {
        return false;
    }
}
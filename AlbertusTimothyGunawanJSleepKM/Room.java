package AlbertusTimothyGunawanJSleepKM;


/**
 * Praktikum OOP
 *
 * @Albertus Timothy (
 * @2106639472
 */

public class Room {
    public int size;
    public String name;
    public Facility facility;
    public Price price;

    public Room(String name, int weight, Price price, Facility facility) {
        this.size = weight;
        this.name = name;
        this.facility = facility;
        this.price = price;
    }
}


package AlbertusTimothyGunawanJSleepKM;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Serializable{
    public String desc;
    public String date;

    public Complaint(int id, String date, String desc) {
        super(id);
        this.date = date;
        this.desc = desc;
    }

    public String toString() {
        return "Complaint ID: " + this.id + "\nComplaint Desc: " + this.desc + "\nComplaint Date: " + this.date;
    }
}


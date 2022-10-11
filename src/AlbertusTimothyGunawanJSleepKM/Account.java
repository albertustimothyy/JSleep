package AlbertusTimothyGunawanJSleepKM;


public class Account extends Serializable implements FileParser {
    public String name;
    public String email;
    public String password;

    public Account(int id, String name, String email, String password) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String toString() {
        return "Account ID: " + this.id + "\nAccount Name: " + this.name + "\nAccount Email: " + this.email + "\nAccount Password: " + this.password;
    }
    public Object write() {
        return null;
    }

    public boolean read(String s) {
        return false;
    }
}



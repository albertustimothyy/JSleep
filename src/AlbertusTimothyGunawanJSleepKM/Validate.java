package AlbertusTimothyGunawanJSleepKM;
import java.util.ArrayList;

public class Validate {
    public static ArrayList filter (Price[] list, int value, boolean less){
    ArrayList price = new ArrayList<>();

        for (Price p: list) {
            if (less && p.price <= value) {
                price.add(p.price);
            }
            else if (!less && p.price > value) {
                price.add(p.price);
            }
        }
        return price;
    }

}

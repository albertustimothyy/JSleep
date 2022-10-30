package AlbertusTimothyGunawanJSleepKM;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java. util.List;
import com.google.gson.*;
public class JSleep {
    class Country{
        public String name;
        public int population;
        public List<String> listOfStates;
    }

    public static void main(String[] args) {
        String filepath = "D:\\Kuliah\\Semester 3\\Pemrograman Berorientasi Objek dan Praktikum 01\\Praktikum\\JSleep\\city.json";
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name: " + input.name);
            System.out.println("population: " + input.population);
            System.out.println("states: ");
            input.listOfStates.forEach(state -> System.out.println(state));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Room createRoom() {
        // public Room(int id, String name, int size, Price price, Facility facility, City city, String address)
        Price price = new Price(100000, 0.5);
        Room room = new Room("Hotel", 30, price, Facility.AC, City.DEPOK, "Jalan Margonda Raya");
        return room;
    }
//
//    public static int getHotelId() {
//        return 0;
//    }
//
//    public static String getHotelName() {
//        return "hotel";
//    }
//
//    public static boolean isDiscount() {
//        return true;
//    }
//
//    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount) {
//        float discount;
//        if (beforeDiscount < afterDiscount) {
//            discount = 0.0f;
//        } else {
//            discount = (float) (beforeDiscount - afterDiscount) / beforeDiscount;
//            discount *= 100;
//        }
//        return discount;
//    }
//
//    public static int getDiscountedPrice(int price, float discountPercentage) {
//        float priceAfter;
//        if (discountPercentage > 100.0f) {
//            priceAfter = 0.0f;
//        } else {
//            priceAfter = price * ((100.0f - discountPercentage) / 100.0f);
//        }
//        return (int) priceAfter;
//    }
//
//    public static int getOriginalPrice(int discountedPrice, float discountPercentage) {
//        float normalPrice = (100.0f / (100.0f - discountPercentage)) * discountedPrice;
//        return (int) normalPrice;
//    }
//
//    public static float getAdminFeePercentage() {
//        return 0.05f;
//    }
//
//    public static int getAdminFee(int price) {
//        float adminPrice;
//        adminPrice = price * getAdminFeePercentage();
//        return (int) adminPrice;
//    }
//
//    public static int getTotalPrice(int price, int numberOfNight) {
//        return price * numberOfNight + getAdminFee(price * numberOfNight);
//    }
}
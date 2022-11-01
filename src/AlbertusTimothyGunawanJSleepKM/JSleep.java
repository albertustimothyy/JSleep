package AlbertusTimothyGunawanJSleepKM;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java. util.List;
import java.util.Locale;

import com.google.gson.*;
public class JSleep {
//    class Country{
//        public String name;
//        public int population;
//        public List<String> listOfStates;
//    }
    public static void main(String[] args) {

//        Renter testRegex = new Renter("Netlab_", "081234567890", "Jl Margonda Raya");
//        Renter testRegexFail = new Renter("netlab", "081", "Jalan");
//        System.out.println(testRegex.validate());
//        System.out.println(testRegexFail.validate());
        try {
            String filepath =  "D:\\Kuliah\\Semester 3\\Pemrograman Berorientasi Objek dan Praktikum 01\\Praktikum\\JSleep\\src\\json\\randomRoomList.json";

            JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
            List<Room> filterTableRoom = filterByCity(tableRoom, "medan", 0, 5);
            filterTableRoom.forEach(room -> System.out.println(room.toString()));
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static List<Room> filterByCity(List<Room> table, String city, int page, int pageSize) {
        return Algorithm.paginate(table, page, pageSize, room -> room.city.toString().toLowerCase().contains(city.toLowerCase()));
    }
    public static List<Room> filterByPrice(List<Room> table, double minPrice, double maxPrice){
        return Algorithm.<Room>collect(table, room -> room.price.price >= minPrice && room.price.price <= maxPrice);
    }
    public static List<Room> filterByAccountId(List<Room> table, int accountId, int page, int pageSize){
        return Algorithm.<Room>paginate(table, page,pageSize,room -> room.accountId == accountId);
    }
//    public static Room createRoom() {
//        // public Room(int id, String name, int size, Price price, Facility facility, City city, String address)
//        Price price = new Price(100000, 0.5);
//        Room room = new Room("Hotel", 30, price, Facility.AC, City.DEPOK, "Jalan Margonda Raya");
//        return room;
//    }
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
package AlbertusTimothyGunawanJSleepKM;
import java.util.ArrayList;
public class JSleep {
    public static void main(String[] args) {
        ArrayList<Room> RoomSerialized = new ArrayList<Room>();

        for(int i = 0; i<5; i++){
            RoomSerialized.add(i, JSleep.createRoom());
            System.out.println(RoomSerialized.get(i).toString() + "\n");
        }
    }

    public static Room createRoom() {
        // public Room(int id, String name, int size, Price price, Facility facility, City city, String address)
        Price price = new Price(100000, 5);
        Room room = new Room(1, "Joko", 1, price, Facility.AC, City.DEPOK, "ajc");
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
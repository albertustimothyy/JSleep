package AlbertusTimothyGunawanJSleepKM;
import java.sql.*;

public class JSleep {
    public static void main(String[] args) {
        Room RoomA = JSleep.createRoom();
        Room RoomB = JSleep.createRoom();
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start = Date.valueOf("2022-8-15");
        Date end = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start, end,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start2 = Date.valueOf("2022-8-19");
        Date end2 = Date.valueOf("2022-8-22");
        System.out.println(Payment.makeBooking(start2, end2,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
                Date start3 = Date.valueOf("2022-8-18");
        Date end3 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start3, end3,RoomB));

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
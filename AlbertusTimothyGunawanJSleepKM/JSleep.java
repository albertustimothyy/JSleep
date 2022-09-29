package AlbertusTimothyGunawanJSleepKM;

/**
 * Praktikum OOP
 *
 * @Albertus Timothy (
 * @2106639472
 */

public class JSleep {
    public static void main(String[] args) {
        Complaint testComplain = new Complaint(1, "23 August 2022", "Bad Quality");
        Price testPrice = new Price(100000, 20000);
        Room testRoom = new Room(1, "Presidential Suite", 5, testPrice,
                Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        Rating testRating = new Rating();
        System.out.println(testComplain.toString() + "\n");
        System.out.println(testRoom.toString() + "\n");
        System.out.println(testAccount.toString() + "\n");
        System.out.println(testPrice.toString() + "\n");
        System.out.println(testRating.toString() + "\n");
    }

//    public static Room createRoom() {
//        Price price = new Price(100000, 5);
//        Room room = new Room("Hotel", 30, price, Facility.Bathtub);
//        return room;
//    }
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
package AlbertusTimothyGunawanJSleepKM;

/**
 * Praktikum OOP
 *
 * @Albertus Timothy (
 * @2106639472
 */
public class JSleep {
    public static void main(String[] args) {
        System.out.println("Hotel ID: " + getHotelId());
        System.out.println("Hotel Name: " + getHotelName());
        System.out.println("Discount: " + isDiscount());
        System.out.println("Discount Percentage: " + getDiscountPercentage(100, 900));
        System.out.println("Discounted Price: " + getDiscountedPrice(1000, 10.0f));
        System.out.println("Original Price: " + getOriginalPrice(900, 10.0f));
        System.out.println("Admin Fee Percentage: " + getAdminFeePercentage());
        System.out.println("Admin Fee: " + getAdminFee(1000));
        System.out.println("Total Price: " + getTotalPrice(10000, 2));
    }

    public static int getHotelId() {
        return 0;
    }

    public static String getHotelName() {
        return "hotel";
    }

    public static boolean isDiscount() {
        return true;
    }

    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount) {
        float discount;
        if (beforeDiscount < afterDiscount) {
            discount = 0.0f;
        } else {
            discount = (float) (beforeDiscount - afterDiscount) / beforeDiscount;
            discount *= 100;
        }
        return discount;
    }

    public static int getDiscountedPrice(int price, float discountPercentage) {
        float priceAfter;
        if (discountPercentage > 100.0f) {
            priceAfter = 0.0f;
        } else {
            priceAfter = price * ((100.0f - discountPercentage) / 100.0f);
        }
        return (int) priceAfter;
    }

    public static int getOriginalPrice(int discountedPrice, float discountPercentage) {
        float normalPrice = (100.0f / (100.0f - discountPercentage)) * discountedPrice;
        return (int) normalPrice;
    }

    public static float getAdminFeePercentage() {
        return 0.05f;
    }

    public static int getAdminFee(int price) {
        float adminPrice;
        adminPrice = price * getAdminFeePercentage();
        return (int) adminPrice;
    }

    public static int getTotalPrice(int price, int numberOfNight) {
        return price * numberOfNight + getAdminFee(price * numberOfNight);
    }
}
package AlbertusTimothyGunawanJSleepKM;


/**
 * Praktikum OOP
 *
 * @Albertus Timothy (
 * @2106639472
 */


public class Price {
    public double rebate;
    public double price;
    public int discount;

    public Price(double price) {
        this.price = price;
        this.discount = 0;
        this.rebate = 0.0d;
    }

    public Price(double price, int discount) {
        this.price = price;
        this.discount = discount;
        this.rebate = 0.0d;
    }

    public Price(double price, double rebate) {
        this.price = price;
        this.discount = 0;
        this.rebate = rebate;
    }

    private double getDiscountedPrice() {
        double priceAfter;
        if (this.discount > 100) {
            this.discount = 100;
        }
        priceAfter = this.price * ((100 - discount) / 100);
        return priceAfter;
    }

    private double getRebatedPrice() {
        return (this.rebate > this.price) ? 0 : (this.price - this.rebate);
    }
}

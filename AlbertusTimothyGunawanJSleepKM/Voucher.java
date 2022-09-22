package AlbertusTimothyGunawanJSleepKM;


/**
 * Praktikum OOP
 *
 * @Albertus Timothy (
 * @2106639472
 */

public class Voucher {
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;

    public Voucher(String name, int code, Type type, double minimum, double cut) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
    }

    public boolean isUsed() {
        return used;
    }

    public boolean canApply(Price price) {
        return (price.price > this.minimum) && (used == false) ? true : false;
    }

    public double apply(Price price) {
       this.used = true;

       if (this.type == Type.DISCOUNT) {
           return (this.cut > 100) ? 0 : price.price * (((100 - this.cut) / 100));
       }else {
           return (this.cut > price.price) ? 0 : (price.price - this.cut);
       }
    }
}

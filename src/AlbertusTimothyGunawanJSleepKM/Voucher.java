package AlbertusTimothyGunawanJSleepKM;

public class Voucher extends Serializable implements FileParser {
    public String name;
    private boolean used;
    public int code;
    public Type type;
    public double minimum;
    public double cut;

    public Voucher(int id, String name, int code, Type type, boolean used, double minimum, double cut) {
        super();
        this.name = name;
        this.code = code;
        this.type = type;
        this.used = used;
        this.minimum = minimum;
        this.cut = cut;
    }

    public boolean isUsed() {
        return used;
    }

    public boolean canApply(Price price) {
        return (price.price > this.minimum) && (!used);
    }

    public double apply(Price price) {
        this.used = true;

        if (this.type == Type.DISCOUNT) {
            return (this.cut > 100) ? 0 : price.price * (((100 - this.cut) / 100));
        }else {
            return (this.cut > price.price) ? 0 : (price.price - this.cut);
        }
    }

    public Object write() {
        return null;
    }

    public boolean read(String s) {
        return false;
    }
}








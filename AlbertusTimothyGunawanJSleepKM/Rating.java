package AlbertusTimothyGunawanJSleepKM;


/**
 * Praktikum OOP
 *
 * @Albertus Timothy (
 * @2106639472
 */

public class Rating {
    private long total;
    private long count;

    public Rating() {
        this.total = 0;
        this.count = 0;
    }

    public void insert(int rating) {
        this.total += rating;
        this.count++;
    }

    public double getAverage() {
        double mean;
        mean = this.total / this.count;

        if (mean < 0) {
            mean = 0;
        }

        return mean;
    }

    public long getCount() {
        return this.count;
    }

    public long getTotal() {
        return this.total;
    }
}


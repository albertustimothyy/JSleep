package com.AlbertusTimothyGunawanJSleepKM;

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
        if (this.count == 0) {
            mean = 0;
        } else {
            mean = this.total / this.count;
        }
        return mean;
    }

    public long getCount() {
        return this.count;
    }

    public long getTotal() {
        return this.total;
    }

    public String toString() {
        return "Total: " + this.total + "\nCount: " + this.count;
    }
}



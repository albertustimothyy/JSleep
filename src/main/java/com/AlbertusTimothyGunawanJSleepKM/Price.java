package com.AlbertusTimothyGunawanJSleepKM;

public class Price {
    public double price;
    public double discount;

    public Price(double price) {
        this.price = price;
        this.discount = 0;
    }

    public Price(double price, double discount) {
        this.price = price;
        this.discount = discount;
    }

    public String toString() {
        return "Price: " + this.price + "\nDiscount: " + this.discount;
    }

}

package com.AlbertusTimothyGunawanJSleepKM;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java. util.List;
import java.util.Locale;
import com.google.gson.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class JSleep {
    public static void main(String[] args) {
        SpringApplication.run(JSleep.class, args);
    }

    public static List<Room> filterByCity(List<Room> list, String city, int page, int pageSize) {
        return Algorithm.paginate(list, page, pageSize, room -> room.city.toString().toLowerCase().contains(city.toLowerCase()));
    }
    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice){
        if (maxPrice == 0) {
            return Algorithm.<Room>collect(list, room -> (room.price.price >= minPrice));
        }
        return Algorithm.<Room>collect(list, room -> (room.price.price >= minPrice) && (room.price.price <= maxPrice));
    }
    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
        return Algorithm.paginate(list, page,pageSize,room -> room.accountId == accountId);
    }
    public static Room createRoom() {
        // public Room(int id, String name, int size, Price price, Facility facility, City city, String address)
        Price price = new Price(100000, 0.5);
        Room room = new Room(10, "Hotel", 30, price, Facility.AC, City.DEPOK, "Jalan Margonda Raya");
        return room;
    }
}
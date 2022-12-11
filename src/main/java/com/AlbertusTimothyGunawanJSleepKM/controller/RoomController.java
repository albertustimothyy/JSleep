package com.AlbertusTimothyGunawanJSleepKM.controller;

import com.AlbertusTimothyGunawanJSleepKM.*;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonAutowired;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {
    @JsonAutowired(value = Room.class, filepath = "src/json/room.json")
    public static JsonTable<Room> roomTable;

    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }

    /**
     * Returns a page of rooms rented by the user with the given ID.
     *
     * @param id the ID of the user
     * @param page the page number to return
     * @param pageSize the number of rooms per page
     * @return a list of rooms rented by the user with the given ID
     * @author Albertus Timothy
     */
    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter (
            @PathVariable int id,
            @RequestParam int page,
            @RequestParam int pageSize
    ) {
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
    }

    /**
     * Creates a new room with the specified properties.
     *
     * @param accountId the ID of the account associated with the room
     * @param name the name of the room
     * @param size the size of the room
     * @param price the price of the room
     * @param facility the facilities provided in the room
     * @param city the city where the room is located
     * @param address the address of the room
     * @param bedType the type of bed in the room
     * @return the newly created room, or null if the room could not be created
     * @author Albertus Timothy
     */
    @PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam double price,
            @RequestParam ArrayList<Facility> facility,
            @RequestParam City city,
            @RequestParam String address,
            @RequestParam BedType bedType
    ){
        Account account = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId && pred.renter != null);
        if (account != null) {
            Room room = new Room(accountId, name, size, new Price(price), facility, city, address, bedType);
            roomTable.add(room);
            return room;
        }
        return null;
    }

    /**
     * Returns a paginated list of rooms from a JSON table.
     *
     * @param page The page number to return.
     * @param pageSize The number of items to include on each page.
     * @return A paginated list of rooms.
     * @author Albertus Timothy
     */
    @GetMapping("/getAllRoom")
    List<Room> getAllRoom (
            @RequestParam int page,
            @RequestParam int pageSize
    ) {
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, Objects::nonNull);
    }

    /**
     * Filters a paginated list of Room objects by city.
     *
     * @param page     the page number
     * @param pageSize the number of items per page
     * @param city     the city to filter by
     * @return a paginated list of Room objects that match the specified city
     * @author Albertus Timothy
     */
    @GetMapping("/filterByCity")
    List<Room> filterByCity (
            @RequestParam int page,
            @RequestParam int pageSize,
            @RequestParam String city
    ) {
        List<Room> list = Algorithm.<Room>paginate(getJsonTable(), page, pageSize, Objects::nonNull);
        return Algorithm.paginate(list, page, pageSize, room -> room.city.toString().toLowerCase().contains(city.toLowerCase()));
    }

    /**
     * Filters a paginated list of Room objects by price range.
     *
     * @param page     the page number
     * @param pageSize the number of items per page
     * @param minPrice the minimum price to filter by
     * @param maxPrice the maximum price to filter by (set to 0 for no maximum)
     * @return a paginated list of Room objects that match the specified price range
     * @author Albertus Timothy
     */
    @GetMapping("/filterByPrice")
    List<Room> filterByPrice (
            @RequestParam int page,
            @RequestParam int pageSize,
            @RequestParam double minPrice,
            @RequestParam double maxPrice
    ) {
        List<Room> list = Algorithm.<Room>paginate(getJsonTable(), page, pageSize, Objects::nonNull);
        if (maxPrice == 0) {
            return Algorithm.<Room>collect(list, room -> (room.price.price >= minPrice));
        }
        return Algorithm.<Room>collect(list, room -> (room.price.price >= minPrice) && (room.price.price <= maxPrice));
    }

    /**
     * This method is used to filter room by Name
     * @param page page number
     * @param pageSize item per page
     * @param name name of the room that will be filtered
     * @return list of room that match the name
     * @author Albertus Timothy
     */
    @GetMapping("/filterByName")
    List<Room> filterByName(
            @RequestParam int page,
            @RequestParam int pageSize,
            @RequestParam String name
    ){
        return Algorithm.<Room>paginate(getJsonTable(),page,pageSize,room -> room.name.contains(name));
    }
}

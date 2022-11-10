package com.AlbertusTimothyGunawanJSleepKM.controller;

import com.AlbertusTimothyGunawanJSleepKM.Algorithm;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonTable;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public interface BasicGetController<T extends Serializable> {
    public abstract JsonTable<T> getJsonTable();

    @GetMapping("/page")
    public default List<T> getPage(@RequestParam int page, @RequestParam int pageSize) {
        return Algorithm.paginate(getJsonTable(), page, pageSize, Objects::nonNull);
    }

    @GetMapping("/{id}")
    public default T getById (@PathVariable int id) {
        return Algorithm.<T>find(getJsonTable(), e -> e.id ==id);
    }
}

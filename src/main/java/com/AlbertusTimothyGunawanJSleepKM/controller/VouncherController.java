package com.AlbertusTimothyGunawanJSleepKM.controller;

import com.AlbertusTimothyGunawanJSleepKM.*;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonAutowired;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/voucher")
public class VouncherController implements BasicGetController<Voucher> {
    @JsonAutowired(value = Voucher.class, filepath = "src/json/voucher.json")
    public static JsonTable<Voucher> voucherTable;

    @Override
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }
    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id) {
        Voucher used = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return used.isUsed();
    }
    @GetMapping("/{id}/canApply")
    boolean canApply(@PathVariable int id, @RequestParam double price)
    {
        Voucher apply = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return apply.canApply(new Price(price));
    }
    @GetMapping("/getAvailable")
    List<Voucher> getAvailable(@RequestParam int page, @RequestParam int pageSize)
    {
        List<Voucher> voucher = new ArrayList<Voucher>();
        return Algorithm.<Voucher>paginate(voucher, page, pageSize, pred -> true);
    }
}

package com.AlbertusTimothyGunawanJSleepKM.controller;

import com.AlbertusTimothyGunawanJSleepKM.*;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonAutowired;
import com.AlbertusTimothyGunawanJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {
    @JsonAutowired(value = Voucher.class, filepath = "src/json/voucher.json")
    public static JsonTable<Voucher> voucherTable;

    @Override
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }
    @GetMapping("/{id}/isUsed")
    boolean isUsed(
            @PathVariable int id
    ) {
        Voucher used = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return used.isUsed();
    }
    @GetMapping("/{id}/canApply")
    boolean canApply (
            @PathVariable int id,
            @RequestParam double price
    ) {
        Voucher apply = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        if (apply != null) {
            return apply.canApply(new Price(price));
        }
        return false;
    }
    @GetMapping("/getAvailable")
    List<Voucher> getAvailable (
            @RequestParam int page,
            @RequestParam int pageSize
    ) {
        return Algorithm.<Voucher>paginate(voucherTable, page, pageSize, pred -> !pred.isUsed());
    }
}

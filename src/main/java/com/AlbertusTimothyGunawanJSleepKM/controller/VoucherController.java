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

    /**
     * Returns whether a voucher with the specified ID has been used.
     *
     * @param id The ID of the voucher to check.
     * @return True if the voucher has been used, false otherwise.
     * @author Albertus Timothy
     */
    @GetMapping("/{id}/isUsed")
    boolean isUsed(
            @PathVariable int id
    ) {
        Voucher used = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return used.isUsed();
    }

    /**
     * Returns whether a voucher with the specified ID can be applied to a purchase with the specified price.
     *
     * @param id The ID of the voucher to check.
     * @param price The price of the purchase.
     * @return True if the voucher can be applied, false otherwise.
     * @author Albertus Timothy
     */
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

    /**
     * Returns a paginated list of available vouchers.
     *
     * @param page The page number to return.
     * @param pageSize The number of items to include on each page.
     * @return A paginated list of available vouchers.
     * @author Albertus Timothy
     */
    @GetMapping("/getAvailable")
    List<Voucher> getAvailable (
            @RequestParam int page,
            @RequestParam int pageSize
    ) {
        return Algorithm.<Voucher>paginate(voucherTable, page, pageSize, pred -> !pred.isUsed());
    }
}

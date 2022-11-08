package com.AlbertusTimothyGunawanJSleepKM;

import com.AlbertusTimothyGunawanJSleepKM.dbjson.Serializable;

public class Complaint extends Serializable {
    public String desc;
    public String date;

    public Complaint(String date, String desc) {
        super();
        this.date = date;
        this.desc = desc;
    }

    public String toString() {
        return "Complaint ID: " + this.id + "\nComplaint Desc: " + this.desc + "\nComplaint Date: " + this.date;
    }
}


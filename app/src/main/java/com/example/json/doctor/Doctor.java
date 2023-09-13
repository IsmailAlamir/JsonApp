package com.example.json.doctor;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Doctor {
    @PrimaryKey(autoGenerate = true)
    public int id;


    @ColumnInfo(name = "Doctor_name")
    public String name;
    public String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }


}

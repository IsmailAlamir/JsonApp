package com.example.json;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.json.doctor.Doctor;
import com.example.json.doctor.DoctorDao;

@Database(entities = {Doctor.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract DoctorDao doctorDao();



    // singleton pattern
    //1
    private static AppDatabase appDatabase; //declaration for the instance

    //2
    public AppDatabase() {

    }

    //3
    public static synchronized AppDatabase getInstance(Context context) {

        if(appDatabase == null)
        {
            appDatabase = Room.databaseBuilder(context,
                    AppDatabase.class, "AppDatabase").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}

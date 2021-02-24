package com.example.myapplication.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by Sonam-11 on 12/8/20.
 */
@Database(entities = {UserRegisterModel.class}, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {
    private static UserDataBase INSTANCE = null;

    public static UserDataBase getDataBaseInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, UserDataBase.class, "UserDataBase")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;

    }

    public abstract UserRegisterDao userRegisterDao();
}

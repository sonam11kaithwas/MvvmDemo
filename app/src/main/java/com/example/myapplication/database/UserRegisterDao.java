package com.example.myapplication.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Created by Sonam-11 on 12/8/20.
 */
@Dao
public interface UserRegisterDao {
    @Insert
    void insertNewUser(UserRegisterModel userDataModel);

    @Query("SELECT * from UserRegisterModel")
    List<UserRegisterModel>  getUserList();

    @Query("SELECT * FROM UserRegisterModel WHERE email  =:email AND pass=:pass")
    boolean getfindUser(String email, String pass);
}

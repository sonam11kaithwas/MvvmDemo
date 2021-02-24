package com.example.myapplication.database;

import android.util.Patterns;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Sonam-11 on 12/8/20.
 */
@Entity
public class UserRegisterModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nm;
    private String email;
    private String pass;
    private String mobile;

    public UserRegisterModel() {
    }
    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }
    public UserRegisterModel(String nm, String email, String pass, String mobile) {
        this.nm = nm;
        this.email = email;
        this.pass = pass;
        this.mobile = mobile;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


}

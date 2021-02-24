package com.example.myapplication.login_pkg;

import android.util.Patterns;

/**
 * Created by Sonam-11 on 29/7/20.
 */
public class LoginModel {
    private String emailid;
    private String password;

    public LoginModel(String emailid, String password) {
        this.emailid = emailid;
        this.password = password;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getEmailid()).matches();
    }


    public boolean isPasswordLengthGreaterThan5() {
        return getPassword().length() > 5;
    }
}

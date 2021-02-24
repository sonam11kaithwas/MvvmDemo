package com.example.myapplication.login_pkg;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.R;


/**
 * Created by Sonam-11 on 29/7/20.
 */
public class LoginViewModel extends AndroidViewModel {
    public MutableLiveData<String> emailAdrs = new MutableLiveData<>();
    public MutableLiveData<String> passWord = new MutableLiveData<>();
    private MutableLiveData<LoginModel> mutableLoginModel;

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    MutableLiveData<LoginModel> mutableLoginModel() {
        if (mutableLoginModel == null) {
            mutableLoginModel = new MutableLiveData<>();
        }
        return mutableLoginModel;
    }

    public MutableLiveData<LoginModel> getUser() {

        if (mutableLoginModel == null) {
            mutableLoginModel = new MutableLiveData<>();
        }
        return mutableLoginModel;
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                LoginModel loginModel = new LoginModel(emailAdrs.getValue(), passWord.getValue());
                mutableLoginModel.setValue(loginModel);
                break;
        }

    }
}

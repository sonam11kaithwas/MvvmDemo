package com.example.myapplication.usr_registrer;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.database.UserRegisterModel;

/**
 * Created by Sonam-11 on 12/8/20.
 */
public class UserRegisterViewModel extends AndroidViewModel {
    public MutableLiveData<String> usrNm = new MutableLiveData<>();
    public MutableLiveData<String> usrpass = new MutableLiveData<>();
    public MutableLiveData<String> usrmobile = new MutableLiveData<>();
    public MutableLiveData<String> usrEmail = new MutableLiveData<>();
    public MutableLiveData userValidations;

    public UserRegisterViewModel(@NonNull Application application) {
        super(application);
    }

    public void userRegisterBtn(View view) {
        UserRegisterModel model = new UserRegisterModel(usrNm.getValue(),
                usrEmail.getValue(), usrpass.getValue(), usrmobile.getValue());
        userValidations.setValue(model);
        //        ((Activity) (view.getContext())).finish();
    }


    public MutableLiveData getUserValidation() {
        if (userValidations == null) {
            userValidations = new MutableLiveData<>();
        }
        return userValidations;
    }
}

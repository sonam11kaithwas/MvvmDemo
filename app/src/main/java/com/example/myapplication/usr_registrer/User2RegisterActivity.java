package com.example.myapplication.usr_registrer;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.database.UserDataBase;
import com.example.myapplication.database.UserRegisterModel;
import com.example.myapplication.databinding.ActivityUser2RegisterBinding;

import java.util.Objects;


public class User2RegisterActivity extends AppCompatActivity {
    ActivityUser2RegisterBinding activityUser2RegisterBinding;
    UserRegisterViewModel userRegisterViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userRegisterViewModel = ViewModelProviders.of(this).get(UserRegisterViewModel.class);
        activityUser2RegisterBinding = DataBindingUtil.setContentView(User2RegisterActivity.this, R.layout.activity_user2_register);
        activityUser2RegisterBinding.setUserRegisterViewModel(userRegisterViewModel);
        activityUser2RegisterBinding.setLifecycleOwner(this);
        userRegisterViewModel.getUserValidation().observe(this, new Observer<UserRegisterModel>() {
            @Override
            public void onChanged(UserRegisterModel userRegisterModel) {
                Log.e("", "");
                if (TextUtils.isEmpty(Objects.requireNonNull(userRegisterModel).getNm())) {
                    activityUser2RegisterBinding.nmEdt.setError("Enter a user name");
                    activityUser2RegisterBinding.nmEdt.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(userRegisterModel).getEmail())) {
                    activityUser2RegisterBinding.emailEdt.setError("Enter an E-Mail Address");
                    activityUser2RegisterBinding.emailEdt.requestFocus();
                } else if (!userRegisterModel.isEmailValid()) {
                    activityUser2RegisterBinding.emailEdt.setError("Enter an valid E-Mail address");
                    activityUser2RegisterBinding.emailEdt.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(userRegisterModel).getPass())) {
                    activityUser2RegisterBinding.passEdt.setError("Enter a password");
                    activityUser2RegisterBinding.passEdt.requestFocus();
                } else {
                    UserDataBase.getDataBaseInstance(getApplication().getApplicationContext()).userRegisterDao().insertNewUser(userRegisterModel);
                    Log.e("", "");
                    User2RegisterActivity.this.finish();
                }
            }
        });

    }
}
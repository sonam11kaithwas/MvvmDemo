package com.example.myapplication.login_pkg;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.database.UserDataBase;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.login_user_list_pkg.LoginUserListActivity;
import com.example.myapplication.usr_registrer.User2RegisterActivity;

import java.util.Objects;

public class LoginMainActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        activityMainBinding = DataBindingUtil.setContentView(LoginMainActivity.this, R.layout.activity_main);
        activityMainBinding.setLifecycleOwner(this);

        activityMainBinding.setLoginViewModel(loginViewModel);

        loginViewModel.getUser().observe(this, new Observer<LoginModel>() {
            @Override
            public void onChanged(@Nullable LoginModel loginUser) {

                if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getEmailid())) {
                    activityMainBinding.txtEmailAddress.setError("Enter an E-Mail Address");
                    activityMainBinding.txtEmailAddress.requestFocus();
                } else if (!loginUser.isEmailValid()) {
                    activityMainBinding.txtEmailAddress.setError("Enter a Valid E-mail Address");
                    activityMainBinding.txtEmailAddress.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getPassword())) {
                    activityMainBinding.txtPassword.setError("Enter a Password");
                    activityMainBinding.txtPassword.requestFocus();
                } else if (!loginUser.isPasswordLengthGreaterThan5()) {
                    activityMainBinding.txtPassword.setError("Enter at least 6 Digit password");
                    activityMainBinding.txtPassword.requestFocus();
                } else {
                    boolean check = UserDataBase.getDataBaseInstance(LoginMainActivity.this).userRegisterDao().getfindUser(loginUser.getEmailid(), loginUser.getPassword());
                    activityMainBinding.lblEmailAnswer.setText(loginUser.getEmailid());
                    activityMainBinding.lblPasswordAnswer.setText(loginUser.getPassword());
                    if (check)
                        startActivity(new Intent(LoginMainActivity.this, LoginUserListActivity.class));
                    else
                        Toast.makeText(LoginMainActivity.this, "User Not Found", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void back(View view) {
        startActivity(new Intent(LoginMainActivity.this, User2RegisterActivity.class));
    }
}
package com.example.myapplication.login_user_list_pkg;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.database.UserDataBase;
import com.example.myapplication.databinding.ActivityLoginUserListBinding;
import com.example.myapplication.login_user_list_pkg.user_adpter.UserListAdpter;


public class LoginUserListActivity extends AppCompatActivity {
    private UserListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login_user_list);
        setupBindings(savedInstanceState);
    }

    private void setupBindings(Bundle savedInstanceState) {
        ActivityLoginUserListBinding activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_user_list);
        viewModel = ViewModelProviders.of(this).get(UserListViewModel.class);
        UserListAdpter myRecyclerViewAdapter = new UserListAdpter(UserDataBase.getDataBaseInstance(LoginUserListActivity.this).userRegisterDao().getUserList(), this);
        activityBinding.listOfUsers.setAdapter(myRecyclerViewAdapter);
    }

}
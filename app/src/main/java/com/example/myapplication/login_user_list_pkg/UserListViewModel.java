package com.example.myapplication.login_user_list_pkg;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.R;
import com.example.myapplication.application_pkg.MyApp;
import com.example.myapplication.database.UserDataBase;
import com.example.myapplication.database.UserRegisterModel;
import com.example.myapplication.login_user_list_pkg.user_adpter.UserListAdpter;

import java.util.List;

/**
 * Created by Sonam-11 on 28/8/20.
 */
public class UserListViewModel extends ViewModel {
    private UserRegisterModel userRegisterModel;
    private UserListAdpter adapter;


    public void fetchList() {
        UserDataBase.getDataBaseInstance(MyApp.getINSTANCE()).userRegisterDao().getUserList();
    }

    public MutableLiveData<List<UserRegisterModel>> getBreeds() {
        return null;

    }


}
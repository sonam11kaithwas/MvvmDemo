package com.example.myapplication.login_user_list_pkg.user_adpter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.BR;
import com.example.myapplication.CustomClickListener;
import com.example.myapplication.R;
import com.example.myapplication.database.UserRegisterModel;
import com.example.myapplication.databinding.UserViewLayoutBinding;
import com.example.myapplication.login_user_list_pkg.LoginUserListActivity;

import java.util.List;

/**
 * Created by Sonam-11 on 28/8/20.
 */
public class UserListAdpter extends RecyclerView.Adapter<UserListAdpter.ViewHolder> implements CustomClickListener {

    private List<UserRegisterModel> dataModelList;
    private Context context;

    public UserListAdpter(List<UserRegisterModel> userList, LoginUserListActivity ctx) {
        this.dataModelList = userList;
        context = ctx;
    }

    @Override
    public UserListAdpter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        UserViewLayoutBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.user_view_layout, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserRegisterModel dataModel = dataModelList.get(position);
        holder.bind(dataModel);
        holder.itemRowBinding.setItemClickListner(this);
    }


    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public void cardClicked(UserRegisterModel f) {
        Toast.makeText(context, "You clicked " + f.getNm(),
                Toast.LENGTH_LONG).show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public UserViewLayoutBinding itemRowBinding;

        public ViewHolder(UserViewLayoutBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.model, obj);
            itemRowBinding.executePendingBindings();
        }
    }
}

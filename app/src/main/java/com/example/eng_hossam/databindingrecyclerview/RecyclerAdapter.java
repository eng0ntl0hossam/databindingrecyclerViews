package com.example.eng_hossam.databindingrecyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eng_hossam.databindingrecyclerview.databinding.ItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context context;
    List<User> users=new ArrayList<>();

    public RecyclerAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ItemLayoutBinding itemLayoutBinding= DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),R.layout.item_layout,viewGroup,false);
        MyViewHolder myViewHolder=new MyViewHolder(itemLayoutBinding);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        User user = users.get(i);
        viewHolder.itemLayoutBinding.setUser(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ItemLayoutBinding itemLayoutBinding;
        public MyViewHolder(@NonNull ItemLayoutBinding itemView) {
            super(itemView.getRoot());
            itemLayoutBinding=itemView;
        }
    }
}

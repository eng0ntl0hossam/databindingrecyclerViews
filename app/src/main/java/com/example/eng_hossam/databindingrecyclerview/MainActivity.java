package com.example.eng_hossam.databindingrecyclerview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.eng_hossam.databindingrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.recyclerview.setHasFixedSize(true);
        adapter = new RecyclerAdapter(this, prepareUser());
        mainBinding.recyclerview.setAdapter(adapter);


    }


    private List<User> prepareUser() {
        List<String> names = Arrays.asList(getResources().getStringArray(R.array.names));
        List<String> mails = Arrays.asList(getResources().getStringArray(R.array.emails));
        int[] imageIds = {R.drawable.album1, R.drawable.album2, R.drawable.album3, R.drawable.album4, R.drawable.album5, R.drawable.album6,
                R.drawable.album7, R.drawable.album8, R.drawable.album9, R.drawable.album10, R.drawable.album11, R.drawable.album2, R.drawable.album3,
                R.drawable.album4, R.drawable.album5, R.drawable.album6, R.drawable.album7, R.drawable.album8, R.drawable.album9, R.drawable.album10};

        List<User> userList = new ArrayList<>();
        int coount = 0;
        for (String name : names) {
            userList.add(new User(name, mails.get(coount), imageIds[coount]));
            coount++;
        }
        return userList;
    }

}

package com.codingblocks.interfragmentcommunication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class ActivityDetail extends AppCompatActivity implements Communicator {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportFragmentManager().beginTransaction()
//                .add()
//                .commit();
//    }
    }

    @Override
    public void startFragmentB(DetailFragment detailFragment) {
    }
}

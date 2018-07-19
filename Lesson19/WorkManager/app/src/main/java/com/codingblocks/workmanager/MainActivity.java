package com.codingblocks.workmanager;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.State;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkStatus;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSchedule = findViewById(R.id.btnSchedule);
        btnSchedule.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresStorageNotLow(true)
                .build();

        Data data = new Data.Builder()
                .putString("HELLO","WORLD")
                .build();

        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest
                .Builder(MyWorker.class)
                //Set some input data to be received by the Worker
                .setInputData(data)
                //Start the task with some delay
                .setInitialDelay(15, TimeUnit.SECONDS)
                //Set conditions which must be fulfilled by the task
                .setConstraints(constraints)
                .build();

        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest
                .Builder(MyWorker.class,
                1,
                TimeUnit.DAYS,
                30,
                TimeUnit.MINUTES)
                .build();

        WorkManager.getInstance().enqueue(oneTimeWorkRequest);

        LiveData<WorkStatus> liveData = WorkManager.getInstance()
                .getStatusById(oneTimeWorkRequest.getId());

        //Listen for the changes in the state of the Work and react accordingly
        liveData.observe(this, new Observer<WorkStatus>() {
            @Override
            public void onChanged(@Nullable WorkStatus workStatus) {

                State state = workStatus.getState();
                if (state == State.FAILED){

                }else if (state == State.SUCCEEDED){
                    //Fetch data from the database and set it to the ArrayList
                }

            }
        });

//        WorkManager.getInstance().getStatusById(oneTimeWorkRequest.getId()).observe(this, new Observer<WorkStatus>() {
//            @Override
//            public void onChanged(@Nullable WorkStatus workStatus) {
//
//            }
//        });
    }
}

package com.codingblocks.workmanager;

import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Data;
import androidx.work.Worker;

public class MyWorker extends Worker {

    @NonNull
    @Override
    public Result doWork() {
        //This runs in a separate thread,
        // so run all long running operations here

        //Receive the data provided to the worker
        Data returnedData = getInputData();


        //The application context is not a complete context.
        //You can't use it to do any UI related operations, for
        //example displaying a toast, or an AlertDialog

//        getApplicationContext();

        for (int i = 0; i < 10000000; i++) {
            //Run a long running loop
        }
        Log.e("TAG", "doWork: complete");
        try {
            //Make a network call
            return Result.SUCCESS;
        } catch (Exception e) {

            //either return Result.RETRY or Result.FAILURE

            return Result.FAILURE;
        }
    }

}

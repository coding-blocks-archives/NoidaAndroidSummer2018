package com.codingblocks.roomdb;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.codingblocks.roomdb.model.Task;

import java.util.List;

public class MyViewModel extends ViewModel {

    //ViewModel outlives the Activity/Fragment lifecycle
    //Never store any UI object here
    private LiveData<List<Task>> taskListLiveData;
    private String json = "";

    String makeNetworkCall(){
        if (json.equals("")){
            //If the json is empty, only then make the OKHttp call
        }
        return json;
    }

    LiveData<List<Task>> getTaskFromDatabase() {
        if (taskListLiveData == null)
            taskListLiveData = TaskApplication.getDb().getTaskDao().getAllTasks();
        return taskListLiveData;
    }

}

package com.codingblocks.roomdb;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.codingblocks.roomdb.model.Task;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.insert);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Task task = new Task("Time is ",
                        String.valueOf(System.currentTimeMillis()),
                        false);

                TaskApplication.getDb().getTaskDao().insertTask(task);
                //Adding this task to arraylist is not needed
            }
        });

        //LiveData allows us to attach an observer onto it
        //and using that we can listen for changes
        //This gives a callback whenever the db changes
        TaskApplication.getDb().getTaskDao().getAllTasks()
                .observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(@Nullable List<Task> tasks) {
                //Retrieve the updated list of tasks
                Log.e("TAG", "onChanged: task size" + tasks.size()  );
                //Update the recyclerview adapter
            }
        });
    }
}

package com.codingblocks.asynchronoustasks;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        final ProgressBar progressBar = findViewById(R.id.pb);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //At a time, the Android Framework can only run 5-6 AsyncTasks parallely.
                //Rest of the tasks are kept in a separate queue

                final MyPersonalLovelyTask myPersonalLovelyTask = new MyPersonalLovelyTask();
                myPersonalLovelyTask.execute(10000000L);
                final MyPersonalLovelyTask myPersonalLovelyTask1 = new MyPersonalLovelyTask();
                myPersonalLovelyTask1.execute(20000000L);
                final MyPersonalLovelyTask myPersonalLovelyTask2 = new MyPersonalLovelyTask();
                myPersonalLovelyTask2.execute(30000000L);
//                count();
            }
        });
    }


    class MyPersonalLovelyTask extends AsyncTask<Long, Long, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Long... longs) {
            Long firstNum = longs[0];
            Long secondNum = longs[1];

            for (Long i = 0L; i < firstNum; i++) {
                if (i % 100000 == 0) {
//                    publishProgress(i); //Calls onProgressUpdate
                }
                //Counting
            }

            return "Counting Done"; //Passes this string to onPostExecute
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            Log.e("TAG", "onProgressUpdate: " + values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText(s);
        }
    }


//    void count() {
//        final Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (long i = 0; i < 1000000000; i++) {
//                    //Count
//                }
//
////                textView.setText("Counting Done");
//
//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText("Counting Done");
//                    }
//                });
//            }
//        });
//        thread.start();
//    }

}

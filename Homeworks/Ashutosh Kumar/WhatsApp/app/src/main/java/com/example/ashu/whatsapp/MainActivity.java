package com.example.ashu.whatsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
     RecyclerView recyclerView ;
    ArrayList<messageInfo> messageInfoArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageInfoArrayList.add(new messageInfo("Ashutosh","9818553281",getDate(),
                "http://www.designskilz.com/random-users/images/imageM43.jpg"));
        messageInfoArrayList.add(new messageInfo("Prince","Call me back.",getDate(),
                "http://www.designskilz.com/random-users/images/imageF42.jpg"));
        messageInfoArrayList.add(new messageInfo("Sonu","See you again.",getDate(),
                "http://www.designskilz.com/random-users/images/imageM44.jpg"));
        messageInfoArrayList.add(new messageInfo("Rajeev","thanks",getDate(),
                "http://www.designskilz.com/random-users/images/imageM45.jpg"));
        messageInfoArrayList.add(new messageInfo("Ashish","You were added to this group",getDate(),
                "http://www.designskilz.com/random-users/images/imageF48.jpg"));
        messageInfoArrayList.add(new messageInfo("Shanky","1236547896",getDate(),
                "http://www.designskilz.com/random-users/images/imageM50.jpg"));
        messageInfoArrayList.add(new messageInfo("Coding Block","9423658756",getDate(),
                "http://www.designskilz.com/random-users/images/imageM47.jpg"));
        messageInfoArrayList.add(new messageInfo("G B Pant","Mini Militia",getDate(),
                "http://www.designskilz.com/random-users/images/imageF40.jpg"));
        messageInfoArrayList.add(new messageInfo("CSE","seen",getDate(),
                "http://www.designskilz.com/random-users/images/imageM41.jpg"));
        messageInfoArrayList.add(new messageInfo("MAE","Real MM",getDate(),
                "http://www.designskilz.com/random-users/images/imageF51.jpg"));
        messageInfoArrayList.add(new messageInfo("Sports","1568569136",getDate(),
                "http://www.designskilz.com/random-users/images/imageM10.jpg"));
        messageInfoArrayList.add(new messageInfo("Laptop","You were added to this group",getDate(),
                "http://www.designskilz.com/random-users/images/imageM34.jpg"));
        messageInfoArrayList.add(new messageInfo("Toon","Cat Group",getDate(),
                "http://www.designskilz.com/random-users/images/imageM13.jpg"));
        messageInfoArrayList.add(new messageInfo("College","0236589541",getDate(),
                "http://www.designskilz.com/random-users/images/imageM23.jpg"));
        messageInfoArrayList.add(new messageInfo("Hindi","Animal Group",getDate(),
                "http://www.designskilz.com/random-users/images/imageM14.jpg"));
        messageInfoArrayList.add(new messageInfo("English","You were added to this group",getDate(),
                "http://www.designskilz.com/random-users/images/imageF15.jpg"));
        messageInfoArrayList.add(new messageInfo("Animal","You were added to this group",getDate(),
                "http://www.designskilz.com/random-users/images/imageF16.jpg"));

   recyclerView = findViewById(R.id.recycleView);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        NoteAdapter noteAdapter = new NoteAdapter(getBaseContext(),messageInfoArrayList);
        recyclerView.setAdapter(noteAdapter);


    }

    public String getDate(){
//        Calendar c = Calendar.getInstance();
//        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yy");
//        return date.format(c.getTime());
        Random r = new Random();
        int day = r.nextInt(31)+1;
        int year = r.nextInt(2)+17;
        int month = r.nextInt(12)+1;
        String s = day + "/" + month + "/" + year;
        return s;
    }
}

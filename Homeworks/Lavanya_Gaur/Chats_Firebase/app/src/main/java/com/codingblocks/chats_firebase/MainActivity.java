package com.codingblocks.chats_firebase;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Chats> chatsArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etName=findViewById(R.id.etName);
        Button btnPush=findViewById(R.id.btnPush);
        recyclerView=findViewById(R.id.rvView);

        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();

        final DatabaseReference rootRef=firebaseDatabase.getReference();

        final ChatsAdapter chatsAdapter=new ChatsAdapter(this,chatsArrayList);

        LinearLayoutManager llm = new LinearLayoutManager(getBaseContext());
        llm.setReverseLayout(true);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(chatsAdapter);


        btnPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredName=etName.getText().toString();
                //Submit the entered data to the firebase
//                childRef.child(String.valueOf(System.currentTimeMillis())).setValue(enteredName);  result in data loss

                Chats chats=new Chats("https://randomuser.me/api/portraits/women/93.jpg",enteredName);
                DatabaseReference newRef=rootRef.push();
                newRef.setValue(chats); //push generates a unique key

            }
        });
//        rootRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                //datasnapshot contains data inside rootref
//
//                Iterable<DataSnapshot> dataSnapshots= dataSnapshot.getChildren();  //iterable is an interface
//                for(DataSnapshot ds:dataSnapshots){
//                    Task currentTask=ds.getValue(Task.class);
//
//                    Log.e("TAG", "onDataChange: "+currentTask.getTitle() );
//                    Log.e("TAG", "onDataChange: "+currentTask.getId() );
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });


        rootRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Chats currentchat=dataSnapshot.getValue(Chats.class);
                chatsArrayList.add(currentchat);
                chatsAdapter.notifyDataSetChanged();


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}

package com.codingblocks.firebaseapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ChildEventListener, FirebaseAuth.AuthStateListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.addAuthStateListener(this);
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        if (firebaseAuth.getCurrentUser() == null) {
            //start login
            Intent loginIntent = AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(Arrays.asList(
                            new AuthUI.IdpConfig.GoogleBuilder().build(),
                            new AuthUI.IdpConfig.EmailBuilder().build(),
                            new AuthUI.IdpConfig.PhoneBuilder().build()))
                    .build();

            startActivity(loginIntent);
        } else {
            final EditText etName = findViewById(R.id.etName);
            Button btnPush = findViewById(R.id.btnPush);
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            final DatabaseReference rootRef = firebaseDatabase.getReference();
            btnPush.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String enteredName = etName.getText().toString();
                    //Submit the entered data to firebase

                    Task task = new Task(enteredName,
                            " Current time is ",
                            System.currentTimeMillis());

                    DatabaseReference newRef = rootRef.push();
                    newRef.setValue(task);
                }
            });
            rootRef.addChildEventListener(this);
        }
    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        Task task = dataSnapshot.getValue(Task.class);
        //Add this task to the arraylist
        //Call notifyDatasetChanged on the adapter

        Log.e("TAG", "onChildAdded: " + task.getTitle());

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


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//    }
}

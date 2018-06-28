package com.example.dhirajchhabraeng.homework;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Random;

public class UserListFragment extends Fragment {

    private ArrayList<User> usersList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_list_view, container, false);

        String url = "https://randomuser.me/api/portraits/";

        usersList.add(new User("" + url, "dhiraj", "Bio", "", "", 0));
        usersList.add(new User("" + url, "vaishali", "Bio", "", "", 1));
        usersList.add(new User("" + url, "sarita", "Bio", "", "", 1));
        usersList.add(new User("" + url, "mummy", "Bio", "", "", 1));
        usersList.add(new User("" + url, "papa", "Bio", "", "", 0));
        usersList.add(new User("" + url, "daman", "Bio", "", "", 0));
        usersList.add(new User("" + url, "sanket", "Bio", "", "", 0));
        usersList.add(new User("" + url, "bhai", "Bio", "", "", 0));
        usersList.add(new User("" + url, "dady", "Bio", "", "", 0));
        usersList.add(new User("" + url, "badi mummy", "Bio", "", "", 1));
        usersList.add(new User("" + url, "dadi", "Bio", "", "", 1));
        usersList.add(new User("" + url, "bhabhi", "Bio", "", "", 1));
        usersList.add(new User("" + url, "sonia didi", "Bio", "", "", 1));
        usersList.add(new User("" + url, "dushyant jija ji", "Bio", "", "", 0));

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        UsersAdapter usersAdapter = new UsersAdapter(getContext(), usersList, getActivity());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(usersAdapter);

        return view;
    }
}

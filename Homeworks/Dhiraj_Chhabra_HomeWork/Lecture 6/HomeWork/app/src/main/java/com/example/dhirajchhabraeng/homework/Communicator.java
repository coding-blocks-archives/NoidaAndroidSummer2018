package com.example.dhirajchhabraeng.homework;

import android.app.Fragment;

public interface Communicator {

    void startFragmentList(android.support.v4.app.Fragment listFragment);

    void startFragmentDetails(android.support.v4.app.Fragment detailsFragment);

    void onHandleClick(android.support.v4.app.Fragment fragment);
}

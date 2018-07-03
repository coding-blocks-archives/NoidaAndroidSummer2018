package com.example.dell1.dynamicfragmentself;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class fragment_1 extends android.support.v4.app.Fragment{

    int count=0;

    @Override
    //called when fragment is created
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    //called when we need to create the view through our layout file by making use of layout inflater

    //hume fragment 1 kab add karna hai? oncreation of the app i.e it should be added as soon as it is created
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_1,container,false);

        //this in between part here is for setting desired actions on the view.Ex:-when button is clicked do something
        Button btn=view.findViewById(R.id.fragment_1_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count++;

                ///hume fragment 2 kab add karna hai? when the increment button is clicked then add karna hai!
                MainActivity mi=(MainActivity) getActivity(); //mainactivity ki activity leni padega since fragment 2 humneussi ke
                //parent activity  mein banana hai although iss fragment ko apni koi generic activity assigned hogi,so we need to do this above.

                mi.addFragment2(new fragment_2(count)); //main activity mein ek method banaya hai jisme ki fragment b ka object pass
                //ho rha hai and thus every click generates the fragment_2.
            }
        });
        return view; 
    }
}

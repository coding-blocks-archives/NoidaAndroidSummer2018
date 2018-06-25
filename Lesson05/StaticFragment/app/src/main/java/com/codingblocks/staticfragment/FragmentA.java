package com.codingblocks.staticfragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentA extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_a_layout, container, false);

        Button btn = view.findViewById(R.id.btnFragA);
        final EditText et = view.findViewById(R.id.etFragA);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel://" + et.getText().toString()));
//                MainActivity mainActivity = (MainActivity) getActivity();
//                mainActivity.helloThere();

//                ((MainActivity)getActivity()).helloThere();
                startActivity(i);


                Toast.makeText(getContext(), et.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

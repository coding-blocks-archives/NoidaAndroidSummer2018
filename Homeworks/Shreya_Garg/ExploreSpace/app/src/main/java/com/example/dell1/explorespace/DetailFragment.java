package com.example.dell1.explorespace;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment{

    String planet="PLANET";
    String star="STAR";
    String gal="GALAXY";

    public static DetailFragment newInstance(Space s){

        Bundle args=new Bundle();
        args.putParcelable("SPACE",s);

        DetailFragment fragment=new DetailFragment();
        fragment.setArguments(args);
        return fragment;
        
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view= inflater.inflate(R.layout.detailfragment_layout,container,false);
        Bundle bundle=getArguments();

        TextView typetv=view.findViewById(R.id.typespacetv);
        ImageView img=view.findViewById(R.id.spaceimg);
        TextView name=view.findViewById(R.id.nametv);
        TextView detail=view.findViewById(R.id.detailtv);
        FloatingActionButton fab=view.findViewById(R.id.fabWiki);

        final Space spaceobject = (Space) bundle.getParcelable("SPACE");

        int x=spaceobject.getType_item();
        switch (x){
            case 0:
                typetv.setText(planet);
                break;
            case 1:
                typetv.setText(star);
                break;
            case 2:
                typetv.setText(gal);
                break;
        }
        Picasso.with(getContext()).load(spaceobject.getImageUrl()).into(img);
        name.setText(spaceobject.getName());
        detail.setText(spaceobject.getDetails());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(spaceobject.getWikiUrl()));
                startActivity(i);
            }
        });


        return view;
    }
}

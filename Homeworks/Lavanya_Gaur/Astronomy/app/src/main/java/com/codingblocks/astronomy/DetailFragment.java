package com.codingblocks.astronomy;

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
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment {

//    String planet = "PLANET";
//    String star = "STAR";
//    String gal="GALAXY";

    public static DetailFragment newInstance(Space space) {

        Bundle args = new Bundle();
        args.putParcelable("SPACE",space);

        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.detail_fragment,container,false);
        Bundle bundle=getArguments();

        TextView typetv=view.findViewById(R.id.typespacetv);
        ImageView img=view.findViewById(R.id.spaceimg);
        TextView name=view.findViewById(R.id.nametv);
        TextView detail=view.findViewById(R.id.detailtv);
        FloatingActionButton fab=view.findViewById(R.id.fabwiki);

        final Space spaceObject= (Space)bundle.getParcelable("SPACE");
        int x=spaceObject.getType_item();
        switch (x){
            case 0:typetv.setText("PLANET");
            break;
            case 1:typetv.setText("STAR");
            break;
            case 2:typetv.setText("GALAXY");
            break;
        }

        Picasso.get().load(spaceObject.getImageUrl()).into(img);
        name.setText(spaceObject.getName());
        detail.setText(spaceObject.getDetails());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW);
              i.setData(Uri.parse(spaceObject.getWikiUrl()));
              startActivity(i);
            }
        });
    return view;
    }
}

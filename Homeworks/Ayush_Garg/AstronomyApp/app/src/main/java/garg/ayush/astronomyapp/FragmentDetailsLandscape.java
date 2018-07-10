package garg.ayush.astronomyapp;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetailsLandscape extends Fragment {

    public FragmentDetailsLandscape(String urlImageLandscape, String nameLandscape, String descriptionLandscape, String urlDescriptionLandscape) {
        this.urlImageLandscape = urlImageLandscape;
        this.nameLandscape = nameLandscape;
        this.descriptionLandscape = descriptionLandscape;
        this.urlDescriptionLandscape = urlDescriptionLandscape;
    }

    public String urlImageLandscape, nameLandscape, descriptionLandscape, urlDescriptionLandscape;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details_landscape, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView name = view.findViewById(R.id.fragment_detail_name);
        ImageView photo = view.findViewById(R.id.fragment_detail_image);
        TextView decsription =view.findViewById(R.id.fragment_detail_description);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.floatingActionButton);
        name.setText(nameLandscape);
        Picasso.get().load(urlImageLandscape).into(photo);
        decsription.setText(descriptionLandscape);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlDescriptionLandscape));
                startActivity(intent);
            }
        });

    }
}

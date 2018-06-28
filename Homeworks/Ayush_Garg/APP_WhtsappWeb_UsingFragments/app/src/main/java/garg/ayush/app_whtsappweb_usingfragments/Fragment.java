package garg.ayush.app_whtsappweb_usingfragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Fragment extends android.support.v4.app.Fragment {

    public Fragment(String facebookURL, String instagramURL, String imageURL, String contactName, String conatactMessage) {
        this.facebookURL = facebookURL;
        this.instagramURL = instagramURL;
        this.imageURL = imageURL;
        ContactName = contactName;
        ConatactMessage = conatactMessage;
    }

    String facebookURL,instagramURL,imageURL,ContactName,ConatactMessage;

    TextView name;
    TextView message;
    ImageView facebook;
    ImageView instagram;
    ImageView photo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment,container,false);
        name=view.findViewById(R.id.fragmentName);
        message=view.findViewById(R.id.fragmentMessage);
        photo=view.findViewById(R.id.fragmentImageView);
        facebook=view.findViewById(R.id.fragmentFacebook);
        instagram=view.findViewById(R.id.fragmentInstagram);
        name.setText(ContactName);
        message.setText(ConatactMessage);
        Picasso.get().load(facebookURL).into(facebook);
        Picasso.get().load(instagramURL).into(instagram);
        Picasso.get().load(imageURL).into(photo);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.facebook.com/"));
                startActivity(i);
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.instagram.com/"));
                startActivity(i);
            }
        });
        return view;
    }
}

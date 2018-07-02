package com.example.dell1.github_profiles_hw_l09;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProfileDetail extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_detail);
        Intent i=getIntent();
        String username=i.getStringExtra("login");
        String image=i.getStringExtra("image");
        String userId=i.getStringExtra("id");
        final String userlink=i.getStringExtra("link");
        TextView id=findViewById(R.id.detail_id);
        TextView name=findViewById(R.id.detail_name);
        TextView link=findViewById(R.id.detail_link);
        ImageView imageView=findViewById(R.id.detail_img);

        name.setText(username);
        Picasso.with(getBaseContext()).load(image).into(imageView);
        id.setText("User ID : " + userId);
        link.setText(userlink);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(userlink));
                startActivity(i);
            }
        });
    }
}

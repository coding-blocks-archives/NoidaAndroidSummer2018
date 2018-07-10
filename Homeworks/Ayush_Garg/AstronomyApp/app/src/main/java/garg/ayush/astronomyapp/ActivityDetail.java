package garg.ayush.astronomyapp;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ActivityDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.frgment_detail);
        TextView name = findViewById(R.id.fragment_detail_name);
        ImageView photo = findViewById(R.id.fragment_detail_image);
        TextView decsription =findViewById(R.id.fragment_detail_description);
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        final Intent i = getIntent();
        name.setText(i.getStringExtra("name"));
        Picasso.get().load(i.getStringExtra("URLImage")).into(photo);
        decsription.setText(i.getStringExtra("Description"));
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(i.getStringExtra("URLDescription")));
                startActivity(intent);
            }
        });
    }
}

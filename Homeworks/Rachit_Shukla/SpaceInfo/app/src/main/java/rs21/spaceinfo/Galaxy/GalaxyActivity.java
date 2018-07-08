package rs21.spaceinfo.Galaxy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import rs21.spaceinfo.R;

public class GalaxyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_view);
        Intent i = getIntent();
        Bundle g = i.getExtras();
        Galaxies x = (Galaxies) g.get("a");
        FragDetailGalaxy a = FragDetailGalaxy.newInstance(x);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragInfoL, a).commit();
    }
}

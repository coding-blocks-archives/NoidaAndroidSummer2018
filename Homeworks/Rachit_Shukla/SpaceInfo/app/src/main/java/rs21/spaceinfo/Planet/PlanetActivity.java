package rs21.spaceinfo.Planet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import rs21.spaceinfo.R;

public class PlanetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_view);
        Intent i = getIntent();
        Bundle g = i.getExtras();
        Planets x = (Planets) g.get("xyz");
        FragDetailPlanet a = FragDetailPlanet.newInstance(x);
        getSupportFragmentManager().beginTransaction().add(R.id.fragInfoL, a).commit();
    }
}
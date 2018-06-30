package rs21.infoviewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements Communicator {
    @Override
    public void addFragB(FragmentInfo b) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragInfo, b).commit();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_view);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        abc x = (abc) b.get("a");
        FragmentInfo a = FragmentInfo.newInstance(x);
        getSupportFragmentManager().beginTransaction().add(R.id.fragInfoL, a).commit();
    }
}

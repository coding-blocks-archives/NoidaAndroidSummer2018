package rs21.infoviewer;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            FragmentNames a = FragmentNames.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragNames, a).commit();
        } else {
            FragmentNames a = FragmentNames.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragNames, a).commit();

            FragmentInfo b = FragmentInfo.newInstance(abc.getPersons().get(0));
            getSupportFragmentManager().beginTransaction().replace(R.id.fragInfo, b).commit();
        }
    }

    @Override
    public void addFragB(FragmentInfo b) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragInfo, b).commit();
    }

}

package com.chirag_bhardwaj.stepcounter;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    TextView textView;
    boolean running=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.steps);

        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        running=true;
        Sensor countsensor=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countsensor!=null)
        {sensorManager.registerListener(this,countsensor,SensorManager.SENSOR_DELAY_UI);}
        else
            {
                Toast.makeText(this,"Sensor Not Found!",Toast.LENGTH_SHORT).show();
            }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(running)
        textView.setText(String.valueOf(sensorEvent.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

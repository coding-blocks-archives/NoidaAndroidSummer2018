package com.example.robin.pedometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    Button start,reset;
    TextView txt;
    int steps=0;
    int t=-1;
    SensorManager sensorManager;
    Sensor step;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);
        reset  =findViewById(R.id.reset);
        txt = findViewById(R.id.count);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        step = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

        sensorManager.registerListener( this,step,SensorManager.SENSOR_DELAY_NORMAL);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t=0;


            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t=-1;
                steps = 0;
                txt.setText("Steps: 0");

            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        float[] values = sensorEvent.values;
        int value = -1;

        if (values.length > 0) {
            value = (int) values[0];
        }


        if ((sensor.getType() == Sensor.TYPE_STEP_DETECTOR)&&(t==0)) {
            steps++;
            txt.setText("Steps: "+steps);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this,step);
    }
}

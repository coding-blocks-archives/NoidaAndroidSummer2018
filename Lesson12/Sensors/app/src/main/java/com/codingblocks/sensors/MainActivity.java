package com.codingblocks.sensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    public static final String TAG = "MainActivity";
    TextView tviewX,tviewY,tviewZ;
    LinearLayout linearLayout;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tviewX = findViewById(R.id.gravityInX);
        tviewY = findViewById(R.id.gravityInY);
        tviewZ = findViewById(R.id.gravityInZ);
        linearLayout = findViewById(R.id.lLayout);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);


//        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

//        Log.e(TAG, "onCreate: Number of sensors " + sensors.size());

//        for (Sensor s : sensors){
//            Log.e(TAG, "onCreate: -------------------" );
//            Log.e(TAG, "onCreate: " + s.toString() );
//            Log.e(TAG, "onCreate: -------------------" );
//        }

        //Registers the sensor for updates
//          sensorManager.registerListener(this, orientationSensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
//        if (event.sensor.getName().equals("Orientation")){
//            //Handle the orientation changes
//        }else if (event.sensor.getName().equals("Gravity")){
//            //Handle the gravity changes
//        }

        float[] valueArray = event.values;

        tviewX.setText(""+ valueArray[0]);
        tviewY.setText(""+ valueArray[1]);
        tviewZ.setText(""+ valueArray[2]);

        //Convert the values to colors

        int red = (int) ((Math.abs(valueArray[0]) / 9.8 ) * 255);
        int green = (int) (( Math.abs(valueArray[1]) / 9.8 ) * 255);
        int blue = (int) (( Math.abs(valueArray[2]) / 9.8 ) * 255);

        int color = Color.rgb(red,green,blue);

        linearLayout.setBackgroundColor(color);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Sensor gravityDefault = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensorManager.registerListener(this,gravityDefault,SensorManager.SENSOR_DELAY_UI);
//
    }

    @Override
    protected void onStop() {
        super.onStop();
        //this will unregister the sensor event listener
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //This is called whenever the accuracy of the sensor changes
    }
}

package garg.ayush.countingsteps;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView textView;
    Button button;
    Boolean activityRunning;
    SensorManager sensorManager;
    int steps=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text);
        Button button =findViewById(R.id.btn);
        activityRunning = true;
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        final Sensor StepDetectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityRunning=true;
            }
        });
        sensorManager.registerListener(MainActivity.this,StepDetectorSensor,SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//        Sensor StepDetectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
//        sensorManager.registerListener(this,StepDetectorSensor,SensorManager.SENSOR_DELAY_UI);

    }

    @Override
    protected void onStop() {
        super.onStop();
        activityRunning=false;
//        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityRunning=false;
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {



        final int[] extra = {0};
        final float[] valuesArray = sensorEvent.values;
        final int[] display = {(int) valuesArray[0]};
        button = findViewById(R.id.btn);
        if(activityRunning){
            steps++;
            textView.setText(steps+"");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                steps=0;
                textView.setText(steps+"");
            }
        });
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

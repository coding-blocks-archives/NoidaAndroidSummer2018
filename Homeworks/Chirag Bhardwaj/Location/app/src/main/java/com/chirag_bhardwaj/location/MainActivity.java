package com.chirag_bhardwaj.location;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    public static final int REQUEST_CODE_LOCATION_PERMISSION = 1234;
    LocationManager locationManager;
    TextView textView1,textView2,textView3,textView4,textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1=findViewById(R.id.tv1);
        textView2=findViewById(R.id.tv2);
        textView3=findViewById(R.id.tv3);
        textView4=findViewById(R.id.tv4);
        textView5=findViewById(R.id.tv5);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_DENIED
                ||
                ContextCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_DENIED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.CALL_PHONE},
                    REQUEST_CODE_LOCATION_PERMISSION);

        } else {
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                addLocationListeners();
            } else {
                Toast.makeText(this, "Looks like your location is disabled, please enable it for the app to run", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE_LOCATION_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    addLocationListeners();
                } else {
                    Toast.makeText(this, "Looks like your location is disabled, please enable it for the app to run", Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(this, "Thank you for granting the permissions!", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this,
                        "Sorry, but I need the permissions for the app to work!",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        textView1.setText("Latitude: "+location.getLatitude());
        textView2.setText("Longitude: "+location.getLongitude());
        textView3.setText("Altitude: "+location.getAltitude());
        textView4.setText("Speed: "+location.getSpeed());
        textView5.setText("Time: "+location.getTime());

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @SuppressLint("MissingPermission")
    public void addLocationListeners() {

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                1000,
                0,
                this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationManager.removeUpdates(this);
    }
}
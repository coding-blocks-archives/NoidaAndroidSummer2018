package com.example.dell.location;

import android.Manifest;
import android.annotation.SuppressLint;
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

    final int REQUEST_CODE_LOCATION_PERMISSION = 1234;
    String TAG = "MainActivity";
    LocationManager locationManager;
    TextView txt, txt1, txt2, txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);

        locationManager =

                (LocationManager) getSystemService(LOCATION_SERVICE);


        //Check to see if the app has location permissions or not

        // the checkSelfPermission returns 0 (PackageManager.PERMISSION_GRANTED)

        // if permission is granted

        // else it returns -1 (PackageManager.PERMISSION_DENIED)

        if (ContextCompat.checkSelfPermission(this,

                Manifest.permission.ACCESS_COARSE_LOCATION)

                != PackageManager.PERMISSION_GRANTED

                &&

                ContextCompat.checkSelfPermission(this,

                        Manifest.permission.ACCESS_FINE_LOCATION)

                        != PackageManager.PERMISSION_GRANTED) {


            //This block runs if I don't have either of the permissions

            ActivityCompat.requestPermissions(this,

                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,

                            Manifest.permission.ACCESS_FINE_LOCATION},

                    REQUEST_CODE_LOCATION_PERMISSION);


        } else {

            Location lastKnownLocation = locationManager.

                    getLastKnownLocation(LocationManager.GPS_PROVIDER);


            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,

                    5000,

                    10,

                    this);

        }

//        locationManager.addProximityAlert();

    }

    @SuppressLint("MissingPermission")

    @Override

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_LOCATION_PERMISSION) {
            //This means the onRequestPermissionsResult method was called when user initiated
            //permission for location, so handle the case accordingly.
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                addLocationListeners();
                Toast.makeText(this, "Thank you for granting the permissions!", Toast.LENGTH_SHORT).show();
                //Now we have the permission, so do the actual processing here
            } else {
                Toast.makeText(this,
                        "Sorry, but I need the permissions for the app to work!",
                        Toast.LENGTH_SHORT).show();
            }

        } else if (requestCode == 12) {

            //Some other permission request resulted in this callback, so handle that

        }
    }

    @Override
    public void onLocationChanged(Location location) {
        txt.setText("onLocationChanged: Latitude " + location.getLatitude());
        txt1.setText("onLocationChanged: Longitude " + location.getLongitude());
        txt2.setText("onLocationChanged: Provider " + location.getProvider());
        txt3.setText("onLocationChanged: Time " + location.getTime());
        //Only GPS provider will give the below value
//        Log.e(TAG, "onLocationChanged: Speed " + location.getSpeed());
        //      Log.e(TAG, "onLocationChanged: Accuracy " + location.getAccuracy());
        //    Log.e(TAG, "onLocationChanged: Altitude " + location.getAltitude());
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
    private void addLocationListeners() {
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                5000,
                0,
                this);
    }
}


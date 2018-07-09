package com.codingblocks.location;

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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    public static final String TAG = "MainActivity";
    public static final int REQUEST_CODE_LOCATION_PERMISSION = 1234;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        //Check to see if the app has location permissions or not
        // the checkSelfPermission returns 0 (PackageManager.PERMISSION_GRANTED)
        // if permission is granted
        // else it returns -1 (PackageManager.PERMISSION_DENIED)
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_DENIED
                ||
                ContextCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_DENIED) {

            //This block runs if I don't have either of the permissions
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.CALL_PHONE},
                    REQUEST_CODE_LOCATION_PERMISSION);

            //This won't work as the dialog shown above is async in nature

//            Location location = locationManager
//                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
        } else {
            Location lastKnownLocation = locationManager.
                    getLastKnownLocation(LocationManager.GPS_PROVIDER);

            addLocationListeners();
        }
//        locationManager.addProximityAlert();
//        requestPermissions(new String[]{Manifest.permission.CALL_PHONE},12);

    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
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
        Log.e(TAG, "onLocationChanged: Latitude " + location.getLatitude());
        Log.e(TAG, "onLocationChanged: Longitude " + location.getLongitude());
        Log.e(TAG, "onLocationChanged: Provider " + location.getProvider());
        Log.e(TAG, "onLocationChanged: Time " + location.getTime());
        //Only GPS provider will give the below value
        Log.e(TAG, "onLocationChanged: Speed " + location.getSpeed());
        Log.e(TAG, "onLocationChanged: Accuracy " + location.getAccuracy());
        Log.e(TAG, "onLocationChanged: Altitude " + location.getAltitude());
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
                5000,
                10,
                this);
    }

}

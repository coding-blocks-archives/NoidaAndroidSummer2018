package com.codingblocks.mapscont;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnMarkerDragListener,
        LocationListener {

    //    //This is Hungarian notation, don't use it
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        //Loads the map asynchronously
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        attachLocationListener();

        googleMap.setMapStyle(MapStyleOptions
                .loadRawResourceStyle(this, R.raw.map_style));

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);

        MarkerOptions markerOptions = new MarkerOptions()
                .draggable(true)
                .position(sydney)
                .title("Hello from Sydney!");

        LatLng delhi = new LatLng(28.35, 77.62);

        LatLng antarctica = new LatLng(82.86, 135);


        //Create a polyline options, i.e. an open polygon
        PolylineOptions polylineOptions = new PolylineOptions()
                .add(sydney, delhi, antarctica);

        //Create a circle option, used to draw circle on the map
        CircleOptions circleOptions = new CircleOptions()
                .center(sydney)
                .radius(1000);

        googleMap.addCircle(circleOptions);

        //Create a polygonOptions, used to draw closed shaped on the map
        PolygonOptions polygonOptions = new PolygonOptions()
                .add(sydney, delhi, antarctica);

//        polygonOptions.fillColor(R.color.colorAccent);

        googleMap.addPolygon(polygonOptions);

        googleMap.setOnMarkerDragListener(this);

        googleMap.addMarker(markerOptions);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10.0f));
//        googleMap.animateCamera(CameraUpdateFactory.newLatLng(sydney));
//        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
    }

    @SuppressLint("MissingPermission")
    private void attachLocationListener() {
        //Get access to the LocationManager object
        //Request location updates from the GPS provider for every 10 seconds
        // and 25 meters of distance travelled

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                10000,
                25,
                this);
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        //Called when the dragging starts

        LatLng newLatlng = marker.getPosition();
        //If you want the name of place from the lat and long,
        //use the google Places API
        MarkerOptions newMarkerOptions = new MarkerOptions()
                .position(newLatlng)
                .title(marker.getId())
                .draggable(true);
        mMap.addMarker(newMarkerOptions);

    }

    @Override
    public void onMarkerDrag(Marker marker) {
        //Called when the dragging is being done
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

        //Called when the dragging ends
        LatLng endLatLng = marker.getPosition();
        mMap.animateCamera(CameraUpdateFactory
                .newLatLngZoom(endLatLng, 10.0f));
    }

    @Override
    public void onLocationChanged(Location location) {

        //Create a new LatLng and draw a Polyline to this position on the map

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
}

package garg.ayush.maps;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,LocationListener {

    private GoogleMap mMap;
    final LatLng[] NEW = new LatLng[1];
    final LatLng[] OLD = new LatLng[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
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

//        OLD[0]=new LatLng(28.535517, 77.391029);
//        MarkerOptions markerOptions = new MarkerOptions()
//                .position(OLD[0])
//                .title("Starting Point")
//                .draggable(true);
//        mMap.addMarker(markerOptions);                ;
//        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(OLD[0],10.0f));
//        OLD[0]=null;
        attachLocationListener();

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//
//        OLD[0]=sydney;
////        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
////        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
////        PolylineOptions polylineOptions = new PolylineOptions()
////                .add();
////        LatLng testLocation=  new LatLng(40,151);
//
//
//        mMap.addMarker(markerOptions);
//        googleMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
//            @Override
//            public void onMarkerDragStart(Marker marker) {
////                LatLng newLatlng = marker.getPosition();
////                MarkerOptions newMarkerOptions = new MarkerOptions()
////                        .position(newLatlng)
////                        .title(marker.getId())
////                        .draggable(true);
////                googleMap.addMarker(newMarkerOptions);
////                OLD[0] =newLatlng;
//            }
//
//            @Override
//            public void onMarkerDrag(Marker marker) {
////                mMap.addPolyline(new PolylineOptions().add());
//            }
//
//            @Override
//            public void onMarkerDragEnd(Marker marker) {
//                LatLng endLatlng = marker.getPosition();
//                NEW[0] =endLatlng;
//                mMap.addPolyline(new PolylineOptions().add(OLD[0],NEW[0]));
//                OLD[0]=NEW[0];
//                MarkerOptions newMarkerOptions = new MarkerOptions()
//                        .position(OLD[0])
//                        .title(marker.getId())
//                        .draggable(true);
//                googleMap.addMarker(newMarkerOptions);
//            }
//        });
//
//        mMap.addMarker(markerOptions);
//        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney,10.0f));
    }

    @SuppressLint("MissingPermission")
    private void attachLocationListener() {

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                1000,
                25,
                this);
    }

    @Override
    public void onLocationChanged(Location location) {
        //make new Latlng and add marker


        LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                .title("Starting Point")
                .draggable(true);

        if(OLD[0]==null) {
            OLD[0] = latLng;
            mMap.addMarker(markerOptions);                ;
        }

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,18.0f));
        mMap.addPolyline(new PolylineOptions().add(OLD[0],latLng));
        OLD[0]=latLng;
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

package appewtc.masterung.enssystem;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final double latCenterDOUBLE = 13.66752591;
    private static final double lngCenterDOUBLE = 100.62174082;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }   // Main Method


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Move to My Center
        LatLng centerLatLng = new LatLng(latCenterDOUBLE, lngCenterDOUBLE);
        mMap.moveCamera(CameraUpdateFactory
                .newLatLngZoom(centerLatLng, 14));


    }   // Second Method
}   // Main Class

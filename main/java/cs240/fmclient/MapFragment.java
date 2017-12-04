package cs240.fmclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import cs240.fmclient.Models.DataHolder;
import cs240.fmclient.Models.Event;
import cs240.fmclient.Models.Person;

public class MapFragment extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    DataHolder dh;
    Event[] eventList;
    Person[] personList;
    TextView eventInfo;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_fragment);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        view =  mapFragment.getView();
        eventInfo = findViewById(R.id.eventInfoDisplay);
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        loadEventsToMap();
        mMap.setOnMarkerClickListener(this);

        // Add a marker in Sydney and move the camera
       // LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
    public void loadEventsToMap() {
        dh = DataHolder.getInstance();
        eventList = dh.getEventList();
        personList = dh.getPersonList();
        for(Event event: eventList) {
            LatLng event1 = new LatLng(event.getLatitude(),event.getLongitude());
            MarkerOptions options = new MarkerOptions()
                    .position(event1)
                    .title(event.getCity());
            if(event.getEventType().equals("birth")) {
                options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
            }
            if(event.getEventType().equals("marriage")) {
                options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

            }
            if(event.getEventType().equals("death")) {
                options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
            }

            Marker marker = mMap.addMarker(options);
            marker.setTag(event.getEventID());
            //mMap.moveCamera(CameraUpdateFactory.newLatLng(event1));
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                //start search activity
                return true;
            case R.id.settings:
                //start settings activity
                return true;
        }
        return true;
    }
    public MapFragment() {}

    @Override
    public boolean onMarkerClick(Marker marker) {
        String eventID = (String) marker.getTag();
        Event currentEvent = null;
        for(Event event: eventList) {
            if(event.getEventID().equals(eventID)) {
                currentEvent = event;
            }
        }
        //display person first and last name
        //display event type, city, country, year
        StringBuilder sb = new StringBuilder();
        sb.append(currentEvent.getEventType());
        sb.append(": ");
        sb.append(currentEvent.getCity());
        sb.append(", ");
        sb.append(currentEvent.getCountry());
        sb.append(" ");
        sb.append(currentEvent.getYear());
        eventInfo.setText(sb.toString());
        return false;
    }
}

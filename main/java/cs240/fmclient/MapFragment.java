package cs240.fmclient;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import cs240.fmclient.Models.DataHolder;
import cs240.fmclient.Models.Event;
import cs240.fmclient.Models.Person;

public class MapFragment extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
//this needs to be a fragment -----------------------------
    private GoogleMap mMap;
    DataHolder dh;
    Event[] eventList;
    Person[] personList;
    TextView eventInfo;
    ImageView image;
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
        image = findViewById(R.id.mapEventDisplayIcon);
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
        eventInfo.setText("Click on any pin");

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
        //match clicked event with event from model class
        String eventID = (String) marker.getTag();
        Event currentEvent = null;
        currentEvent = matchEventID(currentEvent, eventID);

        //retrieve person of event for display
        String gender = "";
        Person currentPerson = null;
        currentPerson = matchPersonID(currentEvent, currentPerson);
        gender = currentPerson.getGender();

        //display gender matched icon
        displayGenderIcon(gender);

        displayEventInfo(currentEvent,currentPerson);
        return true;
    }
    public void displayEventInfo(Event currentEvent, Person currentPerson) {
        //display person first and last name
        //display event type, city, country, year
        StringBuilder sb = new StringBuilder();
        sb.append(currentPerson.getFirstName());
        sb.append(" ");
        sb.append(currentPerson.getLastName());
        sb.append('\n');
        sb.append(currentEvent.getEventType());
        sb.append(": ");
        sb.append(currentEvent.getCity());
        sb.append(", ");
        sb.append(currentEvent.getCountry());
        sb.append(" ");
        sb.append(currentEvent.getYear());
        eventInfo.setText(sb.toString());

        //optional functionality here
        center(currentEvent);

    }
    public void center(Event currentEvent) {
        LatLng latLng = new LatLng(currentEvent.getLatitude(),currentEvent.getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
       // CameraUpdate update = CameraUpdateFactory.zoomTo(3);
       // mMap.moveCamera(update);

    }
    public Event matchEventID(Event currentEvent, String eventID) {
        int count = 0;
        for(Event event: eventList) {
            if(event.getEventID().equals(eventID)) {
                currentEvent = event;
                count++;
                break;
            }
        }
        return currentEvent;
    }
    public Person matchPersonID(Event currentEvent, Person currentPerson){
        int counter = 0;
        for(Person person: personList) {
            if(person.getPersonID().equals(currentEvent.getPersonID())) {
                currentPerson = person;
                counter++;
                break;
            }
            if(person.getFatherID() != null) {
                if (person.getFatherID().equals(currentEvent.getPersonID())) {
                    currentPerson = person;
                    counter++;
                    break;
                }
            }
            if(person.getMotherID() != null) {
                if (person.getMotherID().equals(currentEvent.getPersonID())) {
                    currentPerson = person;
                    counter++;
                    break;
                }
            }
            if(person.getSpouseID() != null) {
                if (person.getSpouseID().equals(currentEvent.getPersonID())) {
                    currentPerson = person;
                    counter++;
                    break;
                }
            }
        }
        return currentPerson;
    }
    public void displayGenderIcon(String gender){
        Iconify.with(new FontAwesomeModule());
        if(gender.equals("f")) {
            Drawable icon = new IconDrawable(this, FontAwesomeIcons.fa_female)
                    .colorRes(R.color.red)
                    .sizeDp(30);
            image.setImageDrawable(icon);
        }
        if(gender.equals("m")) {
            Drawable icon = new IconDrawable(this, FontAwesomeIcons.fa_male)
                    .colorRes(R.color.blue)
                    .sizeDp(30);
            image.setImageDrawable(icon);
        }
    }
}

package cs240.fmclient;


import android.os.AsyncTask;

public class FamilyDataTask extends AsyncTask<String, String, String> {
    protected String familyPersonData;
    protected String familyEventData;
//    public Person[] relatives = null;
//    public Event[] events = null;
    @Override
    protected String doInBackground(String... strings) {
        Proxy proxy = new Proxy();
        //familyPersonData = proxy.findPersons(strings);
        System.out.println(familyPersonData);
        //familyEventData = proxy.findEvents(strings);
        System.out.println(familyEventData);

        return " ";
    }
}

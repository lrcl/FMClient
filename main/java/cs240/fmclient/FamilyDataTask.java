package cs240.fmclient;


import android.os.AsyncTask;

public class FamilyDataTask extends AsyncTask<String, Void, String> {
    String familyData;
    @Override
    protected String doInBackground(String... strings) {
        Proxy proxy = new Proxy();
        familyData = proxy.findPersons(strings);
        System.out.println(familyData);
        return null;
    }
}

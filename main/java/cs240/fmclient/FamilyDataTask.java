package cs240.fmclient;


import android.os.AsyncTask;

public class FamilyDataTask extends AsyncTask<String, Void, String> {
    String familyData;
    @Override
    protected String doInBackground(String... strings) {
        Proxy proxy = new Proxy();
        familyData = proxy.register(strings);
        return null;
    }
    @Override
    protected void onPostExecute(String s) {
        if(familyData == null) {
            //display error message in toast
        }
        else {
            //display family data of registered user
        }
    }
}

package cs240.fmclient;


import android.os.AsyncTask;

public class FamilyDataTask extends AsyncTask<String, Void, String> {
    String familyData;
    @Override
    protected String doInBackground(String... strings) {
        Proxy proxy = new Proxy();
        familyData = proxy.findPersons(strings);
        return null;
    }
    @Override
    protected void onPostExecute(String s) {
        if(familyData == null) {
            System.out.println("family data is null");
            //display error message in toast
        }
        else {
            System.out.println("let's make a toast! :)");
            //display logged in user's first and last names of registered user
        }
    }
}

package cs240.fmclient;

import android.os.AsyncTask;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class LoginTask extends AsyncTask<String, Void, String> {

    String loginResults;
    @Override
    protected String doInBackground(String... strings) {
        Proxy proxy = new Proxy();
        loginResults = proxy.login(strings);
        if(loginResults != null) {
           System.out.println(loginResults);
            // new FamilyDataTask().execute(loginResults);
        }
        return null;
    }

    @Override
    protected void onPostExecute(String loginResults) {
        if(loginResults == null) {
            //display error message in a toast
        }
        else {
            //display login info?
        }
    }
}

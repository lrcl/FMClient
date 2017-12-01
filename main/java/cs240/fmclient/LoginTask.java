package cs240.fmclient;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.util.ArrayList;


public class LoginTask extends AsyncTask<String, String, String> {

    String loginResults;
    Context context;
    String familyPersonData;
    String familyEventData;
    @Override
    protected String doInBackground(String... strings) {
        String firstLast = "";
        Proxy proxy = new Proxy();
        loginResults = proxy.login(strings);
        if(loginResults.equals("null")) {
            return "";
        }
        if(loginResults == null) {
            return "";
        }
        try {
            JSONObject loginJO = new JSONObject(loginResults);
            if(loginJO.has("message")) {
                return "";
            }
        }   catch(Exception e) {
            e.printStackTrace();
            return "";
        }

            //
            StringBuilder sb = new StringBuilder();
            sb.append(strings[4]);
            sb.append(" ");
            sb.append(strings[5]);
            firstLast = sb.toString();
            firstLast = firstLast.toUpperCase();
        return firstLast;
    }

    @Override
    protected void onPostExecute(String firstLast) {
        if(firstLast.equals("")) {
            //display error message in a toast
            String message = "unsuccessful login";
            Toast toast1 = Toast.makeText(context,message, Toast.LENGTH_LONG);
            toast1.show();
        }
        else {
            //display logged in user's first and last name
            String displayString = "Logged in User " + firstLast;
            Toast toast2 = Toast.makeText(context, displayString,Toast.LENGTH_LONG );
            toast2.show();
        }
    }
    public LoginTask(Context context) {
        this.context = context;
    }
}

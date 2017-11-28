package cs240.fmclient;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.util.ArrayList;


public class LoginTask extends AsyncTask<String, String, String> {

    String loginResults;
    Context context;
    @Override
    protected String doInBackground(String... strings) {
        String firstLast = "";
        Proxy proxy = new Proxy();
        loginResults = proxy.login(strings);
        if(loginResults.equals("null")) {
            return "";
        }
        char[] lr = loginResults.toCharArray();
        if(lr[4] != 'm') {
            System.out.println(loginResults);
            //new FamilyDataTask().execute(loginResults);
            StringBuilder sb = new StringBuilder();
            sb.append(strings[4]);
            sb.append(" ");
            sb.append(strings[5]);
            firstLast = sb.toString();
            firstLast = firstLast.toUpperCase();
        }
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

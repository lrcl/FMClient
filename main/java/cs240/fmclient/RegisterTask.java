package cs240.fmclient;


import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class RegisterTask extends AsyncTask<String, String, String> {
    String registerResults;
    Context context;
    String familyPersonData;
    String familyEventData;
    @Override
    protected String doInBackground(String... strings) {
        Proxy proxy = new Proxy();
        String firstLast = "";

        registerResults = proxy.register(strings);
        char[] rr = registerResults.toCharArray();
        if(registerResults.equals("null")) {
            return "";
        }
        if(registerResults == null) {
            return "";
        }
        else if(rr[4] != 'm') {
            System.out.println(registerResults);
           // new FamilyDataTask().execute(registerResults);
            familyPersonData = proxy.findPersons(registerResults);
            familyEventData = proxy.findEvents(registerResults);
            System.out.println(familyPersonData);
            System.out.println(familyEventData);
            try {
                JSONObject jsonPersons = new JSONObject(familyPersonData);
                JSONObject jsonEvents = new JSONObject(familyEventData);
                //convert to Person and Event objects? at the very least, pass back to mainactivity
            } catch (JSONException e) {
                e.printStackTrace();
            }

           //
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
            String message = "unable to register";
            Toast toast1 = Toast.makeText(context,message, Toast.LENGTH_LONG);
            toast1.show();
        }
        else {
            //display logged in user's first and last name
            String displayString = "Registered New User" + " "  + firstLast;
            Toast toast2 = Toast.makeText(context, displayString,Toast.LENGTH_LONG );
            toast2.show();
        }
    }
    public RegisterTask(Context context) {
        this.context = context;
    }
}

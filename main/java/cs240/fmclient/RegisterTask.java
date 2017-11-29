package cs240.fmclient;


import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import cs240.fmclient.Models.Person;

class RegisterTask extends AsyncTask<String, String, String> {
    String registerResults;
    Context context;
    String familyPersonData;
    String familyEventData;
    AllPersonsResponse apr;
    @Override
    protected String doInBackground(String... strings) {
        Proxy proxy = new Proxy();
        String firstLast = "";

        registerResults = proxy.register(strings);
        StringBuilder sb = new StringBuilder(registerResults);
        sb.insert(0,'{');
        registerResults = sb.toString();
        if(registerResults.equals("{\"null\"}")) {
            return "";
        }
        if(registerResults == null) {
            return "";
        }
        try {
            JSONObject registerResultsJO = new JSONObject(registerResults);
            if(registerResultsJO.has("message")) {
                return "";
            }
            familyPersonData = proxy.findPersons(registerResultsJO);
            familyEventData = proxy.findEvents(registerResultsJO);
            System.out.println(familyPersonData);
            System.out.println(familyEventData);
            Gson gson = new Gson();
            apr = gson.fromJson(familyPersonData, AllPersonsResponse.class);
            System.out.println(familyPersonData);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strings[4]);
            sb2.append(" ");
            sb2.append(strings[5]);
            firstLast = sb2.toString();
            firstLast = firstLast.toUpperCase();
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

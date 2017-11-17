package cs240.fmclient;


import com.google.gson.Gson;

import org.json.JSONObject;
import org.json.JSONString;

import java.net.URL;

public class Proxy {
    public String login(String login, String password, String requestMethod, URL url){
        requestMethod = "GET";
        Request loginRequest = new LoginRequest(login, password);
        HttpClient client = new HttpClient();
        Response registerResponse = client.sendRequest(loginRequest,requestMethod,url);
        Gson gson = new Gson();
        String jsonString = gson.toJson(registerResponse);
        return jsonString;
    }
}

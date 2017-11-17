package cs240.fmclient;


import com.google.gson.Gson;

import java.net.URL;

public class Proxy {
    String PROTOCOL_HOST = "http://localhost:8888";
    public String login(String login, String password){
        try{
            String loginUrl = PROTOCOL_HOST + "/user/login";
            URL url = new URL(loginUrl);
            String requestMethod = "GET";
            Request loginRequest = new LoginRequest(login, password);
            HttpClient client = new HttpClient();
            String loginResponse = client.sendRequest(loginRequest,requestMethod,url);
            Gson gson = new Gson();
            String jsonString = gson.toJson(loginResponse);
            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String register(String username, String password, String email, String firstname, String lastname, String gender) {
        try{
            String registerUrl = PROTOCOL_HOST + "/user/register";
            URL url = new URL(registerUrl);
            String requestMethod = "GET";
            HttpClient client = new HttpClient();
            Request registerRequest = new RegisterRequest(username, password, email, firstname, lastname, gender);
            String response = client.sendRequest(registerRequest, requestMethod, url);
            Gson gson = new Gson();
            String jsonString = gson.toJson(response);
            return  jsonString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


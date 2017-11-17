package cs240.fmclient;


import com.google.gson.Gson;

import java.net.URL;

public class Proxy {
    String PROTOCOL_HOST = "http://localhost:";
    public String login(String[] strings){
        try{
            String userName = strings[0];
            String password = strings[1];
            String port = strings[2];
            String loginUrl = PROTOCOL_HOST + port + "/user/login";
            URL url = new URL(loginUrl);
            String requestMethod = "GET";
            Request loginRequest = new LoginRequest(userName, password);
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
    public String register(String[] registerInfo) {
        try{
            String userName = registerInfo[0];
            String password = registerInfo[1];
            String email = registerInfo[2];
            String firstName = registerInfo[3];
            String lastName = registerInfo[4];
            String gender = registerInfo[5];
            //String username, String password, String email, String firstname, String lastname, String gender
            String registerUrl = PROTOCOL_HOST + "/user/register";
            URL url = new URL(registerUrl);
            String requestMethod = "GET";
            HttpClient client = new HttpClient();
            Request registerRequest = new RegisterRequest(userName, password, email, firstName, lastName, gender);
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


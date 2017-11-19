package cs240.fmclient;


import com.google.gson.Gson;

import java.net.URL;

public class Proxy {
    String PROTOCOL = "http://";
    public String login(String[] strings){
        try{
            String host = strings[0];
            String port = strings[1];
            String userName = strings[2];
            String password = strings[3];
          //  String loginUrl = PROTOCOL + host + ":" + port + "/user/login";
            URL url = new URL("http://10.0.2.2:8888/user/login");
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
            String host = registerInfo[0];
            String port = registerInfo[1];
            String userName = registerInfo[2];
            String password = registerInfo[3];
            String firstName = registerInfo[4];
            String lastName = registerInfo[5];
            String email = registerInfo[6];
            String gender = registerInfo[7];
            //String username, String password, String email, String firstname, String lastname, String gender
            String registerUrl = PROTOCOL + host + ":" + port + "/user/register";
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


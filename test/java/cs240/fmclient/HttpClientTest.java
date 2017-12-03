package cs240.fmclient;

import org.junit.Test;

import java.net.URL;

import cs240.fmclient.JsonHandling.LoginRequest;
import cs240.fmclient.JsonHandling.Request;
import cs240.fmclient.ServerConnection.HttpClient;

public class HttpClientTest {
    @Test
    public void sendRequest() throws Exception {
        HttpClient client = new HttpClient();
        URL url = new URL("http://localhost:8888/user/login/");
        Request request = new LoginRequest("username","password");
        //String response = client.sendRequest(request, "GET", url);
        //System.out.println(response);
    }

}
package cs240.fmclient;

import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.*;

public class HttpClientTest {
    @Test
    public void sendRequest() throws Exception {
        HttpClient client = new HttpClient();
        URL url = new URL("http://localhost:8888/user/login/");
        Request request = new LoginRequest("username","password");
        String response = client.sendRequest(request, "GET", url);
        System.out.println(response);
    }

}
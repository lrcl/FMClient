package cs240.fmclient;


import android.util.Log;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.google.gson.*;

public class HttpClient{
    //sendGetRequest--sendPostRequest
    //sendDeleteRequest
    public void sendRequest(String request/*needs to be object*/, String requestMethod,URL url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            //Scanner in = new Scanner(connection.getInputStream());
            Writer out = new OutputStreamWriter(connection.getOutputStream());
            Gson gson = new Gson();
            String jsonStr = gson.toJson(request);
            out.write(jsonStr); //is this right?
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //public URL
}

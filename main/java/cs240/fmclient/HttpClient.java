package cs240.fmclient;



import java.io.BufferedWriter;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.*;

public class HttpClient{
    //sendGetRequest--sendPostRequest
    //sendDeleteRequest
    public Response sendRequest(Request request, String requestMethod,URL url) {
        try {
            //set URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod(requestMethod);
            connection.connect(); //don't necessarily need this line
            //include JSON in body of request
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            Gson gson = new Gson();
            String jsonStr = gson.toJson(request);
            out.write(jsonStr);
            //send request body
            out.flush();
            out.close();
            //read response from server
            Scanner in = new Scanner(connection.getInputStream());
            StringBuilder sb = new StringBuilder();
            while(in.hasNext()) {
                sb.append(in.next());
            }
            String responseString = sb.toString();
            Response response = new Response(responseString);
            return response;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

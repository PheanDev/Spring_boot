package com.Phean.Tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.springframework.http.HttpHeaders.USER_AGENT;

public class HttpConnection {
    private String sendGET(String stringURL) throws IOException, CustomException {
        try {
            URL obj = new URL(stringURL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return response.toString();
            } else {
                throw new CustomException("Http get error");
            }
        }catch (Exception exception)
        {
            throw new CustomException(exception);
        }

    }

    private String sendPOST(String stringURL,String stringJSONParam) throws IOException, CustomException {
        try {
            URL obj = new URL(stringURL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(stringJSONParam.getBytes());
            os.flush();
            os.close();

            int responseCode = con.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                throw new CustomException("Error on request");
            }
        }catch (Exception exception)
        {
            throw new CustomException(exception);
        }
    }

    //Implement PUT and Delete here ....

}

package classes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import sun.rmi.runtime.Log;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Valera on 11.01.2018.
 */
public class HttpURLConnectionExample {

    private final static String USER_AGENT = "Mozilla/5.0";
    private final static String URL_PRIVATE = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=";


    public static void main(String[] args) throws Exception {

        String url = null;
        HttpURLConnectionExample http = new HttpURLConnectionExample();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter an type:");
        System.out.println("1.Cash course");
        System.out.println("2.Non-cash exchange rate");
        int type = keyboard.nextInt();
        if(type == 1)
            http.sendGet(URL_PRIVATE + "11");
        else if(type == 2)
            http.sendGet(URL_PRIVATE + "5");
        else
            System.out.println("incorrect type!");
    }

    // HTTP GET request
    private void sendGet(String url) throws Exception {
//        String url = "https://jsonplaceholder.typicode.com/posts/1";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        ObjectMapper objectMapper = new ObjectMapper();
        String result = this.readInputStreamToString(con);
        List<Private> listPrivate = objectMapper.readValue(result, new TypeReference<List<Private>>(){});
        System.out.println(listPrivate);


    }

    private String readInputStreamToString(HttpURLConnection connection) {
        String result = null;
        StringBuffer sb = new StringBuffer();
        InputStream is = null;

        try {
            is = new BufferedInputStream(connection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            result = sb.toString();
        }
        catch (Exception e) {
            System.out.println("same problems");
            result = null;
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                }
                catch (IOException e) {
                    System.out.println("Error closing InputStream");
//                    Log.i(TAG, "Error closing InputStream");
                }
            }
        }
        return result;
    }

    // HTTP POST request
    private void sendPost() throws Exception {

        String url = "https://selfsolve.apple.com/wcResults.do";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

}
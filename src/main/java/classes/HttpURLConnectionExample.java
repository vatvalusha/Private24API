package classes;

import classes.MongoDAO.MongoInformation;
import classes.dao.MongoDBConnection;
import classes.entity.User;
import classes.servlet.Commands.ConfigurationManager;
import classes.servlet.logiHandle.UserLogic;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.ietf.jgss.Oid;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valera on 11.01.2018.
 */
public class HttpURLConnectionExample {

    private final static String USER_AGENT = "Mozilla/5.0";
    private final static String URL_PRIVATE = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=";


    public static void main(String[] args) throws Exception {

//        User user = new User();
//        user.setAge(40);
//        user.setName("Vovan");
//        user.setPassword("security");
//        User.Oid ll = user.new Oid();
//        ll.set$oid("5a5f2c50e2f90c3dcc538c54");
//        user.set_id(ll);
//
//        MongoInformation mongoInformation = new MongoInformation();
//        System.out.println(mongoInformation.getAllUsers());
//        mongoInformation.updateUser(user);
//        System.out.println(mongoInformation.getAllUsers());
//
//

        String ss =ConfigurationManager.getProperty("message.loginerror");
        System.out.println(ss);


//        System.out.println(user + user.get_id().get$oid());
//        System.out.println(mongoInformation.insertUser(user));
//        System.out.println(mongoInformation.getAllUsers());

//        int size = mongoInformation.getAllUsers().size();
//        mongoInformation.deleteUser(mongoInformation.getAllUsers().get(size-1).get_id().get$oid());
//        mongoInformation.deleteUser(mongoInformation.getAllUsers().get(size-2).get_id().get$oid());
//        System.out.println(mongoInformation.getAllUsers().get(size-1));


//        String url = null;
//        HttpURLConnectionExample http = new HttpURLConnectionExample();
//
//        Scanner keyboard = new Scanner(System.in);
//        System.out.println("Enter an type:");
//        System.out.println("1.Cash course");
//        System.out.println("2.Non-cash exchange rate");
//        int type = keyboard.nextInt();
//        if(type == 1)
//            http.sendGet( "11");
//        else if(type == 2)
//            http.sendGet(  "5");
//        else
//            System.out.println("incorrect type!");
    }

    // HTTP GET request
    public List<Private> sendGet(String type) throws Exception {

        URL obj = new URL(URL_PRIVATE + type);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        ObjectMapper objectMapper = new ObjectMapper();
        String result = this.readInputStreamToString(con);
        System.out.println(result);
        List<Private> listPrivate = objectMapper.readValue(result, new TypeReference<List<Private>>() {
        });
        return listPrivate;
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
        } catch (Exception e) {
            System.out.println("same problems");
            result = null;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
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

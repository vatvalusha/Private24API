package classes.servlet.logiHandle;

import classes.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCursor;
import com.mongodb.util.JSON;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valera on 16.01.2018.
 */
public class UserLogic {

    /**
     * Convert input json to List type User
     *
     * @param json
     * @return
     */
    public static List<User> allUsers(String json) {
        Gson gson = new Gson();
        List<User> list = null;
        list = gson.fromJson(json, new TypeToken<List<User>>() {
        }.getType());
        return list;
    }

    /**
     * convert input MongoCursor object to User Object
     *
     * @param cursor
     * @return
     */
    public static User convertDocToUser(MongoCursor<Document> cursor) {
        User user = null;
        Gson gson = new Gson();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            user = gson.fromJson(JSON.serialize(document), new TypeToken<User>() {
            }.getType());
        }
        return user;
    }

    /**
     * convert List type Object to Object type String
     *
     * @param objects
     * @return
     */
    public static String convertObjectToJSON(Object objects) {
        Gson gson = new Gson();
        String json = gson.toJson(objects);
        return json;
    }

    /**
     * convert object type String to Document object
     *
     * @param json
     * @return
     */
    public static Document convertJsonToDoc(String json) {
        Document doc = Document.parse(json.toString());
        return doc;
    }
}

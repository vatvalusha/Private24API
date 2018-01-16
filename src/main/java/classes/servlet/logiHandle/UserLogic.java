package classes.servlet.logiHandle;

import classes.entity.User;
import com.google.gson.Gson;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valera on 16.01.2018.
 */
public class UserLogic {

    public static List<User> allUsers(List<DBObject> objects){
        Gson gson=new Gson();
        List<User> users = new ArrayList<>();
        for(DBObject object : objects) {
//                DBObject obj = cursor.next();
                //Reversal
                User u = gson.fromJson(object.toString(), User.class);
                users.add(u);
                System.out.println(u.getName());
        }
        return users;
    }
}

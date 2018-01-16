package classes.MongoDAO;

import classes.dao.MongoDBConnection;
import classes.entity.User;
import classes.interfaceDAO.InformationDAO;
import classes.servlet.logiHandle.UserLogic;
import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valera on 16.01.2018.
 */
public class MongoInformation implements InformationDAO {

    MongoDBConnection connection;


    public MongoInformation() {
        System.out.println("CONNECTION");
        connection = MongoDBConnection.getInstance();

    }

    @Override
    public List<User> getAllUsers() {
        DB database = connection.getCollection();
        DBCollection dbCollection = database.getCollection("information");
        DBCursor cursor = dbCollection.find();
        List<DBObject> allRecords = new ArrayList<DBObject>();
        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            allRecords.add(obj);
        }
        int count = 1;
        for (DBObject object : allRecords) {
            System.out.println("count №" + count + ": " + object);
        }
        List<User> users = UserLogic.allUsers(allRecords);
        return users;
    }

    @Override
    public User getUser(String name) {
        return null;
    }

    @Override
    public User deleteUser(String id) {
        Gson gson = new Gson();
        User user = new User();
        DB database = connection.getCollection();
        DBCollection dbCollection = database.getCollection("information");
//        DBCursor cursor = dbCollection.find(new BasicDBObject("age", new BasicDBObject("$gt", 10)));
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("name", id);
        DBCursor cursor = dbCollection.find(whereQuery);
        System.out.println(cursor);
        if (cursor.hasNext()) {
            DBObject object = cursor.next();
            user = gson.fromJson(object.toString(), User.class);
//            System.out.println("FOUND!" + cursor.next());
        }
//        while (cursor.hasNext()) {
//            System.out.println(cursor.next());
//        }
        return user;
    }


    //testing
    @Override
    public User insertUser(User newUser) {
        DB database = connection.getCollection();
        DBCollection dbCollection = database.getCollection("information");
        Gson gson = new Gson();
        DBObject dbObject = (DBObject) JSON.parse(gson.toJson(newUser));
        dbCollection.insert(dbObject);
        DBCursor cursor = dbCollection.find();
        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            User u = gson.fromJson(obj.toString(), User.class);
            System.out.println(u.getName());
        }
        return null;
    }

    /**
     * The ordinary objects into the database
     *
     * @param obj
     * @return
     */

    public WriteResult insert(Object obj) {
        Gson gson = new Gson();
        DBObject dbObject = (DBObject) JSON.parse(gson.toJson(obj));
        gson = null;
        return insert(dbObject);
    }
}

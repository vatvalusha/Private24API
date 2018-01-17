package classes.MongoDAO;

import classes.dao.MongoDBConnection;
import classes.entity.User;
import classes.interfaceDAO.InformationDAO;
import classes.servlet.logiHandle.UserLogic;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valera on 16.01.2018.
 */
public class MongoInformation implements InformationDAO {

    MongoDBConnection connection;


    public MongoInformation() {
        connection = MongoDBConnection.getInstance();
        System.out.println("CONNECTED SUCCESSFUL");

    }

    @Override
    public List<User> getAllUsers() {
        MongoDatabase database = connection.getCollection();
        MongoCollection<Document> dbCollection = database.getCollection("information");
        MongoCursor<Document> cursor = dbCollection.find().iterator();
        List<Document> allRecords = new ArrayList<Document>();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            allRecords.add(doc);
        }
//        int count = 1;
//        for (Document object : allRecords) {
//            System.out.println("count №" + count + ": " + object);
//        }
        List<User> list = UserLogic.allUsers(JSON.serialize(allRecords));
//        list.forEach(x -> System.out.println(x.get_id().get$oid()));
        return list;
    }

    @Override
    public User getUser(String name) {
        return null;
    }

    @Override
    public void deleteUser(String id) {
        Gson gson = new Gson();
        User user = new User();
        MongoDatabase database = connection.getCollection();
        MongoCollection<Document> dbCollection = database.getCollection("information");
        dbCollection.deleteOne(new Document("_id", new ObjectId(id)));
    }


    @Override
    public User insertUser(User newUser) {
        User user = null;
        Gson gson = new Gson();
        MongoDatabase database = connection.getCollection();
        MongoCollection<Document> dbCollection = database.getCollection("information");
        Document doc = Document.parse(gson.toJson(newUser));
        dbCollection.insertOne(doc);
        MongoCursor<Document> cursor = dbCollection.find().iterator();
        return UserLogic.convertDocToUser(cursor);
    }

    @Override
    public void updateUser(User newUser) {
        MongoDatabase database = connection.getCollection();
        MongoCollection<Document> dbCollection = database.getCollection("information");
        String json = UserLogic.convertObjectToJSON(newUser);
        Document doc = UserLogic.convertJsonToDoc(json);
        Bson filter = new Document("_id", new ObjectId(newUser.get_id().get$oid()));
        Bson newValue = doc;
        Bson updateOperationDocument = new Document("$set", newValue);
        dbCollection.updateOne(filter, updateOperationDocument);
//        System.out.println(doc);
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

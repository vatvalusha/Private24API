package classes;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.net.UnknownHostException;

/**
 * Created by Valera on 15.01.2018.
 */
public class MongoDBConnection {
    private static MongoDBConnection ourInstance = new MongoDBConnection();

    public static MongoDBConnection getInstance() {
        return ourInstance;
    }

    private MongoDBConnection() {

    }

    public DBCollection getCollection() {
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB database = mongoClient.getDB("users");
            DBCollection collection = database.getCollection("information");
            return collection;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
}

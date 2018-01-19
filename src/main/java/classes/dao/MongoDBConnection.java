package classes.dao;

import classes.MongoDAO.MongoInformation;
import classes.interfaceDAO.InformationDAO;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import java.net.UnknownHostException;

/**
 * Created by Valera on 15.01.2018.
 */
public class MongoDBConnection extends DAOFactory {
    private static final String MONGO_URL = "mongodb://localhost:27017";
    static final String DD_NAME = "users";

    private static MongoDBConnection ourInstance = new MongoDBConnection();

    public static MongoDBConnection getInstance() {
        return ourInstance;
    }

    private MongoDBConnection() {
    }

    public MongoDatabase getCollection() {
        MongoClient mongoClient = null;
        mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase(DD_NAME);
//            DBCollection collection = database.getCollection("information");
        return database;
    }

    @Override
    public InformationDAO getInformationDao() {
        return new MongoInformation();
    }
}

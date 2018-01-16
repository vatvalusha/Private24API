package classes.dao;

import classes.MongoDAO.MongoInformation;
import classes.interfaceDAO.InformationDAO;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

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

    private MongoDBConnection() {}

    public DB getCollection() {
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(new MongoClientURI(MONGO_URL));
            DB database = mongoClient.getDB(DD_NAME);
//            DBCollection collection = database.getCollection("information");
            return database;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public InformationDAO getInformationDao() {
        return new MongoInformation();
    }
}

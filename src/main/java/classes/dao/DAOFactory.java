package classes.dao;

import classes.interfaceDAO.InformationDAO;

/**
 * Created by Valera on 16.01.2018.
 */
public abstract class DAOFactory {
    public enum ConnTypes {
        MongoDBConnection
//        ConnPoolMySql
    }

    public static DAOFactory getDaoFactory(ConnTypes connType) {
        switch (connType) {
            case MongoDBConnection:
                return MongoDBConnection.getInstance();
//            case ConnPoolMySql:
//                return new ConnPoolMySqlDaoFactory();
            default:
                return null;
        }
    }

    public abstract InformationDAO getInformationDao();

}

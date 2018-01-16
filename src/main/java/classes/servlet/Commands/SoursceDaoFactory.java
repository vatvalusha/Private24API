package classes.servlet.Commands;

import classes.dao.DAOFactory;

/**
 * Created by Valera on 16.01.2018.
 */
public class SoursceDaoFactory {
    public static DAOFactory getDAOFactory() {
        return DAOFactory.getDaoFactory(DAOFactory.ConnTypes.MongoDBConnection);
    }
}

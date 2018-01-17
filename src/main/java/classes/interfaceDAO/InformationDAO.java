package classes.interfaceDAO;

import classes.entity.User;
import com.mongodb.DBObject;

import java.util.List;

/**
 * Created by Valera on 16.01.2018.
 */
public interface InformationDAO {

    List<User> getAllUsers();

    User getUser(String name);

    void deleteUser(String Id);

    User insertUser(User newUser);

    void updateUser(User newUser);

}

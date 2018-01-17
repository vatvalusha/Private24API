package classes.servlet.Commands;

import classes.dao.DAOFactory;
import classes.entity.User;
import com.mongodb.DBObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Valera on 16.01.2018.
 */
public class Users implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("inside Users Servlet");
        //get Mongo DB users
        DAOFactory daoFactory = SoursceDaoFactory.getDAOFactory();
        List<User> allUsers = daoFactory.getInformationDao().getAllUsers();
        System.out.println("allUsers: " + allUsers);
        HttpSession session = request.getSession(true);

        if (allUsers.isEmpty() || allUsers == null) {
            request.setAttribute("error", "error with mongo connection");
            return "/jsp/error/error.jsp";
        }
//        for (User user : allUsers) {
//            System.out.println("# " + user.getName());
//            System.out.println("# " + user.get_id().get$oid());
//        }
        request.setAttribute("users", allUsers);
//        request.setAttribute("users", allUsers);
        return "/jsp/users.jsp";
    }
}

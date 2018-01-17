package classes.servlet.Commands;

import classes.dao.DAOFactory;
import classes.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Valera on 17.01.2018.
 */
public class DeleteUser implements ActionCommand {

    private static final String ID_USER = "ids";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(ID_USER);
        if (login.equals(null) || login.equals("")) {
            request.setAttribute("error", "Id is empty");
            return "/jsp/error/error.jsp";

        }
        DAOFactory daoFactory = SoursceDaoFactory.getDAOFactory();
        daoFactory.getInformationDao().deleteUser(login);
        List<User> allUsers = daoFactory.getInformationDao().getAllUsers();
        if (allUsers.isEmpty() || allUsers == null) {
            request.setAttribute("error", "error with mongo connection");
            return "/jsp/error/error.jsp";
        }
        System.out.println("allUsers: " + allUsers);
        request.setAttribute("users", allUsers);
        return "/jsp/users.jsp";
    }
}

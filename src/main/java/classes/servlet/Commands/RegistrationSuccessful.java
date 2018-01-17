package classes.servlet.Commands;

import classes.MongoDAO.MongoInformation;
import classes.dao.DAOFactory;
import classes.entity.User;
import classes.servlet.logiHandle.LoginLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Valera on 17.01.2018.
 */
public class RegistrationSuccessful implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "email";
    private static final String PARAM_NAME_PASSWORD = "psw";
    private static final String PARAM_NAME_RAW_REPEAT = "psw-repeat";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        String re_pass = request.getParameter(PARAM_NAME_RAW_REPEAT);
        System.out.println(pass.equals(re_pass));
        HttpSession session = request.getSession(true);
        if (pass.equals(re_pass)) {
            User user = new User(login, pass);
            DAOFactory daoFactory = SoursceDaoFactory.getDAOFactory();
            daoFactory.getInformationDao().insertUser(user);
            System.out.println("#######INSERTED");

            session.setAttribute("user", login);
//            page = ConfigurationManager.getProperty("path.page.main");
            page = "/jsp/registSuccess.jsp";
        } else {
//            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
            session.setAttribute("errorLoginPassMessage", "password does not match ");
//            page = ConfigurationManager.getProperty("path.page.login");
            page = "/jsp/login.jsp";
        }
        return page;
    }
}

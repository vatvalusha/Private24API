package classes.servlet.Commands;

import classes.servlet.logiHandle.LoginLogic;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valera on 15.01.2018.
 */
public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        if (LoginLogic.checkLogin(login, pass)) {
            request.getSession().setAttribute("user", login);

//            page = ConfigurationManager.getProperty("path.page.main");
            page = "/jsp/main.jsp";
        } else {
//            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
            request.setAttribute("errorLoginPassMessage", "Incorrect login or password.");
//            page = ConfigurationManager.getProperty("path.page.login");
            page = "/jsp/login.jsp";
        }
        return page;
    }
}

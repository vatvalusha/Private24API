package classes.servlet.Commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Valera on 15.01.2018.
 */
public class LoginCommand  implements Command{
    private static final String LOGIN = "Admin";
    private static final String PASWORD = "qwerty";
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        if(checkLogin(login,password)){
            request.setAttribute("user",login);
            page = "main";
        }else{
            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
            page = "login";
        }
        return page;
    }

    public static boolean checkLogin(String enterLogin, String enterPass){
        return LOGIN.equals("Admin") && PASWORD.equals("qwerty");
    }
}

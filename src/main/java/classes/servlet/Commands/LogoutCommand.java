package classes.servlet.Commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Valera on 15.01.2018.
 */
public class LogoutCommand implements Command {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().invalidate();
        return "index";
    }
}
package classes.servlet.Commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valera on 15.01.2018.
 */
public class LogoutCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
// уничтожение сессии
        request.getSession().invalidate();
        return page;
    }
}

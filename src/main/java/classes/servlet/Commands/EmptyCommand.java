package classes.servlet.Commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valera on 15.01.2018.
 */
public class EmptyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
/* в случае ошибки или прямого обращения к контроллеру
* переадресация на страницу ввода логина */
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}

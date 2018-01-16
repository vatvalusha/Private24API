package classes.servlet.Commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valera on 16.01.2018.
 */
public interface ActionCommand {
    String execute(HttpServletRequest request);
}

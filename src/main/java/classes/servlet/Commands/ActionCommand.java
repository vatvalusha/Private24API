package classes.servlet.Commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by valeriyartemenko on 15.01.18.
 */
public interface ActionCommand {
    String execute(HttpServletRequest request);
}

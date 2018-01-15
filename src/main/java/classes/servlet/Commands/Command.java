package classes.servlet.Commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Valera on 15.01.2018.
 */
public interface Command {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
    public String execute(HttpServletRequest requeste) throws Exception;
}

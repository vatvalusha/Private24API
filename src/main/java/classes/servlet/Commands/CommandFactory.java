package classes.servlet.Commands;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valera on 15.01.2018.
 */
public class CommandFactory {
    private static final Map<String, Command> comands;

    static {
        comands = new HashMap<>();
        comands.put("/routes", new LoginCommand());
        comands.put("/route_detailes",new LogoutCommand());
    }

    public static Command getCommand(HttpServletRequest request) {
        return comands.get(request.getPathInfo());
    }

}

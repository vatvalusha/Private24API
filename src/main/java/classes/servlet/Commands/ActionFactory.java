package classes.servlet.Commands;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valera on 16.01.2018.
 */
public class ActionFactory {


//    private static final Map<String, ActionFactory> comands;
//
//    static {
//        comands = new HashMap<>();
//        comands.put("/login", new LoginCommand());
//        comands.put("/logout", new LogoutCommand());
//    }
//
//    public static ActionCommand getCommand(HttpServletRequest request) {
//        return (ActionCommand) comands.get(request.getPathInfo());
//    }

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
// извлечение имени команды из запроса
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            System.out.println("EMPTY");
            return current;
        }
        try {
            System.out.println("NOT EMPTY");
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
//            request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
            request.setAttribute("wrongAction", action + ": command not found or wrong!");
        }
        return current;
    }
}

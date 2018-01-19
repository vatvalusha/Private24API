package classes.servlet.Commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Valera on 19.01.2018.
 */
public class UpdateUsers implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("HELLO FROM Update");
        return null;
    }
}

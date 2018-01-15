package classes.servlet.Commands;

import java.util.ResourceBundle;

/**
 * Created by Valera on 15.01.2018.
 */
public class MessageManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.messages");

    private MessageManager() {
    }

    public static String getProperty(String key){
        return resourceBundle.getString(key);
    }

}

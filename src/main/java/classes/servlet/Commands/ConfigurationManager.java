package classes.servlet.Commands;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Valera on 15.01.2018.
 */
public class ConfigurationManager {
    static Locale en_US = new Locale("en", "US");
    Locale defaultLocale = Locale.getDefault();
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    private ConfigurationManager(){}

    public static String getProperty(String key){
        return resourceBundle.getString(key);
    }
}

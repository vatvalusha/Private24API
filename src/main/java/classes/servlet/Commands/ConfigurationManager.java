package classes.servlet.Commands;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Valera on 15.01.2018.
 */
public class ConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("C:\\Users\\new\\IdeaProjects\\Private Bank\\src\\main\\resources\\config_en", Locale.ENGLISH);

    // класс извлекает информацию из файла config.properties
    private ConfigurationManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}

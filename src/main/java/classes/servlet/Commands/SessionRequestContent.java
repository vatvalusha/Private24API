package classes.servlet.Commands;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by Valera on 15.01.2018.
 */
public class SessionRequestContent {
    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;

    // конструкторы
// метод извлечения информации из запроса
    public void extractValues(HttpServletRequest request) {
// реализация
    }

    // метод добавления в запрос данных для передачи в jsp
    public void insertAttributes(HttpServletRequest request) {
// реализация
    }
// some methods
}

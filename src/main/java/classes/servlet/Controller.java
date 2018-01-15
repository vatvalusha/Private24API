package classes.servlet;

import classes.servlet.Commands.Command;
import classes.servlet.Commands.CommandFactory;
import classes.servlet.Commands.ConfigurationManager;
import classes.servlet.Commands.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Valera on 15.01.2018.
 */
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
// определение команды, пришедшей из JSP

        Command command = CommandFactory.getCommand(request);
/*
* вызов реализованного метода execute() и передача параметров
* классу-обработчику конкретной команды
 */
        try {
            page = command.execute(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
// метод возвращает страницу ответа
// page = null; // поэксперементировать!
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
// вызов страницы ответа на запрос
            dispatcher.forward(request, response);
        } else {
// установка страницы c cообщением об ошибке
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }

//    private void dispatch(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException {
//        String prefix = "/view/";
//        String suffix = ".jsp";
//        RequestDispatcher dispatcher = request.getRequestDispatcher(prefix + view + suffix);
//        dispatcher.forward(request, response);
//    }

}

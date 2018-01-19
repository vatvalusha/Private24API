package classes.servlet;

import classes.servlet.Commands.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Valera on 15.01.2018.
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        System.out.println("COMMAND CONTROLLER: " + command);

        page = command.execute(request);

        if (page != null) {
            System.out.println("###PAGE: " + page);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {

//            page = "/index.jsp";
            page =  ConfigurationManager.getProperty("path.page.index");
//            request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
            request.getSession().setAttribute("nullPage", "Page not found. Business logic error.");
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}

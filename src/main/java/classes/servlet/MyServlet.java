package classes.servlet;

import classes.HttpURLConnectionExample;
import classes.Private;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Valera on 12.01.2018.
 * Servlet implementation class MyServlet
 */

@SuppressWarnings("serial")

public class MyServlet extends HttpServlet {

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getParameter("username");
        username = username.toUpperCase();
        response.getWriter().println("<!DOCTYPE HTML>");
        response.getWriter().println("<html><body><p>" + username + "</p></body></html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpURLConnectionExample http = new HttpURLConnectionExample();

        try {
            String firstType = request.getParameter("firstType");
            String secondType = request.getParameter("secondType");
            List<Private> CollectionName = null;
            if (!(firstType == null)) {
                CollectionName = http.sendGet(firstType);
            } else {
                CollectionName = http.sendGet(secondType);
            }
            request.setAttribute("collectionName", CollectionName);
            request.getRequestDispatcher("result.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        doGet(request, response);
    }
}



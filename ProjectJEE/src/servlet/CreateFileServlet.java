package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import beans.File;
import utils.DBUtils;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/createFile" })
public class CreateFileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public CreateFileServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createFileView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String idStr = (String) request.getParameter("id");
        String name = (String) request.getParameter("name");
        String composer = (String) request.getParameter("composer");
        String type = (String) request.getParameter("type");
        String priceStr = (String) request.getParameter("price");
        int id = Integer.parseInt(idStr);
        float price = Float.parseFloat(priceStr);
        File file = new File(id, name, composer, type, price);
        String errorString = null;
 
        if (errorString == null) {
            try {
                DBUtils.insertFile(conn, file);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
        request.setAttribute("file", file);
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createFileView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/filesList");
        }
    }
 
}

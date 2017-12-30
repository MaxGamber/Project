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

import utils.DBUtils;
import utils.MyUtils;
 
@WebServlet(urlPatterns = { "/deleteFile" })
public class DeleteFileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public DeleteFileServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        
        String idStr = (String) request.getParameter("id");
        int id = Integer.parseInt(idStr);
 
        String errorString = null;
 
        try {
            DBUtils.deleteFile(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } 
         
        if (errorString != null) {
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/deleteFileErrorView.jsp");
            dispatcher.forward(request, response);
        }        
        else {
            response.sendRedirect(request.getContextPath() + "/filesList");
        }
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
 
}

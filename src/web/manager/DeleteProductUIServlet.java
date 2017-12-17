package web.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.exception.DaoException;
import service.BusinessServices;

/**
 * Servlet implementation class DeleteProductUIServlet
 */
public class DeleteProductUIServlet extends HttpServlet
{

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        BusinessServices bs = new BusinessServices();
        try {
            bs.deleteProductById(id);
        } catch (DaoException exception) {
            // TODO Auto-generated catch block
            response.getWriter().write(" An Order refers to it,you could not delete it");
            return;
        }
        response.getWriter().write("delete it successfully");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

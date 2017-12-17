package web.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Category;
import service.BusinessServices;

/**
 * Servlet implementation class UpdateCategoryUIServlet
 */
public class UpdateCategoryUIServlet extends HttpServlet
{
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        BusinessServices businessServices = new BusinessServices();
        String category_id = request.getParameter("id");
        Category category = businessServices.findCategoryById(category_id);
        request.setAttribute("findcategory", category);
        request.getRequestDispatcher("/manager/updatecategory.jsp").forward(request, response);
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

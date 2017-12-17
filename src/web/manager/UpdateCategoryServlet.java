package web.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Category;
import service.BusinessServices;

public class UpdateCategoryServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String id = request.getParameter("id");
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setDescription(description);

        BusinessServices service = new BusinessServices();
        service.updateCategory(category);

        response.getWriter().write("UpdateSuccessfully");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

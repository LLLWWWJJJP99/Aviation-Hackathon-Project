package web.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Page;
import service.BusinessServices;

public class WelcomeServlet extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String pageNum = request.getParameter("pageNum");
        String category_id = request.getParameter("category_id");

        if (category_id == null || category_id.trim().equals("")) {
            BusinessServices service = new BusinessServices();
            List categorys = service.getALlCategory();
            Page page = service.getProductByPage(pageNum);

            request.setAttribute("categorys", categorys);
            request.setAttribute("page", page);
        } else {
            BusinessServices service = new BusinessServices();
            List categorys = service.getALlCategory();
            Page page = service.getProductByPage(category_id, pageNum);
            request.setAttribute("categorys", categorys);
            request.setAttribute("current_category_id", category_id);
            request.setAttribute("page", page);
        }
        request.getRequestDispatcher("/client/welcome.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}

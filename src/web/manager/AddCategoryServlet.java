package web.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Category;
import service.BusinessServices;
import util.Utils;

public class AddCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		Category category = new Category();
		category.setId(Utils.makeId());
		category.setName(name);
		category.setDescription(description);
		
		BusinessServices service = new BusinessServices();
		service.addCategory(category);
		
		response.getWriter().write("AddSuccessfully");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

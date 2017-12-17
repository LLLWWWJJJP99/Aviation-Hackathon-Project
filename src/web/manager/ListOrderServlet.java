package web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BusinessServices;

public class ListOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean state = Boolean.parseBoolean(request.getParameter("state"));
		
		BusinessServices service = new BusinessServices();
		List orders = service.getAllOrder(state);
		request.setAttribute("orders", orders);
		
		request.getRequestDispatcher("/manager/listorder.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

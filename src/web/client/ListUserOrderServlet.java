package web.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.BusinessServices;

public class ListUserOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			response.getWriter().write("PleaseLoginAtFirst");
			return;
		}
		
		BusinessServices service = new BusinessServices();
		List orders = service.findUserOrder(user);
		
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/client/listorder.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

package web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Cart;
import domain.User;
import service.BusinessServices;

public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user==null){
			response.getWriter().write("PleaseLoginAtFirst");
			return;
		}
		
		BusinessServices service = new BusinessServices();
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		service.addOrder(cart, user);
		
		response.getWriter().write("YourOrderIsCreated,WaitForProductToBeSent");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

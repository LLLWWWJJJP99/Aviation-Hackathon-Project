package web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Seller;
import domain.User;
import service.BusinessServices;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		BusinessServices service = new BusinessServices();
		if(usertype.equals("seller")) {
			Seller seller = service.findSeller(name, password);
			if(seller!=null){
				request.getSession().setAttribute("user", seller);
			}else{
				request.setAttribute("message", "<script>alert('UsernameOrPasswordIsNotCorrect')</script>");
			}
			request.getRequestDispatcher("/head.jsp").forward(request, response);
		}else {
			User user = service.findUser(name, password);
			if(user!=null){
				request.getSession().setAttribute("user", user);
			}else{
				request.setAttribute("message", "<script>alert('UsernameOrPasswordIsNotCorrect')</script>");
			}
			request.getRequestDispatcher("/head.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

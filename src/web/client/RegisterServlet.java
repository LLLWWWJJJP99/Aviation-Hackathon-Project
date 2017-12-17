package web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.BusinessServices;
import util.Utils;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String cellphone = request.getParameter("cellphone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setAddress(address);
		user.setCellphone(cellphone);
		user.setEmail(email);
		user.setId(Utils.makeId());
		user.setName(name);
		user.setPassword(password);
		user.setPhone(phone);
		
		BusinessServices service = new BusinessServices();
		service.addUser(user);
		
		response.getWriter().write("RegisterSuccessfully");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

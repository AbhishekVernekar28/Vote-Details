package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserDto;

@WebServlet("/userlogin")
public class UserLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int username =Integer.parseInt(req.getParameter("username"));
		String password = req.getParameter("password");
		
		System.out.println(username+"----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(password+"-----------------------------------------------------------------------------------------");

		UserDao userDao = new UserDao();

		UserDto userDto = userDao.login(username);
		if (userDto == null ) {
			resp.getWriter().print("<h1>Invalid Username</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
		if(userDto.isStatus()) {
				if (userDto.getPassword().equals(password)) {
					req.getSession().setAttribute("customer", userDto);
					resp.getWriter().print("<h1>Login Success</h1>");
					req.getRequestDispatcher("CustomerHome.html").include(req, resp);
				} else {
					resp.getWriter().print("<h1>Invalid Password</h1>");
					req.getRequestDispatcher("Login.html").include(req, resp);
				}
		}else {
			resp.getWriter().print("<h1>Wait For Admin Approval</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		}
	}
}

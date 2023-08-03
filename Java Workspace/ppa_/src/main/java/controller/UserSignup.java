package controller;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserDto;
@WebServlet("/usersignup")
public class UserSignup extends  HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao userDao = new UserDao();

		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		Date date = Date.valueOf(req.getParameter("dob"));
		
			if (userDao.check(mobile).isEmpty() && userDao.check1(email).isEmpty())// 1
			{
				UserDto userDto = new UserDto();
				userDto.setName(req.getParameter("name"));
				userDto.setGender(req.getParameter("gender"));
				userDto.setPassword(req.getParameter("password"));
				userDto.setDob(date);
				userDto.setEmail(email);
				userDto.setMobile(mobile);
				userDao.save(userDto);
				
				UserDto customer2 = userDao.check1(email).get(0);

				resp.getWriter().print("<h1>Account Created Successfully</h1>");
				if (customer2.getGender().equals("male"))
					resp.getWriter().print("<h1>Hello Sir</h1>");
				else
					resp.getWriter().print("<h1>Hello Mam</h1>");
				req.getRequestDispatcher("Home.html").include(req, resp);
				
				
				resp.getWriter().print("<h1>Your ID"+customer2.getId() +"</h1>");
			} else {
				resp.getWriter().print("<h1>Email or Phone Number already Exists</h1>");
				req.getRequestDispatcher("Signup.html").include(req, resp);
			}
		
	}
}

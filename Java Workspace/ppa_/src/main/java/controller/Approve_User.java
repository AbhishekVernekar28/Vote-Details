package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserDto;

@WebServlet("/approve")
public class Approve_User extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userid = Integer.parseInt(req.getParameter("username"));
		UserDao dao = new UserDao();
		UserDto dto = dao.login(userid);
		if (dto.isStatus()) {
			dto.setStatus(false);
		} else {
			dto.setStatus(true);
		}

		dao.update(dto);
		resp.getWriter().print("<h1><center>Update Success</center></h1>");

		req.setAttribute("list", dao.fetchall());
		req.getRequestDispatcher("fetchuser.jsp").include(req, resp);
	}
}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Booth_dao;
import dao.UserDao;

@WebServlet("/displaydata")
public class Display_All_Data extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao userDao = new UserDao();
		req.setAttribute("list", userDao.fetchAll());
		
		resp.getWriter().print("<h1>User Details</h1>");
		req.getRequestDispatcher("fetchusers.jsp").include(req, resp);
		
		Booth_dao booth_dao = new Booth_dao();
		req.setAttribute("list", booth_dao.fetchAll());
		
		resp.getWriter().print("<h1>Voting Details</h1>");
		req.getRequestDispatcher("fetchresult.jsp").include(req, resp);
		

	}
}

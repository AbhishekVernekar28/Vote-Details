package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Booth_dao;
import dto.Booth_dto;

@WebServlet("/fetchbyconsti")
public class FetchbyConsti extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name =req.getParameter("boothnumber");

		Booth_dao  booth_dao = new Booth_dao();

		List<Booth_dto> booth_dto = booth_dao.fetch1( name);
		
		
		if (booth_dto== null ) {
			resp.getWriter().print("<h1>Invalid data to fetch</h1>");
//			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
			resp.getWriter().print("<h1>Data Fetched</h1>");
			req.setAttribute("list", booth_dao.fetch1(name));
			req.getRequestDispatcher("fetchresult.jsp").include(req, resp);
		}
	}
}

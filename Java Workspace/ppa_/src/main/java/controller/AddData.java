package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Booth_dao;
import dto.Booth_dto;

@WebServlet("/adddata")
public class AddData extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Booth_dao booth_dao=new Booth_dao();
		Booth_dto booth_dto=new Booth_dto();
		booth_dto.setPolling_Booth_Number(Integer.parseInt(req.getParameter("boothnumber")));
		booth_dto.setPolling_Booth_Name(req.getParameter("boothname"));
		booth_dto.setParent_Constituency(req.getParameter("const"));
		
		booth_dto.set_2014_Winner(req.getParameter("win"));
		booth_dto.set_2014_RunnerUp(req.getParameter("run"));
		booth_dto.set_2014_Margin_per(Double.parseDouble(req.getParameter("marper")));
		booth_dto.set_2014_Margin(Integer.parseInt(req.getParameter("mar")));
		booth_dto.set_2014_Total_votes(Integer.parseInt(req.getParameter("total")));
		booth_dto.set_2014_BJP_votes(Integer.parseInt(req.getParameter("bjp")));
		booth_dto.set_2014_BIP_per(Double.parseDouble(req.getParameter("bjpper")));		
		booth_dto.set_2014_INC_Votes(Integer.parseInt(req.getParameter("inc")));
		booth_dto.set_2014_INC_per(Double.parseDouble(req.getParameter("incper")));
		
		booth_dto.set_2019_Winner(req.getParameter("win2"));
		booth_dto.set_2014_RunnerUp(req.getParameter("run2"));
		booth_dto.set_2019_Margin_per(Double.parseDouble(req.getParameter("marper2")));
		booth_dto.set_2019_Margin(Integer.parseInt(req.getParameter("mar2")));
		booth_dto.set_2019_Total_votes(Integer.parseInt(req.getParameter("total2")));
		booth_dto.set_2019_BJP_votes(Integer.parseInt(req.getParameter("bjp2")));
		booth_dto.set_2019_BIP_per(Double.parseDouble(req.getParameter("bjpper")));
		booth_dto.set_2019_INC_Votes(Integer.parseInt(req.getParameter("inc2")));
		booth_dto.set_2019_INC_per(Double.parseDouble(req.getParameter("incper2")) );
		
		resp.getWriter().print("<h1>Add Successfully</h1>");
		booth_dao.save(booth_dto);
		
		resp.getWriter().print("<h1>Added Successfully</h1>");
		req.getRequestDispatcher("AddData.html").include(req, resp);
		
		
		
	}
}

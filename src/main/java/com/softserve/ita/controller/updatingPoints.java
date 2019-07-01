package com.softserve.ita.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.ita.dao.UserDAO;
import com.softserve.ita.dao.impl.UserDAOImpl;

/**
 * Servlet implementation class updatingPoints
 */
@WebServlet("/updatingpoints")
public class updatingPoints extends HttpServlet {
	private UserDAO dao;
	 @Override
	    public void init(ServletConfig config) throws ServletException {
	        dao = new UserDAOImpl();
	    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idd = (String)request.getParameter("userId");
		Integer id = Integer.parseInt(idd);
		Double subject1 = Double.parseDouble((String)request.getParameter("subject1"));
		Double subject2 = Double.parseDouble((String)request.getParameter("subject2"));
		Double subject3 = Double.parseDouble((String)request.getParameter("subject3"));
		Double certificate = Double.parseDouble((String)request.getParameter("certificate"));
		boolean updateLoginSystemId = dao.updatePoints(id, subject1, subject2, subject3, certificate);
		if(updateLoginSystemId == true) {
			response.sendRedirect("AdminPage.jsp");
		}
	}

}

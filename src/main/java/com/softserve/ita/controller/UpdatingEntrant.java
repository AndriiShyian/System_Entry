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
 * Servlet implementation class UpdatingEntrant
 */
@WebServlet("/updatingentrant")
public class UpdatingEntrant extends HttpServlet {
	private UserDAO dao;
	 @Override
	    public void init(ServletConfig config) throws ServletException {
	        dao = new UserDAOImpl();
	    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idd = (String)request.getParameter("userId");
		Integer id = Integer.parseInt(idd);
		String name = (String)request.getParameter("name");
		String surname = (String)request.getParameter("surname");
		String date = (String)request.getParameter("date");
		boolean updateLoginSystemId = dao.updateEntrant(id, name, surname, date);
		if(updateLoginSystemId == true) {
			response.sendRedirect("AdminPage.jsp");
		}
	}

}

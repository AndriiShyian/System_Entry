package com.softserve.ita.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.ita.dao.UserDAO;
import com.softserve.ita.dao.impl.UserDAOImpl;
import com.softserve.ita.model.User;

/**
 * Servlet implementation class Updating
 */
@WebServlet("/updating")
public class Updating extends HttpServlet {
	private UserDAO dao;
	 @Override
	    public void init(ServletConfig config) throws ServletException {
	        dao = new UserDAOImpl();
	    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idd = (String)request.getParameter("userId");
		Integer id = Integer.parseInt(idd);
		String login = (String)request.getParameter("login");
		String password = (String)request.getParameter("password");
		String userType = (String)request.getParameter("typeofuser");
		boolean updateLoginSystemId = dao.updateLoginSystemId(id, login, password, userType);
		if(updateLoginSystemId) {
			response.sendRedirect("AdminPage.jsp");
		}
	}

}

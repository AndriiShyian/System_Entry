package com.softserve.ita.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class StudentsAppliedOnMath
 */
@WebServlet("/StudentsAppliedOnMath")
public class StudentsAppliedOnMath extends HttpServlet {
	
	private UserDAO dao;
	 @Override
	    public void init(ServletConfig config) throws ServletException {
	        dao = new UserDAOImpl();
	    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ArrayList<User> list = (ArrayList<User>) dao.seeAllEntrantsOnMath();
		 request.setAttribute("users", list);
		 request.getRequestDispatcher("/ShowEntrantDueToInstitute.jsp").forward(request, response);
		 
	}

}
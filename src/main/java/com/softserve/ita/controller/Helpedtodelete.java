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

@WebServlet("/helpedtodelete")
public class Helpedtodelete extends HttpServlet {
	private UserDAO dao;
	 @Override
	    public void init(ServletConfig config) throws ServletException {
	        dao = new UserDAOImpl();
	    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String idd = (String)request.getParameter("uid");
		   Integer id = Integer.parseInt(idd);
		   User user = dao.gettingUserByIdFromUser(id);
		   if(user.getName() != null) {
			 request.setAttribute("id", id);  
			 request.getRequestDispatcher("DeleteFromAllSystem.jsp").forward(request, response);;
		   }
		   else {
			   boolean deleteFromLoginSystem = dao.deleteFromLoginSystem(id);
			   if(deleteFromLoginSystem) {
				   request.getRequestDispatcher("AdminPage.jsp").forward(request, response);;
			   }
		   }
		   
	}
}

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
 * Servlet implementation class HelpedToUpdateController
 */
@WebServlet("/helpedtoupdate")
public class HelpedToUpdateController extends HttpServlet {
	private UserDAO dao;
	 @Override
	    public void init(ServletConfig config) throws ServletException {
	        dao = new UserDAOImpl();
	    }
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	   String idd = (String)request.getParameter("uid");
	   Integer id = Integer.parseInt(idd);
	   User user = dao.getUserByIdFromLoginSystem(id);
	   request.setAttribute("user", user);
	   request.getRequestDispatcher("/Update.jsp").forward(request, response);
		}
}

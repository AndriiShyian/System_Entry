package com.softserve.ita.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class AddingNewByAdmin
 */
@WebServlet("/addingNew")
public class AddingNewByAdmin extends HttpServlet {
	private UserDAO dao;
	 @Override
	    public void init(ServletConfig config) throws ServletException {
	        dao = new UserDAOImpl();
	    }
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	        String login = req.getParameter("login");
	        String password = req.getParameter("password");
	        String repeatedPassword = req.getParameter("repeatedPassword");
	        ArrayList<User> list = (ArrayList<User>) dao.allFromLoginSystem();
	        boolean registerUser = dao.registerUser(login, password, repeatedPassword);
	        if(registerUser == true && password.equals(repeatedPassword)) {
	        	resp.setContentType("text/html");
	       resp.sendRedirect("AdminPage.jsp");
	        }
	        else {
	        	req.setAttribute("users", list);
	        	req.getRequestDispatcher("/AllFromLoginTable.jsp").forward(req, resp);
	        }
	    }
	}
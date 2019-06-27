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
 * Servlet implementation class RegistrationController
 */
@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
	private UserDAO dao;
	
	 @Override
	    public void init(ServletConfig config) throws ServletException {
	        dao = new UserDAOImpl();
	    } @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	        String login = req.getParameter("login");
	        String password = req.getParameter("password");
	        String repeatedPassword = req.getParameter("repeatedPassword");
	        boolean registerUser = dao.registerUser(login, password, repeatedPassword);
	        if(registerUser == true && password.equals(repeatedPassword)) {
	        	resp.setContentType("text/html; charset=UTF-8");
	        req.setAttribute("resultLogin", registerUser);
	        req.getRequestDispatcher("/Login.jsp").forward(req, resp);
	        }
	        else {
	        	req.getRequestDispatcher("/Registration.jsp").forward(req, resp);
	        }
	    }
	}
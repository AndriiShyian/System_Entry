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
 * Servlet implementation class IdOfUserController
 */
@WebServlet("/IdOfUserController")
public class IdOfUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDAO dao;
	
	 @Override
	    public void init(ServletConfig config) throws ServletException {
	        dao = new UserDAOImpl();
	    }
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String login = req.getParameter("login");
	        String password = req.getParameter("password");
	        boolean resultLogin = dao.getUserByLoginAndPassword(login, password);
	        if(resultLogin) {
	        req.setAttribute("resultLogin", resultLogin);
	        req.getRequestDispatcher("/Faculties.jsp").forward(req, resp);
	        }
	        else {
	        	req.getRequestDispatcher("/Login.jsp").forward(req, resp);
	        }
	    }
	}

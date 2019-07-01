package com.softserve.ita.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.ita.dao.UserDAO;
import com.softserve.ita.dao.impl.UserDAOImpl;
import com.softserve.ita.model.User;

import java.io.*;

@WebServlet("/login")
public class LoginController extends HttpServlet {
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
        Integer getIdOfUser = dao.getIdOfUser(login, password);
        if(resultLogin == true && getIdOfUser > 0) {
        	req.setAttribute("login_system_id", getIdOfUser);
            req.getSession().setAttribute("login_system_id", getIdOfUser);
        if(!login.equals("admin")) {
        	resp.sendRedirect("Faculties.jsp");
//        req.getRequestDispatcher("/Faculties.jsp").forward(req, resp);
        }
        else{
        	resp.sendRedirect("AdminPage.jsp");
//        	req.getRequestDispatcher("/AdminPage.jsp").forward(req, resp);
        	}
        }
        else {
        	resp.sendRedirect("Login.jsp");
//        	req.getRequestDispatcher("/Login.jsp").forward(req, resp);
        }
    }
}
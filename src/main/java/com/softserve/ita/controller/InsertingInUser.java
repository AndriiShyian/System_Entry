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
import com.softserve.ita.model.User;

/**
 * Servlet implementation class InsertingInUser
 */
@WebServlet("/InsertingInUser")
public class InsertingInUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new UserDAOImpl();
	}
       
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getAttribute("user");
		boolean resultOfInsertingWebStudentIntoUser = dao.insertingWebStudentIntoUser(user.getName(), user.getSurname(), user.getDate(), user.getIdOfUser(),
				user.getIdOfPoints());
		if(resultOfInsertingWebStudentIntoUser == true) {
			request.getRequestDispatcher("/Faculties.jsp").forward(request, response);
		}
	}

}

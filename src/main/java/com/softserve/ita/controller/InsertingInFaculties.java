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
 * Servlet implementation class InsertingInFaculties
 */
@WebServlet("/InsertingInFaculties")
public class InsertingInFaculties extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new UserDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int login_system_id = (Integer)request.getAttribute("login_system_id");
		User user =  dao.gettingUserByIdFromUser(login_system_id);
		int sumOfSubjects = (Integer) request.getAttribute("sumOfSubjects");
		int idOfInstitute = (Integer) request.getAttribute("idOfInstitute");
		int idOfUserByIdOfLoginSystem = dao.idOfUserByIdOfLoginSystem(user.getIdOfUser());
		boolean insertingoInResult = dao.insertingoInResult(sumOfSubjects, idOfUserByIdOfLoginSystem, login_system_id, user.getIdOfPoints(), idOfInstitute);
		if(insertingoInResult == true) {
			request.getRequestDispatcher("Faculties.jsp").forward(request, response);	
		}
	
	
	}

}

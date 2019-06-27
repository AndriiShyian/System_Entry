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
 * Servlet implementation class InsertingWebStudentController
 */
@WebServlet("/insertingWeb")
public class InsertingWebStudentController extends HttpServlet {
	private UserDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new UserDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String date = request.getParameter("date");
		int math = Integer.parseInt(request.getParameter("math"));
		int language1 = Integer.parseInt(request.getParameter("language1"));
		int language2 = Integer.parseInt(request.getParameter("language2"));
		int certificate = Integer.parseInt(request.getParameter("certificate"));
		int idOfInstitute = Integer.parseInt(request.getParameter("idOfInstitute"));
		String hiddenWeb = request.getParameter("insertingWebStudent");
		String gotId = request.getParameter("gotId");
		Integer idOfUser = Integer.parseInt(gotId);
		int idOfPoints = dao.getIdOfPoints() + 1;
		boolean resultOfInsertingWebStudentIntoPointsForEntry = dao.insertingStudentIntoPointsForEntry(math, language1,
				language2, certificate);
		if (resultOfInsertingWebStudentIntoPointsForEntry == true) {
			User user = new User(name, surname, date, idOfUser, idOfPoints);
			request.setAttribute("user", user);
			request.setAttribute("login_system_id", idOfUser);
			request.setAttribute("idOfInstitute", idOfInstitute);
			request.getRequestDispatcher("/InsertingInUser").forward(request, response);
		}
	}
}

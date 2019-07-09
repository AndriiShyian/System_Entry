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
		int subject1 = Integer.parseInt(request.getParameter("subject1"));
		int subject2 = Integer.parseInt(request.getParameter("subject2"));
		int subject3 = Integer.parseInt(request.getParameter("subject3"));
		int certificate = Integer.parseInt(request.getParameter("certificate"));
		int idOfInstitute = Integer.parseInt(request.getParameter("idOfInstitute"));
		String gotId = request.getParameter("gotId");
		Integer idOfUser = Integer.parseInt(gotId);
		int idOfPoints = dao.getIdOfPoints() + 1;
		int sumOfSubjects = subject1 + subject2 + subject3 + certificate;
		boolean resultOfInsertingWebStudentIntoPointsForEntry = dao.insertingStudentIntoPointsForEntry(subject1, subject2,
				subject3, certificate);
		if (resultOfInsertingWebStudentIntoPointsForEntry) {
			User user = new User(name, surname, date, idOfUser, idOfPoints);
			request.setAttribute("user", user);
			request.setAttribute("login_system_id", idOfUser);
			request.setAttribute("idOfInstitute", idOfInstitute);
			request.setAttribute("sumOfSubjects", sumOfSubjects);
			request.getRequestDispatcher("/InsertingInUser").forward(request, response);
		}
	}
}

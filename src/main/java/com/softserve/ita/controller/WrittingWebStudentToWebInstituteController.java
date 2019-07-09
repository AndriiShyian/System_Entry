package com.softserve.ita.controller;

import java.io.IOException;
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
 * Servlet implementation class WrittingWebStudentToWebInstituteController
 */
@WebServlet("/WrittingWebStudentToWebInstituteController")
public class WrittingWebStudentToWebInstituteController extends HttpServlet {
	private UserDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new UserDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idOfInstitute = (Integer) request.getAttribute("idOfInstitute");
		int login_system_id = (Integer) request.getAttribute("login_system_id");
		int sumOfSubjects = (Integer) request.getAttribute("sumOfSubjects");
		User user = (User) request.getAttribute("user");
		int idOfUser = dao.idOfUserByIdOfLoginSystem(login_system_id);
		boolean checkOnDulicatesInUserHasFaculty = dao.checkOnDulicatesInUserHasFaculty(idOfUser, idOfInstitute);
		if (checkOnDulicatesInUserHasFaculty) {
			request.getRequestDispatcher("YouAreRegisteredOnThisCourse.jsp").forward(request, response);
		} else {
			int idOfInstituteFromUserHasFaculty = dao.idOfInstitute(idOfUser);
			if (((idOfInstituteFromUserHasFaculty == 1 || idOfInstituteFromUserHasFaculty == 2
					|| idOfInstituteFromUserHasFaculty == 3 || idOfInstituteFromUserHasFaculty == 7)
					&& (idOfInstitute == 4 || idOfInstitute == 5 || idOfInstitute == 6)
					|| (idOfInstituteFromUserHasFaculty == 4) && (idOfInstitute == 1 || idOfInstitute == 2
							|| idOfInstitute == 3 || idOfInstitute == 5 || idOfInstitute == 6 || idOfInstitute == 7) 
					|| (idOfInstituteFromUserHasFaculty == 5 || idOfInstituteFromUserHasFaculty == 6) && (idOfInstitute == 1 || idOfInstitute == 2 || idOfInstitute == 3 || idOfInstitute == 4 || idOfInstitute == 7))) {
				request.getRequestDispatcher("AnotherTypeOfInstitute.jsp").forward(request, response);
			} else {
				boolean insertIntoUserHasFaculty = dao.insertIntoUserHasFaculty(idOfUser, idOfInstitute);
				if (insertIntoUserHasFaculty) {
					request.setAttribute("user", user);
					request.setAttribute("sumOfSubjects", sumOfSubjects);
					request.setAttribute("idOfInstitute", idOfInstitute);
					request.getRequestDispatcher("InsertingInFaculties").forward(request, response);
				}
			}
		}
	}
}
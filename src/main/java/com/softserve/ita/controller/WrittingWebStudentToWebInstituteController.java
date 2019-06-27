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
		int idOfUser = dao.idOfUserByIdOfLoginSystem(login_system_id);
		boolean checkOnDulicatesInUserHasFaculty = dao.checkOnDulicatesInUserHasFaculty(idOfUser, idOfInstitute);
		if (checkOnDulicatesInUserHasFaculty == true) {
			request.getRequestDispatcher("YouAreRegisteredOnThisCourse.jsp").forward(request, response);
		} else {
			
			boolean insertIntoUserHasFaculty = dao.insertIntoUserHasFaculty(idOfUser, idOfInstitute);
			if (insertIntoUserHasFaculty == true) {
				request.getRequestDispatcher("Faculties.jsp").forward(request, response);
			}
		}
	}
}

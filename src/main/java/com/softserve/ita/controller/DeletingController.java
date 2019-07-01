package com.softserve.ita.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class DeletingController
 */
@WebServlet("/DeletingController")
public class DeletingController extends HttpServlet {
	private UserDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new UserDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idd = (String) request.getParameter("id");
		Integer id = Integer.parseInt(idd);
		int idOfEntrant = dao.idOfUserByIdOfLoginSystem(id);
		int pointsId = dao.idOfPoints(idOfEntrant);
		boolean deleteUserFromResults = dao.deleteUserFromResults(idOfEntrant);
		if (deleteUserFromResults == true) {
			boolean deleteFromUserHasFaculties = dao.deleteFromUserHasFaculties(idOfEntrant);
			if (deleteFromUserHasFaculties == true) {
				boolean deleteUserFromEntrant = dao.deleteUserFromEntrant(idOfEntrant);
				if (deleteUserFromEntrant == true) {
					boolean deleteFromPoints = dao.deleteFromPoints(pointsId);
					if (deleteFromPoints == true) {
						boolean deleteFromLoginSystem = dao.deleteFromLoginSystem(id);
						if (deleteFromLoginSystem == true) {
							response.sendRedirect("AdminPage.jsp");
						}
					}
				}
			}
		}
	}
}
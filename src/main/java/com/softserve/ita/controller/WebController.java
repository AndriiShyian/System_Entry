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
 * Servlet implementation class WebController
 */
@WebServlet("/web")
public class WebController extends HttpServlet {
	private UserDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new UserDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String receivedValue = "";
		int idOfInstituteMath = dao.findingIdOfInstitute("Math");
		int idOfInstituteWeb = dao.findingIdOfInstitute("Web development");
		int idOfInstituteEconomy = dao.findingIdOfInstitute("Economy");
		int idOfInstituteChemistry = dao.findingIdOfInstitute("Chemistry");
		int idOfInstituteLaw = dao.findingIdOfInstitute("Law");
		int idOfInstituteForeignLanguage = dao.findingIdOfInstitute("Foreign Language");
		int idOfInstituteComputerScience = dao.findingIdOfInstitute("Computer Science");
		if (request.getParameter("mathform") != null) {
			receivedValue = request.getParameter("mathform");
		} else if (request.getParameter("webform") != null) {
			receivedValue = request.getParameter("webform");
		}
		else if(request.getParameter("economyform") != null) {
			receivedValue = request.getParameter("economyform");
		}
		else if (request.getParameter("chemistryform") != null) {
			receivedValue = request.getParameter("chemistryform");
		}
		else if (request.getParameter("lawform") != null) {
			receivedValue = request.getParameter("lawform");
		}
		else if (request.getParameter("foreignlangform") != null) {
			receivedValue = request.getParameter("foreignlangform");
		}
		else if (request.getParameter("computerscienceform") != null) {
			receivedValue = request.getParameter("computerscienceform");
		}
		String login_system_idd = request.getParameter("login_system_id");
		Integer login_system_id = Integer.parseInt(login_system_idd);
		User user = dao.gettingUserByIdFromUser(login_system_id);
		if (user.getName() != null && user.getSurname() != null && user.getDate() != null && user.getIdOfUser() != 0
				&& user.getIdOfPoints() != 0) {
			int sumOfSubjects = dao.findPointsInResults(login_system_id);
			request.setAttribute("sumOfSubjects", sumOfSubjects);
			request.setAttribute("theUser", user);
			request.setAttribute("login_system_id", login_system_id);
			if (receivedValue.equals("web")) {
				request.setAttribute("idOfInstitute", idOfInstituteWeb);
			}
			if (receivedValue.equals("math")) {
		request.setAttribute("idOfInstitute", idOfInstituteMath);
	}
			if (receivedValue.equals("economy")) {
		request.setAttribute("idOfInstitute", idOfInstituteEconomy);
	}
			if (receivedValue.equals("chemistry")) {
				request.setAttribute("idOfInstitute", idOfInstituteChemistry);
			}
			if (receivedValue.equals("law")) {
				request.setAttribute("idOfInstitute", idOfInstituteLaw);
			}
			if (receivedValue.equals("foreignlang")) {
				request.setAttribute("idOfInstitute", idOfInstituteForeignLanguage);
			}
			if (receivedValue.equals("computerscience")) {
				request.setAttribute("idOfInstitute", idOfInstituteComputerScience);
			}
			request.getRequestDispatcher("/WrittingWebStudentToWebInstituteController").forward(request, response);
		} else {
			if(receivedValue.equals("web")) {
				request.setAttribute("idOfInstitute", idOfInstituteWeb);
			}
			if(receivedValue.equals("math")) {
				request.setAttribute("idOfInstitute", idOfInstituteMath);
			}
			if(receivedValue.equals("economy")) {
				request.setAttribute("idOfInstitute", idOfInstituteEconomy);
			}
			if(receivedValue.equals("chemistry")) {
				request.setAttribute("idOfInstitute", idOfInstituteChemistry);
			}
			if(receivedValue.equals("law")) {
				request.setAttribute("idOfInstitute", idOfInstituteLaw);
			}
			if (receivedValue.equals("foreignlang")) {
				request.setAttribute("idOfInstitute", idOfInstituteForeignLanguage);
			}
			if (receivedValue.equals("computerscience")) {
				request.setAttribute("idOfInstitute", idOfInstituteComputerScience);
			}
			request.setAttribute("webform", receivedValue);
			request.setAttribute("login_system_idd", login_system_idd);
			request.getRequestDispatcher("/ApplyingMathWebComputerScienceEconomy.jsp").forward(request, response);
		}
	}
}
package com.softserve.ita.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WebController
 */
@WebServlet("/web")
public class WebController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String webHidden = request.getParameter("webform");
		String login_system_id = request.getParameter("login_system_id");
		request.setAttribute("webform", webHidden);
		request.setAttribute("login_system_id",login_system_id);
		request.getRequestDispatcher("/ApplyingMathWebComputerScienceEconomy.jsp").forward(request, response);
	}

}

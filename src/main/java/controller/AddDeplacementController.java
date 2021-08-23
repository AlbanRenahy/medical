package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeplacementModel;
import model.InfirmiereModel;

/**
 * Servlet implementation class AddDeplacementController
 */
@WebServlet("/addDeplacement")
public class AddDeplacementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDeplacementController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/add-deplacement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomPatient = request.getParameter("nomPatient");
		String prenomPatient = request.getParameter("prenomPatient");
		LocalDate dateL = LocalDate.parse(request.getParameter("date"));
		Date date = java.sql.Date.valueOf(dateL);
		String coutS = request.getParameter("cout");
		Double cout = Double.parseDouble(coutS);
		System.out.println(cout);
		String nomInfirmiere = request.getParameter("nameInfirmiere");
		int id = 0;
		DeplacementModel pm = new DeplacementModel();

		try {

			pm.addDeplacement(id, nomPatient, prenomPatient, date, cout, nomInfirmiere, nomInfirmiere);
			response.sendRedirect("liste");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
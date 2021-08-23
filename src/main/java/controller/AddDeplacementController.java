package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.sql.SQLDataException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.DeplacementEntity;
import Entity.InfirmiereEntity;
import Entity.PatientEntity;
import model.DeplacementModel;
import model.InfirmiereModel;
import model.PatientModel;

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
		DeplacementModel dm = new DeplacementModel();
		InfirmiereModel im = new InfirmiereModel();
		PatientModel pm = new PatientModel();

		try {
			List<InfirmiereEntity> infirmieres = im.fetchAllInfirmiere();
			List<PatientEntity> patients = pm.fetchAllPatient();
			List<DeplacementEntity> deplacements = dm.fetchAllDeplacement();
			request.setAttribute("deplacement", deplacements);
			request.setAttribute("patients", patients);
			request.setAttribute("infirmieres", infirmieres);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("WEB-INF/addDeplacement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cout = request.getParameter("cout");
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		String patient_id = request.getParameter("idPatient");
		String infirmiere_id = request.getParameter("idInfirmiere");
		DeplacementModel dm = new DeplacementModel();

		try {
			dm.addDeplacement(Double.parseDouble(cout), date, Integer.parseInt(infirmiere_id),
					Integer.parseInt(patient_id));
			response.sendRedirect("liste");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
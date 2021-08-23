package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

@WebServlet("/updateDeplacement")
public class UpdateDeplacement extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DeplacementModel dm = new DeplacementModel();
		InfirmiereModel im = new InfirmiereModel();
		PatientModel pm = new PatientModel();
		
		
		try {
			List<InfirmiereEntity> infirmieres = im.fetchAllInfirmiere();
			List<PatientEntity> patients = pm.fetchAllPatient();
			DeplacementEntity deplacement = dm.oneDeplacement(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("deplacement", deplacement);	
			request.setAttribute("patients", patients);
			request.setAttribute("infirmieres", infirmieres);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("WEB-INF/updateDeplacement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String cout = request.getParameter("cout");
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		String patient_id = request.getParameter("patient_id");
		String infirmiere_id = request.getParameter("infirmiere_id");
		DeplacementModel dm = new DeplacementModel();
		
		try {
			dm.updateDeplacement(Integer.parseInt(id), Double.parseDouble(cout), date, Integer.parseInt(infirmiere_id),Integer.parseInt(patient_id));	
			response.sendRedirect("liste");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
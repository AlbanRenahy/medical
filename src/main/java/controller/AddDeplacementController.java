package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PatientModel pm = new PatientModel();
		InfirmiereModel inf = new InfirmiereModel();
		
		List<PatientEntity> patients = new ArrayList<>();
		List<InfirmiereEntity> infirmieres = new ArrayList<>();
		try {
			patients = pm.fetchAllPatient();
			infirmieres = inf.fetchAllInfirmiere();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("patients", patients);
		request.setAttribute("infirmieres", infirmieres);
		
		request.getRequestDispatcher("WEB-INF/addDeplacement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idPatient = request.getParameter("idPatient");
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		String cout = request.getParameter("cout");
		String idInfirmiere = request.getParameter("idInfirmiere");
		
		DeplacementModel dm = new DeplacementModel();
		
		try {
			dm.addDeplacement(Integer.parseInt(idPatient), date, Integer.parseInt(cout), Integer.parseInt(idInfirmiere));
			response.sendRedirect("liste");
		} catch (Exception e ){
			e.printStackTrace();
		}
	}

}
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.InfirmiereEntity;
import model.InfirmiereModel;
import model.PatientModel;

/**
 * Servlet implementation class AddPatientController
 */
@WebServlet("/addPatient")
public class AddPatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		InfirmiereModel inf = new InfirmiereModel();
		
		List<InfirmiereEntity> infirmieres = new ArrayList<>();
		try {
			infirmieres = inf.fetchAllInfirmiere();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("infirmieres", infirmieres);
		
		request.getRequestDispatcher("WEB-INF/add-patient.jsp").forward(request, response);
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom =request.getParameter("prenom");
		String sexe = request.getParameter("sexe");
		String dateDeNaissance=request.getParameter("dateDeNaissance");
		String numeroSecuriteSociale =request.getParameter("numeroSecuriteSociale");
		String infirmiere_id =request.getParameter("nameInfirmiere");
		
		String numero = request.getParameter("numero");
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		
		System.out.println(numeroSecuriteSociale + " " + rue );
		
		PatientModel pm = new PatientModel();
		
		try {
			pm.addPatient(nom,prenom,sexe,dateDeNaissance,Integer.parseInt(numeroSecuriteSociale), Integer.parseInt(infirmiere_id), numero,rue,Integer.parseInt(cp),ville );
			response.sendRedirect("liste");
		} catch (Exception e ){
			e.printStackTrace();
		}
	}

}

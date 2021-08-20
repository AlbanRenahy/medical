package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.PatientEntity;
import model.Patient;

/**
 * Servlet implementation class PatientController
 */
@WebServlet(name = "Patient", urlPatterns = { "/patient" })
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Patient con = new Patient("jdbc:mysql://localhost:3306/medical", "root", "root");
		try {
			List<PatientEntity> patients = con.fetchAllPatient();
			request.setAttribute("patients", patients);
		} catch(Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/patient.jsp").forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String dateDeNaissance = request.getParameter("dateDeNaissance");
		String sexe = request.getParameter("sexe");
		String numeroSecuriteSocial = request.getParameter("numeroSecuriteSocial");
		String numero = request.getParameter("numero");
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		
		
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		request.setAttribute("dateDeNaissance", dateDeNaissance);
		request.setAttribute("sexe", sexe);
		request.setAttribute("numeroSecuriteSocial", numeroSecuriteSocial);
		request.setAttribute("numero", numero);
		request.setAttribute("rue", rue);
		request.setAttribute("cp", cp);
		request.setAttribute("ville", ville);
		
		request.getRequestDispatcher("WEB-INF/patient.jsp").forward(request, response);
	}

}

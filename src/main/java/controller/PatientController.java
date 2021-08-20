package controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.InfirmiereEntity;
import Entity.PatientEntity;
import model.Infirmiere;
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
		Infirmiere conn = new Infirmiere("jdbc:mysql://localhost:3306/medical", "root", "root");
		try {
			List<PatientEntity> patients = con.fetchAllPatient();
			List<InfirmiereEntity> infirmieres = conn.fetchAllInfirmiere();
			request.setAttribute("patients", patients);
			request.setAttribute("infirmieres", infirmieres);
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
		Patient con = new Patient("jdbc:mysql://localhost:3306/medical", "root", "root");
        int adresse = 0;
        //Données adresse patient
        String numero = request.getParameter("numero");
        String rue = request.getParameter("rue");
        System.out.println(request.getParameter("cp"));
        int cp = Integer.parseInt(request.getParameter("cp"));
        System.out.println(cp);
        String ville = request.getParameter("ville");
        //System.out.println(cp);
               
        try {
            //con.addPatient(nom, prenom, sexe, dateDeNaissance, numeroSecuriteSocial, adresse_id, infirmiere_id);
            con.addAdresse(numero, rue, cp, ville);
        } catch (Exception e) {
            e.printStackTrace();
        }
               
        //Données patient
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String sexe = request.getParameter("sexe");
        System.out.println(request.getParameter("dateDeNaissance"));
        String dateDeNaissance = request.getParameter("dateDeNaissance");
//        System.out.println("coucou");
        int numeroSecuriteSocial = Integer.parseInt(request.getParameter("numeroSecuriteSocial"));
        System.out.println(numeroSecuriteSocial);
        try {
            HashMap<Integer,String> adresses = con.fetchAllAdresses();
            for(Entry<Integer,String> entry : adresses.entrySet())
            {
                if(entry.getValue().equals(numero+" "+rue+" "+cp+" "+ville))
                {
                    adresse = entry.getKey();
                }
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        int adresse_id = adresse;
        System.out.println("infirmiere_id");
        int infirmiere_id = Integer.parseInt(request.getParameter("infirmiere_id"));
        System.out.println(infirmiere_id);
       
        try {
            con.addPatient(nom, prenom, sexe, dateDeNaissance, numeroSecuriteSocial, adresse_id, infirmiere_id);
            //con.addAdresse(numero, rue, cp, ville);
        } catch (Exception e) {
            e.printStackTrace();
        }
   
        response.sendRedirect("patient");
        
	}
}

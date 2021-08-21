package controller;

import java.io.IOException;
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

/**
 * Servlet implementation class PatientController
 */
@WebServlet(name = "List", urlPatterns = { "/liste" })
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PatientModel con = new PatientModel();
		InfirmiereModel inf = new InfirmiereModel();
		DeplacementModel dep = new DeplacementModel();
		
		try {
			List<PatientEntity> patients = con.fetchAllPatient();
			request.setAttribute("patients", patients);

			List<InfirmiereEntity> infirmieres = inf.fetchAllInfirmiere();
			request.setAttribute("infirmieres", infirmieres);
			
			List<DeplacementEntity> deplacements = dep.fetchAllDeplacement();
			request.setAttribute("deplacements", deplacements);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("WEB-INF/liste.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

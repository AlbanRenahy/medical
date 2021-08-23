package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InfirmiereModel;
import model.PatientModel;

/**
 * Servlet implementation class addInfirmiereController
 */
@WebServlet("/addInfirmiere")
public class AddInfirmiereController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInfirmiereController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/add-Infirmiere.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numeroProfessionnel = request.getParameter("numeroProfessionnel");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String telPro = request.getParameter("telPro");
		String telPerso = request.getParameter("telPerso");
		String numero = request.getParameter("numero");
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		
		InfirmiereModel pm = new InfirmiereModel();
		
		try {
			pm.addInfirmiere(Integer.parseInt(numeroProfessionnel), nom, prenom, Integer.parseInt(telPro), Integer.parseInt(telPerso),numero,rue,Integer.parseInt(cp),ville);	
			response.sendRedirect("liste");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

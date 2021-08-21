package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.InfirmiereEntity;
import model.InfirmiereModel;

@WebServlet("/updateInfirmiere")
public class UpdateInfirmiereController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		InfirmiereModel pm = new InfirmiereModel();
		
		try {
			InfirmiereEntity infirmiere = pm.oneInfirmiere(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("infirmiere", infirmiere);			
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("WEB-INF/updateInfirmiere.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String numPro = request.getParameter("numeroProfessionnel");
		String telPerso = request.getParameter("telPerso");
		String telPro = request.getParameter("telPro");
		String numero = request.getParameter("numero");
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		//request.getParameter("nameInfirmiere");
		//request.getParameter("adresseInfirmiere");
		InfirmiereModel pm = new InfirmiereModel();
		
		try {
			pm.updateInfirmiere(Integer.parseInt(id), nom, prenom, numPro, Integer.parseInt(telPerso), Integer.parseInt(telPro),numero,rue, Integer.parseInt(cp), ville);	
			response.sendRedirect("liste");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.DeplacementEntity;
import model.Deplacement;

/**
 * Servlet implementation class DeplacementController
 */
@WebServlet(name = "Deplacement", urlPatterns = { "/deplacement" })
public class DeplacementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeplacementController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				Deplacement con = new Deplacement("jdbc:mysql://localhost:3306/medical", "root", "root");
				try {
					List<DeplacementEntity> deplacements = con.fetchAllDeplacement();
					request.setAttribute("deplacements", deplacements);
				} catch(Exception e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("WEB-INF/deplacement.jsp").forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

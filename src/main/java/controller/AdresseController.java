package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.AdresseEntity;
import model.Adresse;

/**
 * Servlet implementation class AdresseController
 */
@WebServlet(name = "Adresse", urlPatterns = { "/adresse" })
public class AdresseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdresseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Adresse con = new Adresse("jdbc:mysql://localhost:3306/medical", "root", "root");
		try {
		List<AdresseEntity> adresses = con.fetchAllAdresse();
			request.setAttribute("adresses", adresses);
		} catch(Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/adresse.jsp").forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

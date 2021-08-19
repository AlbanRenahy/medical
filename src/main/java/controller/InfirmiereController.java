package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class InfirmiereController
 */
@WebServlet(name = "Infirmiere", urlPatterns = { "/infirmiere" })
public class InfirmiereController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfirmiereController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Infirmiere con = new Infirmiere("jdbc:mysql://localhost:3306/medical", "root", "root");
		try {
			List<InfirmiereEntity> infirmieres = con.fetchAllInfirmiere();
			request.setAttribute("infirmieres", infirmieres);
		} catch(Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/infirmiere.jsp").forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

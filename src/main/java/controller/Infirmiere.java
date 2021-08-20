package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.InfirmiereEntitySimple;
import dao.InfirmiereDao;

/**
 * Servlet implementation class Infirmiere
 */
@WebServlet(name = "Infirmiere", urlPatterns = { "/infirmiere" })
public class Infirmiere extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InfirmiereDao infirmiereDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Infirmiere() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void Init() {
        infirmiereDao = new InfirmiereDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertInfirmiere(request, response);
                    break;
                case "/delete":
                    deleteInfirmiere(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateInfirmiere(request, response);
                    break;
                default:
                	listInfirmiere(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
	 private void listInfirmiere(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        List < InfirmiereEntitySimple > listInfirmiere = InfirmiereDao.selectAllInfirmieres();
			        request.setAttribute("listInfirmiere", listInfirmiere);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/list-infirmiere.jsp");
			        dispatcher.forward(request, response);
			    }

			    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form-infirmiere.jsp");
			        dispatcher.forward(request, response);
			    }

			    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, ServletException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        InfirmiereEntitySimple existingInfirmiere = InfirmiereDao.selectInfirmiere(id);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form-infirmiere.jsp");
			        request.setAttribute("Infirmiere", existingInfirmiere);
			        dispatcher.forward(request, response);

			    }

			    private void insertInfirmiere(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			    	int id = Integer.parseInt(request.getParameter("id"));
			        String nom = request.getParameter("nom");
			        String prenom = request.getParameter("prenom");
			        int numeroProfessionnel = Integer.parseInt(request.getParameter("numeroProfessionnel"));
			        int telPro = Integer.parseInt(request.getParameter("telPro"));
			        int telPerso = Integer.parseInt(request.getParameter("telPerso"));
			        InfirmiereEntitySimple newInfirmiere = new InfirmiereEntitySimple(id,prenom,nom,numeroProfessionnel,telPro,telPerso);
			        InfirmiereDao.insertInfirmiere(newInfirmiere);
			        response.sendRedirect("list");
			    }

			    private void updateInfirmiere(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        String nom = request.getParameter("nom");
			        String prenom = request.getParameter("prenom");
			        int numeroProfessionnel = Integer.parseInt(request.getParameter("numeroProfessionnel"));
			        int telPro = Integer.parseInt(request.getParameter("telPro"));
			        int telPerso = Integer.parseInt(request.getParameter("telPerso"));

			        InfirmiereEntitySimple newInfirmiere = new InfirmiereEntitySimple(id, nom, prenom, numeroProfessionnel,telPro,telPerso);
			        InfirmiereDao.updateInfirmiere(newInfirmiere);
			        response.sendRedirect("list");
			    }

			    private void deleteInfirmiere(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        InfirmiereDao infirmiereDao = new InfirmiereDao();
					infirmiereDao.deleteInfirmiere(id);
			        response.sendRedirect("list");

			    }
			

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

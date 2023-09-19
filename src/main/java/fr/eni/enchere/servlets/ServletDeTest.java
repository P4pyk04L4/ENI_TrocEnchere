package fr.eni.enchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.UtilisateurDAO;
import fr.eni.enchere.dal.jdbc.UtilisateurDAOJdbcImpl;

/**
 * Servlet implementation class ServletDeTest
 */
@WebServlet("/ServletDeTest")
public class ServletDeTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDAO utilisateurDao;
       
    public ServletDeTest() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
        super.init();
        utilisateurDao = new UtilisateurDAOJdbcImpl(); // ou utilisez la classe d'implémentation que vous avez créée

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/tests/bonjour.jsp");
		request.setAttribute("utilisateurs", utilisateurDao.afficherTous());
		HttpSession session = request.getSession();
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(request.getParameter("nom"));
        utilisateur.setPrenom(request.getParameter("prenom"));
        utilisateur.setMotDePasse(request.getParameter("mot de passe"));
        
        utilisateurDao.insert(utilisateur);
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/tests/bonjour.jsp").forward(request, response);

	}

}

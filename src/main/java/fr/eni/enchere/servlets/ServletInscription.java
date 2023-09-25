package fr.eni.enchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;

@WebServlet("/inscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private UtilisateurDAO utilisateurDao = DAOFactory.getUtilisateurDAO();
	private UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
       
    public ServletInscription() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/gestionUtilisateurs/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setPseudo(request.getParameter("pseudo"));
			utilisateur.setNom(request.getParameter("nom"));
			utilisateur.setPrenom(request.getParameter("prenom"));
			utilisateur.setEmail(request.getParameter("email"));
			utilisateur.setTelephone(request.getParameter("telephone"));
			utilisateur.setRue(request.getParameter("rue"));
			utilisateur.setCodePostal(Integer.valueOf(request.getParameter("codePostal")));
			utilisateur.setVille(request.getParameter("ville"));
			utilisateur.setMotDePasse(request.getParameter("mot de passe"));
			utilisateurManager.insertOneUser(utilisateur);
			
			HttpSession session = request.getSession();
			session.setAttribute("profilConnecte", true);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/tests/bonjour.jsp").forward(request, response);
		} catch (ServletException e) {
			request.setAttribute("ErreurInscription", true);
			this.getServletContext().getRequestDispatcher("/WEB-INF/gestionUtilisateurs/inscription.jsp.jsp").forward(request, response);
		}
	}

}

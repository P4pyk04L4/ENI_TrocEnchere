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
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;

@WebServlet("/inscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDAO utilisateurDao = DAOFactory.getUtilisateurDAO();
       
    public ServletInscription() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/gestionUtilisateurs/inscription.jsp");
		HttpSession session = request.getSession();
		session.setAttribute("profilConnecte", false);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        
//        utilisateurDao.insert(utilisateur);
        HttpSession session = request.getSession();
        session.setAttribute("profilConnecte", true);
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/tests/bonjour.jsp").forward(request, response);
	}

}

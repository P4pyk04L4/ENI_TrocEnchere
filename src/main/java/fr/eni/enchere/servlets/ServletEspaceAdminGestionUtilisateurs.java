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

/**
 * Servlet implementation class ServletEspaceAdminGestionUtilisateurs
 */
@WebServlet("/espace_admin/gestion_utilisateurs")
public class ServletEspaceAdminGestionUtilisateurs extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEspaceAdminGestionUtilisateurs() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/espace_admin/gestion_utilisateurs.jsp");
		
		UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
		
		request.setAttribute("utilisateurs", utilisateurManager.getAllUsers());
		
		HttpSession session = request.getSession();
		
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
    	
	    // Récupération du nom du bouton soumis
	    String boutonNom = request.getParameter("buttonClick");

	    if (boutonNom != null) {
	    	
	    	Utilisateur utilisateur = new Utilisateur();
	    	String idUserStr = request.getParameter("idUser");

	    	if (idUserStr != null) {
	    	    try {
	    	        int idUser = Integer.parseInt(idUserStr);
	    	        utilisateur.setIdentifiant(idUser);
	    	    } catch (NumberFormatException e) {
	    	        // Gérer l'exception si la conversion échoue (par exemple, enregistrez l'erreur dans les journaux)
	    	    }
	    	}
	    	
	        // Récupération de la valeur du bouton soumis
	        String boutonValeur = request.getParameter("buttonClick");

	        if ("desactivateUser".equals(boutonValeur)) {
	        	
	        	utilisateurManager.desactivateUser(utilisateur); 	
	        	
	        } else if ("activateUser".equals(boutonValeur)) {
	        	
	        	utilisateurManager.activateUser(utilisateur);
	        	
	        } else if ("deleteUser".equals(boutonValeur)) {
	        	
	        	utilisateurManager.deleteUser(utilisateur);	
	        	
	        }
	    }
	    
		request.setAttribute("utilisateurs", utilisateurManager.getAllUsers());
		
		HttpSession session = request.getSession();
	    this.getServletContext().getRequestDispatcher("/WEB-INF/espace_admin/gestion_utilisateurs.jsp").forward(request, response);
		
	}

}

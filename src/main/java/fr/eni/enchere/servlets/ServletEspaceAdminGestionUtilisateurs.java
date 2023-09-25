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
		
		
        // Définir l'encodage des caractères UTF-8
        request.setCharacterEncoding("UTF-8");
		
    	UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
    	
    	
    	Utilisateur utilisateur = new Utilisateur();
    	
    	String idUserStr = request.getParameter("utilisateurId");
    	if (idUserStr != null) {
    	    try {
    	        int idUser = Integer.parseInt(idUserStr);
    	        utilisateur.setIdentifiant(idUser);
    	    } catch (NumberFormatException e) {
    	        // Gérer l'exception si la conversion échoue (par exemple, enregistrez l'erreur dans les journaux)
    	    }
    	}
	    	
    	String adminSwitchValue = request.getParameter("adminSwitch");
    	String activateSwitchValue = request.getParameter("activateSwitch");
    	String deleteAction = request.getParameter("deleteOneUser");
    	
        if (adminSwitchValue != null) {
        	 if ("true".equals(adminSwitchValue)) {
        		 // La case "adminSwitch" est cochée (ON)
        		 utilisateurManager.activateAdmin(utilisateur);
        	 } else {
        		 // La case "adminSwitch" est décochée (OFF)
        		 utilisateurManager.desactivateAdmin(utilisateur);
        	 }
        	 
        }
        
        if (activateSwitchValue != null) {
        	if ("true".equals(activateSwitchValue)) {
       		 	// La case "activateSwitch" est cochée (ON)
        		utilisateurManager.activateUser(utilisateur);
        	} else {
       		 	// La case "activateSwitch" est décochée (OFF)
        		utilisateurManager.desactivateUser(utilisateur);
       	 	}
       	 
        }	
        	
        if (deleteAction != null) {
        	utilisateurManager.deleteUser(utilisateur);
        }
	    
        
		request.setAttribute("utilisateurs", utilisateurManager.getAllUsers());
		
		HttpSession session = request.getSession();
	    this.getServletContext().getRequestDispatcher("/WEB-INF/espace_admin/gestion_utilisateurs.jsp").forward(request, response);
		
	}

}

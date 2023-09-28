package fr.eni.enchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.EnchereManager;
import fr.eni.enchere.bo.Enchere;

/**
 * Servlet implementation class ServletEspaceAdminGestionEncheres
 */
@WebServlet("/espace_admin/gestion_encheres")
public class ServletEspaceAdminGestionEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEspaceAdminGestionEncheres() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/espace_admin/gestion_encheres.jsp");
		
		ArticleManager articleManager = ArticleManager.getInstance();
		
		request.setAttribute("articles", articleManager.getAllArticles());
		
		HttpSession session = request.getSession();
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        // Définir l'encodage des caractères UTF-8
        request.setCharacterEncoding("UTF-8");
		
        ArticleManager articleManager = ArticleManager.getInstance();
        EnchereManager enchereManager = EnchereManager.getInstance();
    	
        
    	String idEnchereStr = request.getParameter("enchereId");
    	
    	if (idEnchereStr != null) {
    		
    	    try {
    	    	
    	    	Enchere enchere = new Enchere();
    	    	
    	        int idEnchere = Integer.parseInt(idEnchereStr);
    	        enchere.setNoEnchere(idEnchere);
    	        
    	    	String activateSwitchValue = request.getParameter("activateSwitch");
    	    	String deleteOneEnchereAction = request.getParameter("deleteOneEnchere");
    	    	
    	        if (activateSwitchValue != null) {
    	        	if ("true".equals(activateSwitchValue)) {
    	       		 	// La case "activateSwitch" est cochée (ON)
    	        		enchereManager.activateOneEnchere(enchere);
    	        	} else {
    	       		 	// La case "activateSwitch" est décochée (OFF)
    	        		enchereManager.desactivateOneEnchere(enchere);
    	       	 	}
    	       	 
    	        }
    	        
    	        if (deleteOneEnchereAction != null) {
    	        	enchereManager.deleteOneEnchere(enchere);
    	        }
    	    	
    	    } catch (NumberFormatException e) {
    	        // Gérer l'exception si la conversion échoue (par exemple, enregistrez l'erreur dans les journaux)
    	    } catch (Exception e) {	
    	    	// Gérer l'exception si une exception est levée
    	    }
    	    
    	}
    	
		request.setAttribute("articles", articleManager.getAllArticles());
		
		HttpSession session = request.getSession();
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/espace_admin/gestion_encheres.jsp").forward(request, response);
		
	}

}

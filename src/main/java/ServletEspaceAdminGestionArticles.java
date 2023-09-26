

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bo.ArticleVendu;

/**
 * Servlet implementation class ServletEspaceAdminGestionArticles
 */
@WebServlet("/espace_admin/gestion_articles")
public class ServletEspaceAdminGestionArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEspaceAdminGestionArticles() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/espace_admin/gestion_articles.jsp");
		
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
    	
        
    	String idArticleStr = request.getParameter("articleId");
    	
    	if (idArticleStr != null) {
    		
    	    try {
    	    	
    	    	ArticleVendu articleVendu = new ArticleVendu();
    	    	
    	        int idArticle = Integer.parseInt(idArticleStr);
    	        articleVendu.setNoArticle(idArticle);
    	        
    	    	String activateSwitchValue = request.getParameter("activateSwitch");
    	    	String deleteOneArticleAction = request.getParameter("deleteOneArticle");
    	    	
    	        if (activateSwitchValue != null) {
    	        	if ("true".equals(activateSwitchValue)) {
    	       		 	// La case "activateSwitch" est cochée (ON)
    	        		articleManager.activateArticle(articleVendu);
    	        	} else {
    	       		 	// La case "activateSwitch" est décochée (OFF)
    	        		articleManager.desactivateArticle(articleVendu);	
    	       	 	}
    	       	 
    	        }
    	        
    	        if (deleteOneArticleAction != null) {
    	        	articleManager.deleteArticle(articleVendu);
    	        }
    	    	
    	    } catch (NumberFormatException e) {
    	        // Gérer l'exception si la conversion échoue (par exemple, enregistrez l'erreur dans les journaux)
    	    } catch (Exception e) {	
    	    	// Gérer l'exception si une exception est levée
    	    }
    	    
    	}
    	
		request.setAttribute("articles", articleManager.getAllArticles());
		
		HttpSession session = request.getSession();
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/espace_admin/gestion_articles.jsp").forward(request, response);
		
	}

}

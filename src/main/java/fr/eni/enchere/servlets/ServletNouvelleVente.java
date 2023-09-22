package fr.eni.enchere.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;


@WebServlet("/ServletNouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/gestionArticles/nouvelArticle.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		ArticleManager instanceManager = ArticleManager.getInstance();

		String nomArticle = request.getParameter( "nomArticle" );
		String description = request.getParameter( "description" );
		//pour les dates, utiliser DateTimeFormatter et LocalDate.parse
		LocalDate dateDebutEncheres = request.getParameter("dateDebutEncheres");
		LocalDate dateFinEncheres = request.getParameter("dateFinEncheres");
		int miseAPrix = Integer.valueOf( request.getParameter("miseAPrix") ) ;
		int prixVente = miseAPrix;
		/*
		 * RECUPERER LE NUMERO DE CATAGORIE!!!!!!!!!!!!!!!
		 */
		Categorie categorie = new Categorie( request.getParameter("libelleCategorie") );
		Utilisateur utilisateurActif = (Utilisateur) session.getAttribute("user");
		List<Enchere> encheres = new ArrayList<>();
		
		//etatVente sera mis en place dans la bll (car fonction de la date de début des enchères)
		ArticleVendu article = new ArticleVendu( nomArticle, description, null, dateDebutEncheres, dateFinEncheres,
				miseAPrix, prixVente, categorie, utilisateurActif, false, encheres );		

		Retrait retrait = new Retrait( request.getParameter("rue"), request.getParameter("ville"),
										Integer.valueOf( request.getParameter("codePostal") ) );
		
		instanceManager.creerArticle(article, retrait);
		
		//définir où l'utilisaeur est envoyé ensuite (page d'accueil ? page détail vente ?)
	}

}

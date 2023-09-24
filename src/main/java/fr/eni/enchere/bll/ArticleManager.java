package fr.eni.enchere.bll;

import java.time.LocalDate;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.EtatVente;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DAOFactory;

public class ArticleManager {
	
	/**
	 * ***************** Début singleton ***************************
	 */
	
	public static ArticleManager instanceArticleManager;
	
	private ArticleManager() {		
	}
	
	public static ArticleManager getInstance() {
		if ( instanceArticleManager == null ) {
			instanceArticleManager = new ArticleManager();
		}
		return instanceArticleManager;
	}
	
	/**
	 * ***************** Fin singleton ***************************
	 */
	
	private ArticleDAO instanceArticleDAO = DAOFactory.getArticleDAO();
	
	
	//Création d'un article en vente par un utilisateur
	public void creerArticle( ArticleVendu article, Retrait retrait ) {		
		//si la date de début d'enchère est fixée à aujourd'hui, etatVente est à ENCOURS, sinon il est à NONDEBUTEE
		EtatVente etatVente = EtatVente.NON_DEBUTEE;
		if ( article.getDateDebutEncheres().equals(LocalDate.now()) ) {
			etatVente = EtatVente.EN_COURS;
		}
		article.setEtatVente(etatVente);
		
		instanceArticleDAO.creerArticle(article, retrait);
	}
	
	
	
	

}

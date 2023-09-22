package fr.eni.enchere.bll;

import java.time.LocalDate;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.EtatVente;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DAOFactory;

public class ArticleManager {
	
	public static ArticleManager instanceArticleManager;
	
	private ArticleDAO instanceArticleDAO = DAOFactory.getArticleDAO();
	
	private ArticleManager() {		
	}
	
	public static ArticleManager getInstance() {
		if ( instanceArticleManager == null ) {
			instanceArticleManager = new ArticleManager();
		}
		return instanceArticleManager;
	}
	
	
	public void creerArticle( ArticleVendu article, Retrait retrait ) {		
		//si la date de début d'enchère est fixée à aujourd'hui, etatVente est à ENCOURS, sinon il est NONDEBUTEE
		EtatVente etatVente = EtatVente.NON_DEBUTEE;
		if ( article.getDateDebutEncheres().equals(LocalDate.now()) ) {
			etatVente = EtatVente.EN_COURS;
		}
		article.setEtatVente(etatVente);	
		
		instanceArticleDAO.creerArticle(article, retrait);
	}
	
	
	
	

}

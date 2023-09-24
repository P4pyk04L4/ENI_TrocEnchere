package fr.eni.enchere.dal;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Retrait;

public interface ArticleDAO {
	
	public void creerArticle( ArticleVendu article, Retrait retrait );
	
	public void creerPointRetrait( ArticleVendu article, Retrait retrait );

}

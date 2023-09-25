package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;

public interface ArticleDAO {
	
	public void creerArticle( ArticleVendu article, Retrait retrait );
	
	public void creerPointRetrait( ArticleVendu article, Retrait retrait );

	public List<ArticleVendu> getAllArticles();
	
	public ArticleVendu selectById(int noArticle);
}

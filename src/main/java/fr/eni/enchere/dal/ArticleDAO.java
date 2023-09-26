package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Retrait;

public interface ArticleDAO {
	
	public void creerArticle( ArticleVendu article );
	
	public int creerPointRetrait( ArticleVendu article );
	
	public void updateArticle( ArticleVendu article );

	public List<ArticleVendu> getAllArticles();
	
	public ArticleVendu selectById(int noArticle);
	
	public Retrait getRetraitById( int retraitId );
	
	public void deleteArticle( ArticleVendu article );
	
}

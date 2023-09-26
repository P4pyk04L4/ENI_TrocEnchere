/**
 * 
 */
package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Enchere;

public interface EnchereDAO {

	public List<Enchere> afficherListeEnchere(int noArticle);
	
	public void encherir(Enchere enchere);
}

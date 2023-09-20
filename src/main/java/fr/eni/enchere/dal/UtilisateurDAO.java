/**
 * 
 */
package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;

/**
 * @author user
 *
 */
public interface UtilisateurDAO {
	
	public void insert(Utilisateur utilisateur);
	
	public List<Utilisateur> afficherTous();
	
	public Utilisateur connectionUser( String pseudo, String motDePasse );
	
}

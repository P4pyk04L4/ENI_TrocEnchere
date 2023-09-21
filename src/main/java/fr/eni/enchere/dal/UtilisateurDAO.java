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
	
	public void insertOneUser(Utilisateur utilisateur);
	
	public List<Utilisateur> getAllUsers();
	
	public Utilisateur connectionOneUser(String pseudo, String motDePasse);
	
	public void modifActivateUser(Utilisateur utilisateur);
	
	public void deleteOneUser(Utilisateur utilisateur);
	
}

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
	
	public Utilisateur connectionUser(String pseudo, String motDePasse);
	
	public void update(Utilisateur utilisateur, int noUtilisateur);
	
	public Utilisateur selectById(int noIdentifiant);
	
	public void updateMdp(Utilisateur utilisateur, int noUtilisateur);
	
}

package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;

public class UtilisateurManager {
	
	
	/**
	 * *****************  Début singleton ***************************
	 */
	
	private static UtilisateurManager instance;
	
	private UtilisateurManager() {}	
	
	public static UtilisateurManager getInstance() {
		if(instance==null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
	
	/**
	 * *****************  Fin singleton ***************************
	 */	
	
	
	UtilisateurDAO dao = DAOFactory.getUtilisateurDAO();
	

	public List<Utilisateur> getAllUser() {
		
		return dao.afficherTous();
		
	}
	
	public Utilisateur connectionUser( String pseudo, String motDePasse ) {
		
		return dao.connectionUser(pseudo, motDePasse);
		
	}

}

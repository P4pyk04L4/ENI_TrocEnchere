package fr.eni.enchere.bll;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;

public class UtilisateurManager {
	
	UtilisateurDAO dao = DAOFactory.getUtilisateurDAO();
	
	public Utilisateur connectionUser( String pseudo, String motDePasse ) {
		
		return dao.connectionUser(pseudo, motDePasse);
		
	}

}

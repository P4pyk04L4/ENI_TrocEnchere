package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;

public class UtilisateurManager {

	/**
	 * ***************** Début singleton ***************************
	 */

	private static UtilisateurManager instance;

	private UtilisateurManager() {
	}

	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

	/**
	 * ***************** Fin singleton ***************************
	 */

	UtilisateurDAO dao = DAOFactory.getUtilisateurDAO();

	public void insertOneUser(Utilisateur utilisateur) {
		dao.insertOneUser(utilisateur);
	}

	public List<Utilisateur> getAllUsers() {
		return dao.getAllUsers();	
	}

	public Utilisateur connectionUser(String pseudo, String motDePasse) {
		return dao.connectionUser(pseudo, motDePasse);
	}

	public void updateOne(Utilisateur utilisateur, int noUtilisateur) {
		dao.update(utilisateur, noUtilisateur);
	}
	
	public Utilisateur selectById(int noIdentifiant) {
		return dao.selectById(noIdentifiant);
	}
	
	public void updateMdp(Utilisateur utilisateur, int noUtilisateur) {
		dao.updateMdp(utilisateur, noUtilisateur);
	}
	
	public void desactivateUser(Utilisateur utilisateur) {		
		utilisateur.setActivate(false);	
		dao.modifActivateUser(utilisateur);	
	}

	
	public void activateUser(Utilisateur utilisateur) {
		utilisateur.setActivate(true);
		dao.modifActivateUser(utilisateur);
	}
	
	public void deleteUser(Utilisateur utilisateur) {
		dao.deleteOneUser(utilisateur);
	}

}

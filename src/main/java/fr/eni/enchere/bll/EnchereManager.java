/**
 * 
 */
package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.EtatEnchere;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.EnchereDAO;

/**
 * @author user
 *
 */
public class EnchereManager {

	/**
	 * ***************** Début singleton ***************************
	 */
	
	public static EnchereManager instanceEnchereManager;
	
	private EnchereManager() {		
	}
	
	public static EnchereManager getInstance() {
		if ( instanceEnchereManager == null ) {
			instanceEnchereManager = new EnchereManager();
		}
		return instanceEnchereManager;
	}
	
	/**
	 * ***************** Fin singleton ***************************
	 */
	
	private EnchereDAO instanceEnchereDAO = DAOFactory.getEnchereDAO();
	
	public List<Enchere> getAllEncheres() {
		return instanceEnchereDAO.selectAllEnchere();
	}
	
	public List<Enchere> afficherListeEnchere(int noArticle) {
		return instanceEnchereDAO.afficherListeEnchere(noArticle);
	}
	
	public void encherir(Enchere enchere) {
		instanceEnchereDAO.encherir(enchere);
	}
	
	public void updateEnchere(int noEnchere, EtatEnchere etatEnchere) {
		instanceEnchereDAO.updateEnchere(noEnchere, etatEnchere);
	}

	public void deleteOneEnchere(Enchere enchere) {
		instanceEnchereDAO.deleteOneEnchere(enchere);
	}
	
	public void activateOneEnchere(Enchere enchere) {
		enchere.setActivate(true);
		instanceEnchereDAO.updateActivateOneEnchere(enchere);
	}
	
	public void desactivateOneEnchere(Enchere enchere) {
		enchere.setActivate(false);
		instanceEnchereDAO.updateActivateOneEnchere(enchere);
	}
	
}

/**
 * 
 */
package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Enchere;
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
	
	public List<Enchere> afficherListeEnchere(){
		return instanceEnchereDAO.afficherListeEnchere();
	}
	
	public void encherir(Enchere enchere) {
		instanceEnchereDAO.encherir(enchere);
	}
	
}

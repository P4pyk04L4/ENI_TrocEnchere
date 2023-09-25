/**
 * 
 */
package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.EnchereDAO;

/**
 * @author user
 *
 */
public class EnchereDAOJdbcImpl implements EnchereDAO {
	private static final String SELECT_BY_ARTICLE = "SELECT * from bjx3rvrwhdrtsh8g5edx.Enchere WHERE noArticle=?";


	@Override
	public List<Enchere> afficherListeEnchere() {
		List<Enchere> encheres = new ArrayList<Enchere>();

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ARTICLE);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				UtilisateurDAOJdbcImpl daoUtilisateur = new UtilisateurDAOJdbcImpl();
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setIdentifiant(rs.getInt("noUtilisateurVendeur"));
				utilisateur = daoUtilisateur.selectById(utilisateur.getIdentifiant());
				
				ArticleDAOJdbcImpl daoArticle = new ArticleDAOJdbcImpl();
				ArticleVendu article = new ArticleVendu();
				article.setNoArticle(rs.getInt("noArticle"));
				article = daoArticle.selectById(article.getNoArticle());
				
				Enchere enchere = new Enchere(
						rs.getInt("noEnchere"),
						utilisateur,
						rs.getDate("dateEnchere").toLocalDate(),
						rs.getInt("montantEnchere"),
						article,
						rs.getBoolean("activate"));

				encheres.add(enchere);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return encheres;
	}

}

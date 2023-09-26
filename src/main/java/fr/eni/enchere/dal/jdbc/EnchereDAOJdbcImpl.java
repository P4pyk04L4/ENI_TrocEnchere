/**
 * 
 */
package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
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
	private static final String SELECT_BY_ARTICLE = "SELECT * from bjx3rvrwhdrtsh8g5edx.Enchere WHERE noArticle=? ORDER BY montantEnchere DESC";
	private static final String INSERT_ENCHERE = "INSERT INTO bjx3rvrwhdrtsh8g5edx.Enchere (noUtilisateur, noArticle, dateEnchere, montantEnchere, activate) VALUES (?,?,?,?,?)";

	@Override
	public List<Enchere> afficherListeEnchere(int noArticle) {
		List<Enchere> encheres = new ArrayList<Enchere>();

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ARTICLE);
			stmt.setInt(1, noArticle);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
//				UtilisateurDAOJdbcImpl daoUtilisateur = new UtilisateurDAOJdbcImpl();
//				Utilisateur utilisateur = new Utilisateur();
//				utilisateur.setIdentifiant(rs.getInt("noUtilisateur"));
//				utilisateur = daoUtilisateur.selectById(utilisateur.getIdentifiant());
//				
//				ArticleDAOJdbcImpl daoArticle = new ArticleDAOJdbcImpl();
//				ArticleVendu article = new ArticleVendu();
//				article.setNoArticle(rs.getInt("noArticle"));
//				article = daoArticle.selectById(article.getNoArticle());
				
//				Enchere enchere = new Enchere(
//						rs.getInt("noEnchere"),
//						utilisateur,
//						rs.getDate("dateEnchere").toLocalDate(),
//						rs.getInt("montantEnchere"),
//						article,
//						rs.getBoolean("activate"));

				Enchere enchere = new Enchere();
				enchere.setNoEnchere(rs.getInt("noEnchere"));
				enchere.setNoUtilisateur(rs.getInt("noUtilisateur"));
				enchere.setDateEnchere(rs.getDate("dateEnchere").toLocalDate());
				enchere.setMontantEnchere(rs.getInt("montantEnchere"));
				enchere.setNoArticle(rs.getInt("noArticle"));
				enchere.setActivate(rs.getBoolean("activate"));
				
				encheres.add(enchere);
				System.out.println(rs.getInt("noUtilisateur"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return encheres;
	}


	@Override
	public void encherir(Enchere enchere) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, enchere.getUtilisateurAcheteur().getIdentifiant());
			pstmt.setInt(2, enchere.getArticleVendu().getNoArticle());
			pstmt.setDate(3, Date.valueOf(enchere.getDateEnchere()));
			pstmt.setInt(4, enchere.getMontantEnchere());
			pstmt.setBoolean(5, enchere.getActivate());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				enchere.setNoEnchere(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

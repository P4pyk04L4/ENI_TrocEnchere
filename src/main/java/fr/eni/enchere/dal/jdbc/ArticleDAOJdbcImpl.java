package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.ArticleDAO;

public class ArticleDAOJdbcImpl implements ArticleDAO {
	
	
	@Override
	public void creerArticle( ArticleVendu article, Retrait retrait ) {

		//Insertion dans la base de données
		String sql = "INSERT INTO ArticleVendu (nom, description, etatVente, dateDebutEncheres, dateFinEncheres, "
				+ "miseAPrix, prixVente, noCategorie, noUtilisateurVendeur, activate) VALUES (?, ?, ?, ?, ?, ?, "
				+ "?, ?, ?, ?";
		
		try( Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sql) ) {
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setString(3, article.getEtatVente().toString());
			stmt.setDate(4, Date.valueOf( article.getDateDebutEncheres() ));
			stmt.setDate(5, Date.valueOf( article.getDateFinEncheres() ));
			stmt.setInt(6, article.getMiseAPrix());
			stmt.setInt(7, article.getPrixVente());
			stmt.setInt(8, article.getCategorie().getNoCategorie());
			stmt.setInt(9, article.getVendeur().getIdentifiant());
			stmt.setInt(10, 0);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				article.setNoArticle(rs.getInt(1));
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		
		//Une fois que le numéro d'article a été créé, on crée l'adresse du retrait dans la bdd avec le noArticle
		creerPointRetrait( article, retrait );
		
		//on précise le numéro de retrait dans l'article que l'on enregistre ?
		
	}	

	
	/*fonction créant un point de retrait */
	public void creerPointRetrait( ArticleVendu article, Retrait retrait ) {		
		
		String sql = "INSERT INTO Retrait (rue, ville, codePostal, noArticle) VALUES (?, ?, ?, ?)";
				
		try( Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sql) ) {
			stmt.setString(1, retrait.getRue());
			stmt.setString(2, retrait.getVille());
			stmt.setInt(3, retrait.getCodePostal());
			stmt.setInt(4, article.getNoArticle());
			stmt.executeUpdate();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		
	}

}

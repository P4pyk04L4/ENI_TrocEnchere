package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.EtatVente;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.ArticleDAO;

public class ArticleDAOJdbcImpl implements ArticleDAO {
	
	private static final String CREER_ARTICLE = "INSERT INTO ArticleVendu (nom, description, etatVente, dateDebutEncheres,"
			+ " dateFinEncheres, miseAPrix, prixVente, noCategorie, noUtilisateurVendeur, activate) VALUES "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String CREER_POINT_RETRAIT = "INSERT INTO Retrait (rue, ville, codePostal, noArticle) VALUES"
			+ " (?, ?, ?, ?)";
	private static final String SELECT_ALL_ARTICLES = "SELECT * from bjx3rvrwhdrtsh8g5edx.ArticleVendu;";
	private static final String SELECT_ONE_ARTICLE = "SELECT * from bjx3rvrwhdrtsh8g5edx.ArticleVendu WHERE noArticle=?;";
	
	
	@Override
	public void creerArticle( ArticleVendu article, Retrait retrait ) {
		
		try( Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement( CREER_ARTICLE, Statement.RETURN_GENERATED_KEYS ) ) {
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
		
		//Une fois que le numéro d'article a été récupéré, insertion du point de retrait dans la bdd avec le noArticle
		creerPointRetrait( article, retrait );
		
	}	

	
	@Override
	public void creerPointRetrait( ArticleVendu article, Retrait retrait ) {		
				
		try( Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(CREER_POINT_RETRAIT) ) {
			stmt.setString(1, retrait.getRue());
			stmt.setString(2, retrait.getVille());
			stmt.setInt(3, retrait.getCodePostal());
			stmt.setInt(4, article.getNoArticle());
			stmt.executeUpdate();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		System.out.println(article.getNoArticle());
		
	}


	@Override
	public List<ArticleVendu> getAllArticles() {
		List<ArticleVendu> articles = new ArrayList<ArticleVendu>();

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL_ARTICLES);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				ArticleVendu article = new ArticleVendu();
				
				// VERIFIER SI ON UTILISE LES JDBCIMPL OU LES MANAGERS
				
				CategorieDAOJdbcImpl daoCategorieDAOJdbcImpl = new CategorieDAOJdbcImpl();
				Categorie categorie = new Categorie();
				categorie.setNoCategorie(rs.getInt("noCategorie"));
				categorie = daoCategorieDAOJdbcImpl.selectOneCategoryById(categorie.getNoCategorie());
				
				UtilisateurDAOJdbcImpl daoUtilisateur = new UtilisateurDAOJdbcImpl();
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setIdentifiant(rs.getInt("noUtilisateurVendeur"));
				utilisateur = daoUtilisateur.selectById(utilisateur.getIdentifiant());

				article.setNoArticle(rs.getInt("noArticle"));
				article.setNomArticle(rs.getString("nom"));
				article.setDescription(rs.getString("description"));
				article.setEtatVente(EtatVente.valueOf(rs.getString("etatVente")));
				article.setDateDebutEncheres(rs.getDate("dateDebutEncheres").toLocalDate());
				article.setDateFinEncheres(rs.getDate("dateFinEncheres").toLocalDate());
				article.setMiseAPrix(rs.getInt("miseAPrix"));
				article.setPrixVente(rs.getInt("prixVente"));
				article.setCategorie(categorie);
				article.setVendeur(utilisateur);
				article.setActivate(rs.getBoolean("activate"));
				article.setEncheres(null);

				articles.add(article);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return articles;
	}


	@Override
	public ArticleVendu selectById(int noArticle) {
		ArticleVendu article = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_ONE_ARTICLE);
			stmt.setInt(1, noArticle);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				article = new ArticleVendu();
				
				// VERIFIER SI ON UTILISE LES JDBCIMPL OU LES MANAGERS
				
				CategorieDAOJdbcImpl daoCategorieDAOJdbcImpl = new CategorieDAOJdbcImpl();
				Categorie categorie = new Categorie();
				categorie.setNoCategorie(rs.getInt("noCategorie"));
				categorie = daoCategorieDAOJdbcImpl.selectOneCategoryById(categorie.getNoCategorie());
				
				UtilisateurDAOJdbcImpl daoUtilisateur = new UtilisateurDAOJdbcImpl();
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setIdentifiant(rs.getInt("noUtilisateurVendeur"));
				utilisateur = daoUtilisateur.selectById(utilisateur.getIdentifiant());

				article.setNoArticle(rs.getInt("noArticle"));
				article.setNomArticle(rs.getString("nom"));
				article.setDescription(rs.getString("description"));
				article.setEtatVente(EtatVente.valueOf(rs.getString("etatVente")));
				article.setDateDebutEncheres(rs.getDate("dateDebutEncheres").toLocalDate());
				article.setDateFinEncheres(rs.getDate("dateFinEncheres").toLocalDate());
				article.setMiseAPrix(rs.getInt("miseAPrix"));
				article.setPrixVente(rs.getInt("prixVente"));
				article.setCategorie(categorie);
				article.setVendeur(utilisateur);
				article.setActivate(rs.getBoolean("activate"));
				article.setEncheres(null);
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return article;
	}

}

package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.CategorieDAO;

public class CategorieDAOJdbcImpl implements CategorieDAO {
	
	private static final String SELECT_ALL_CATEGORIES = "SELECT * from bjx3rvrwhdrtsh8g5edx.Categorie;";
	private static final String INSERT_ONE_CATEGORY = "INSERT INTO bjx3rvrwhdrtsh8g5edx.Categorie (libelle) VALUES(?);";
	private static final String UPDATE_ONE_CATEGORY = "UPDATE bjx3rvrwhdrtsh8g5edx.Categorie SET libelle=? WHERE noCategorie=?;";
	private static final String DELETE_ONE_CATEGORY = "DELETE FROM bjx3rvrwhdrtsh8g5edx.Categorie WHERE noCategorie=?;";
	
	@Override
	public List<Categorie> selectAllCategories() {
		
		List<Categorie> categories = new ArrayList<>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL_CATEGORIES);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Categorie categorie = new Categorie(
						rs.getInt("noCategorie"),
						rs.getString("libelle")
				);

				categories.add(categorie);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return categories;
		
	}
	
	@Override
	public void insertOneCategory(Categorie categorie) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ONE_CATEGORY);
			
			pstmt.setString(1, categorie.getLibelle());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateOneCategory(Categorie categorie) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_ONE_CATEGORY);
			
			pstmt.setString(1, categorie.getLibelle());
			pstmt.setInt(2, categorie.getNoCategorie());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void deleteOneCategory(Categorie categorie) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_ONE_CATEGORY);
			
			pstmt.setInt(1, categorie.getNoCategorie());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
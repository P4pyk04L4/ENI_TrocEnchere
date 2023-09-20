/**
 * 
 */
package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.UtilisateurDAO;

/**
 * @author user
 *
 */
public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String INSERT = "INSERT INTO bjx3rvrwhdrtsh8g5edx.Utilisateur (pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, administrateur)"
			+ "VALUES(?,?,?,?,?,?,?,?,?,?);";
	private static final String SELECT_ALL = "SELECT * from bjx3rvrwhdrtsh8g5edx.Utilisateur;";
	private static final String SELECT_USER = "SELECT * from bjx3rvrwhdrtsh8g5edx.Utilisateur WHERE pseudo=? AND motDePasse=?";

	@Override
	public void insert(Utilisateur utilisateur) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setInt(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setBoolean(10, utilisateur.getAdministrateur());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				utilisateur.setIdentifiant(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Utilisateur> afficherTous() {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Utilisateur utilisateur = new Utilisateur(rs.getInt("noUtilisateur"),rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("ville"),
						rs.getInt("codePostal"),rs.getInt("credit"), rs.getString("motDePasse") , rs.getBoolean("administrateur"));

				utilisateurs.add(utilisateur);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utilisateurs;
	}
	
	
	@Override
	public Utilisateur connectionUser( String pseudo, String motDePasse ) {
		Utilisateur user = null;
		
		try ( Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(SELECT_USER) ) {
			stmt.setString(1, pseudo);
			stmt.setString(2, motDePasse);
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() ) {
				user = new Utilisateur( rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("ville"),
						rs.getInt("codePostal"), rs.getString("motDePasse") );
			} else {
				user = null;
//				throw new RuntimeException( "Pseudo ou mot de passe incorrect" );
			}
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		return user;
		
	}

}
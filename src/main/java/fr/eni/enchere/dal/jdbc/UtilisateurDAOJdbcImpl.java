/**
 * 
 */
package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.UtilisateurDAO;

/**
 * @author user
 *
 */
public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String INSERT="INSERT INTO be52psif29iysipfk1jl.utilisateurs (nom, prenom, mdp) VALUES(?,?,?);";
	
	@Override
	public void insert(Utilisateur utilisateur) {

        try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, utilisateur.getNom());
			pstmt.setString(2, utilisateur.getPrenom());
			pstmt.setString(3, utilisateur.getMotDePasse());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				utilisateur.setIdentifiant(rs.getInt(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<Utilisateur> afficherTous() {
		System.out.println("Tous les utilisateurs sont affichés.");
		return null;
	}

}

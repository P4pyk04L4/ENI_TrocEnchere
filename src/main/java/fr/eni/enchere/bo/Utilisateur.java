/**
 * 
 */
package fr.eni.enchere.bo;

import java.io.Serializable;

/**
 * @author user
 *
 */
public class Utilisateur implements Serializable{

	private static final long serialVersionUID = 1L;
	private int identifiant;
	private String nom;
	private String prenom;
	private String motDePasse;
	
	//	GETTER ET SETTER
	
	/**
	 * @return the identifiant
	 */
	public int getIdentifiant() {
		return identifiant;
	}
	/**
	 * @param identifiant the identifiant to set
	 */
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prénom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prénom the prénom to set
	 */
	public void setPrenom(String prénom) {
		this.prenom = prénom;
	}
	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	/**
	 * @param identifiant
	 * @param nom
	 * @param prénom
	 * @param motDePasse
	 */
	public Utilisateur(int identifiant, String nom, String prenom, String motDePasse) {
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
	}
	/**
	 * @param nom
	 * @param prénom
	 * @param motDePasse
	 */
	public Utilisateur(String nom, String prenom, String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
	}
	
	public Utilisateur() {
	}
	@Override
	public String toString() {
		return "Utilisateurs [identifiant=" + identifiant + ", nom=" + nom + ", prénom=" + prenom + ", motDePasse="
				+ motDePasse + "]";
	}
	
	
}

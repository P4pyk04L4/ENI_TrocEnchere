/**
 * 
 */
package fr.eni.enchere.bo;

import java.io.Serializable;

/**
 * @author user
 *
 */
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;
	private int identifiant;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String ville;
	private int codePostal;
	private int credit = 0;
	private String motDePasse;
	private Boolean administrateur = false;
	private Boolean activate = false;

	// GETTER ET SETTER

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

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Boolean getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Boolean administrateur) {
		this.administrateur = administrateur;
	}
	
	public Boolean getActivate() {
		return activate;
	}

	public void setActivate(Boolean activate) {
		this.activate = activate;
	}
	
	public Utilisateur() {}

	/**
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param ville
	 * @param codePostal
	 * @param motDePasse
	 */

	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String ville,
			int codePostal, String motDePasse) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.motDePasse = motDePasse;
	}

	/**
	 * @param identifiant
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param ville
	 * @param codePostal
	 * @param credit
	 * @param motDePasse
	 * @param administrateur
	 * @param activate
	 */
	public Utilisateur(int identifiant, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String ville, int codePostal, int credit, String motDePasse, Boolean administrateur, Boolean activate) {
		this.identifiant = identifiant;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.credit = credit;
		this.motDePasse = motDePasse;
		this.administrateur = administrateur;
		this.activate = activate;
	}

	@Override
	public String toString() {
		return "Utilisateur [identifiant=" + identifiant + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", ville=" + ville
				+ ", codePostal=" + codePostal + ", motDePasse=" + motDePasse 
				+ ", administrateur=" + administrateur + ", activate=" + activate
				+ "]";
	}

}

package fr.eni.enchere.bo;

import java.time.LocalDate;

//Classe représentant l'offre faite par un utilisateur pour un article donné
public class Enchere {
	
	private Utilisateur utilisateurAcheteur;
	private LocalDate dateEnchere;
	private int montantEnchere;
	
		public Enchere(Utilisateur utilisateurAcheteur, LocalDate dateEnchere, int montantEnchere) {
		this.setUtilisateurAcheteur(utilisateurAcheteur);
		this.setDateEnchere(dateEnchere);
		this.setMontantEnchere(montantEnchere);
	}
	public Utilisateur getUtilisateurAcheteur() {
		return utilisateurAcheteur;
	}
	public void setUtilisateurAcheteur(Utilisateur utilisateurAcheteur) {
		this.utilisateurAcheteur = utilisateurAcheteur;
	}
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public int getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	
	@Override
	public String toString() {
		return "Enchere [utilisateurAcheteur=" + utilisateurAcheteur + ", dateEnchere=" + dateEnchere
				+ ", montantEnchere=" + montantEnchere + "]";
	}
	
	
}

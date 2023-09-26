package fr.eni.enchere.bo;

import java.time.LocalDate;
import java.util.List;

//Classe définissant un article mis en vente
public class ArticleVendu {
	
	private Integer noArticle;
	private String nomArticle, description;
	private EtatVente etatVente; /*3 valeurs possibles définies dans l'Enumeration EtatVente*/;
	private LocalDate dateDebutEncheres, dateFinEncheres;
	private int miseAPrix, prixVente;
	private Categorie categorie;
	private Utilisateur vendeur;
	private Boolean activate = false;
	private List<Enchere> encheres;
	private Retrait retrait;
	

	public ArticleVendu(Integer noArticle, String nomArticle, String description, EtatVente etatVente,
			LocalDate dateDebutEncheres, LocalDate dateFinEncheres, int miseAPrix, int prixVente,
			Categorie categorie, Utilisateur vendeur, Boolean activate, List<Enchere> encheres, Retrait retrait) {
		this.setNoArticle(noArticle);
		this.setNomArticle(nomArticle);
		this.setDescription(description);
		this.setEtatVente(etatVente);
		this.setDateDebutEncheres(dateDebutEncheres);
		this.setDateFinEncheres(dateFinEncheres);
		this.setMiseAPrix(miseAPrix);
		this.setPrixVente(prixVente);
		this.setCategorie(categorie);
		this.setVendeur(vendeur);
		this.setActivate(activate);
		this.setEncheres(encheres);
		this.setRetrait(retrait);
	}

	
	public ArticleVendu(String nomArticle, String description, EtatVente etatVente,
			LocalDate dateDebutEncheres, LocalDate dateFinEncheres, int miseAPrix, int prixVente,
			Categorie categorie, Utilisateur vendeur, Boolean activate, List<Enchere> encheres, Retrait retrait ) {
		this( null, nomArticle, description, etatVente, dateDebutEncheres, dateFinEncheres, miseAPrix,
				prixVente, categorie, vendeur, activate, encheres, retrait );
	}
	
	public ArticleVendu() {
	}
	
	public Integer getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public EtatVente getEtatVente() {
		return etatVente;
	}
	public void setEtatVente(EtatVente etatVente) {
		this.etatVente = etatVente;
	}
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public int getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public int getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
		public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Utilisateur getVendeur() {
		return vendeur;
	}
	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}
	public Boolean getActivate() {
		return activate;
	}
	public void setActivate(Boolean activate) {
		this.activate = activate;
	}
	public List<Enchere> getEncheres() {
		return encheres;
	}
	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}
	public Retrait getRetrait() {
		return retrait;
	}
	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}


	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", etatVente=" + etatVente + ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres="
				+ dateFinEncheres + ", miseAPrix=" + miseAPrix + ", prixVente=" + prixVente + ", categorie=" + categorie
				+ ", vendeur=" + vendeur + ", activate=" + activate + ", encheres=" + encheres + ", retrait=" + retrait
				+ "]";
	}

				
}

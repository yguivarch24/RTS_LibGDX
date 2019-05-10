package com.mygdx.game.model;

public class Joueur {
	
	/** Le nom du joueur */
	private String pseudo;
	
	// La Stratégie du joueur
	//private Strategie strategie;
	
	/** La 1e ressource et son montant associées au joueur */
	private Ressource nourriture;
	/** La 2e ressource et son montant associées au joueur */
	private Ressource bois;
	/** La 3e ressource et son montant associées au joueur */
	private Ressource or;
	
	/** Constructeur du joueur */
	public Joueur(String pseudo, Ressource nourriture, Ressource bois, Ressource or) {
		this.pseudo = pseudo;
		this.nourriture = nourriture;
		this.bois = bois;
		this.or = or;
	}
	
	/** Retourne le pseudo du joueur */
	public String getPseudo() {
		return this.pseudo;
	}
	
	/** Méthode privée permettant d'obtenir la ressource associée au joueur à partir d'un nom (string)
	 * de ressource. */
	private Ressource Str2Ressource(String nomRes) throws RessourceInvalideException {
		if (nomRes == this.nourriture.getNom()) {
			return this.nourriture;
		} else if (nomRes == this.bois.getNom()) {
			return this.bois;
		} else if (nomRes == this.or.getNom()) {
			return this.or;
		} else {
			throw new RessourceInvalideException("Le joueur ne possède pas cette ressource.");
		}
	}
	
	/** Retourne le montant d'une ressource que le joueur dispose à partir d'un nom (string) de ressource */
	public int getRessources(String nomRes) throws RessourceInvalideException {
		
		return Str2Ressource(nomRes).getRessources();
		
	}
	
	/** Permet d'ajouter une quantité de ressource à une ressource du joueur. */
	public void addRessource(String nomRes, int quantite) throws RessourceInvalideException {
		
		Str2Ressource(nomRes).ajouter(quantite);
		
	}
	
	/** Permet de retirer une quantité de ressource à une ressource du joueur. */
	public void rmRessource(String nomRes, int quantite) throws RessourceInvalideException, RessourceIndisponibleException {

		Str2Ressource(nomRes).retirer(quantite);
		
	}
	

}

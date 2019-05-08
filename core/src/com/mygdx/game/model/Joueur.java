package com.mygdx.game.model;

public class Joueur {
	
	/** Le nom du joueur */
	private String pseudo;
	
	/** La Stratégie du joueur */
	//private Strategie strategie;
	
	/** La 1e ressource et son montant associées au joueur */
	private Ressource nourriture;
	/** La 2e ressource et son montant associées au joueur */
	private Ressource bois;
	/** La 3e ressource et son montant associées au joueur */
	private Ressource or;
	
	public Joueur(String pseudo, Ressource ressource1, Ressource ressource2, Ressource ressource3) {
		this.pseudo = pseudo;
		this.nourriture = ressource1;
		this.bois = ressource2;
		this.or = ressource3;
	}
	
	public String getPseudo() {
		return this.pseudo;
	}
	
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
	
	public int getRessources(String nomRes) throws RessourceInvalideException {
		
		return Str2Ressource(nomRes).getRessources();
		
	}
	
	public void addRessource(String nomRes, int quantite) throws RessourceInvalideException {
		
		Str2Ressource(nomRes).ajouter(quantite);
		
	}
	
	public void rmRessource(String nomRes, int quantite) throws RessourceInvalideException, RessourceIndisponibleException {

		Str2Ressource(nomRes).retirer(quantite);
		
	}
	

}

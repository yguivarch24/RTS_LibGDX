package com.mygdx.game.model;

public class Joueur {
	
	/** Le nom du joueur */
	private String pseudo;
	
	/** La Stratégie du joueur */
	//private Strategie strategie;
	
	/** Les ressources et leur montant associées au joueur */
	private Ressource ressourcesPossedees [];
	
	public Joueur(String pseudo, Ressource ressourcesInitiales []) {
		this.pseudo = pseudo;
		this.ressourcesPossedees = ressourcesInitiales;
	}
	
	public String getPseudo() {
		return this.pseudo;
	}
	
	public int getRessources(Ressource ressource) {
		while (Ressource res : this.ressourcesPossedees) {
			return resgetRessources();
		}
	}

}

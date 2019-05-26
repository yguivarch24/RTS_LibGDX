package com.mygdx.game.model;

/** Classe représentant une ferme, spécialisée dans la création de nourriture */

public class Ferme extends BatimentRessource {

	/** Constructeur d'une ferme, initialise ses statistiques et sa position.
	 * @param x Position en x initial de l'objet
	 * @param y Position en y initial de l'objet
	 * @param carte carte sur laquelle on joue
	 * @param joueur a qui appartient la ferme
	 * @param res ressource que le batiment va collecter
	 * @throws CaseOccupeeException si la case est déjà occupée
	 */
	public Ferme(int x, int y, Carte carte, Joueur joueur, Ressource res) throws CaseOccupeeException {
		super(x,y, carte, "Ferme",joueur,res,100,100,0,20,1000,5,15,20,5);
	}
}


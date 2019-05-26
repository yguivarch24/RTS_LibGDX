package com.mygdx.game.model;

/** Classe représentant une mine, spécialisée dans la création d'or */

public class Mine extends BatimentRessource {
	

	/** Constructeur d'une mine initialise ses statistiques et sa position.
	 * @param x Position en x initial de l'objet
	 * @param y Position en y initial de l'objet
	 * @param carte carte sur laquelle on joue
	 * @param Joueur a qui appartient la mine
	 * @param res ressource que le batiment va collecter
	 */
	public Mine(int x, int y, Carte carte, Joueur joueur, Ressource res) throws CaseOccupeeException {
		super(x,y, carte,"Mine",joueur,res,100,100,0,20,1000,5,20, 5, 15);
	}
}
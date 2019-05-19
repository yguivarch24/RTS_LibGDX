package com.mygdx.game.model;


public class Mine extends BatimentRessource {
	

	/** Constructeur d'une mine initialise ses statistiques et sa position.
	 * 
	 * @param x Position en x initial de l'objet
	 * @param y Position en y initial de l'objet
	 * @param Joueur a qui appartient la mine
*/
	public Mine(int x, int y, Joueur joueur, Ressource res) {
		super(x,y,"Mine",joueur,res,100,100,0,20,0,1000,5,10,15,0);
	}
}

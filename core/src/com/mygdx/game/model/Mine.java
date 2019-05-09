package com.mygdx.game.model;


public class Mine extends Batiment{
	

	/** Constructeur d'une mine initialise ses statistiques et sa position.
	 * 
	 * @param x Position en x initial de l'objet
	 * @param y Position en y initial de l'objet
	 * @param Joueur a qui appartient la mine
*/
	public Mine(int x, int y, Joueur joueur) {
		super(x,y,"Mine",joueur,100,100,0,20,0,15,0);
	}
}

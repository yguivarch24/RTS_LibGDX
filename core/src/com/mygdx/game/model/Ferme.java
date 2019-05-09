package com.mygdx.game.model;

public class Ferme extends Batiment{
	

	/** Constructeur d'une ferme initialise ses statistiques et sa position.
	 * 
	 * @param x Position en x initial de l'objet
	 * @param y Position en y initial de l'objet
	 * @param Joueur a qui appartient la ferme
*/
	public Ferme(int x, int y, Joueur joueur) {
		super(x,y,"Ferme",joueur,100,100,0,20,0,15,0);
	}
}

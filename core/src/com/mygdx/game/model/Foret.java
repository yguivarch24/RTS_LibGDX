package com.mygdx.game.model;

/** Classe représentant la ressource bois. */

public class Foret extends EnvironnementCollectable {
	
	/**Constructeur de la ressource bois qui initialise ses statistiques 
	 * @param x abscisse de la forêt
	 * @param y ordonnée de la forêt
	 */ 
	public Foret(int x, int y) {
		super(x,y,"Forêt", new Bois(10000000));
	}

	
}
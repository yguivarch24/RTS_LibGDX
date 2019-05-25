package com.mygdx.game.model;

/** Classe représentant la ressource or. */

public class GisementOr extends EnvironnementCollectable {
	
	/**Constructeur de la ressource or qui initialise ses statistiques 
	 * @param x abscisse de l'or
	 * @param y ordonnée de l'or
	 */ 
	public GisementOr(int x, int y) {
		super(x,y,"Gisement d'or", new Or(10000000));
	}

}

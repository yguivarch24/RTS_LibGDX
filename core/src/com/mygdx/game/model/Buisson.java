package com.mygdx.game.model;

/** Classe représentant la ressource nourriture. */

public class Buisson extends EnvironnementCollectable {

	/**Constructeur de la ressource nourriture qui initialise ses statistiques 
	 * @param initQuantite quantite initiale de ressource 
	 */ 
	public Buisson(int x, int y) {
		super(x,y,"Buisson", new Nourriture(10000000));
	}
}

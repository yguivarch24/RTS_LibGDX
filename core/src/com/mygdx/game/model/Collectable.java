package com.mygdx.game.model;

public interface Collectable {
	
	/** Collecter une certaine quantité de ressource */
	public int collecter(int valeuraprendre, Ressource ressource);
}

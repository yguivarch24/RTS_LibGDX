package com.mygdx.game.model;

public abstract class Environnement extends  GameObject implements ComposantCarte {

	/** Le LiveObject de la case */
	LiveObject object;

	public Environnement(int x, int y, String name, LiveObject object) {
		super(x, y, name);
		this.object = object;
	}

	public Environnement(int x, int y, String name) {
		super(x, y, name);
		this.object = null;
	}

	/** Obtenir l'état d'une case pour les LiveObject (occupée/vide) */
	public boolean estOccupee(){
		if (this.object == null){
			return false;
		} else {
			return true;
		}
	}
}

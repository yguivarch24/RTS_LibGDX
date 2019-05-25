package com.mygdx.game.model;

public abstract class Environnement extends  GameObject implements ComposantCarte {

	/** Le LiveObject de la case */
	private LiveObject object;

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
	
	/** Définir un LiveObject sur ce composant de carte */
	public void setLiveObject(LiveObject object) {
		this.object = object;
	}
	
	/** Retourne le LiveObject sur l'environnement */
	public LiveObject getLiveObject() {
		return this.object;
	}
	
	public int getX() {
		return getX();
	}
	
	public int getY() {
		return getY();
	}
}

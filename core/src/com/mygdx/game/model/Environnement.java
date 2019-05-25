package com.mygdx.game.model;

public abstract class Environnement extends  GameObject implements ComposantCarte {

	/** Le LiveObject de la case */
	private LiveObject object;
	
	/** Constructeur d'un environnement à partir de ses caractéristique
	 * @param x abscisse de la case sur laquelle on souhaite créer une ressource
	 * @param y ordonnée de la case sur laquelle on souhaite créer une ressource
	 * @param name nom de l'environnement à créer
	 * @param object objet sur la case
	 */
	public Environnement(int x, int y, String name, LiveObject object) {
		super(x, y, name);
		this.object = object;
	}

	/** Constructeur d'un environnement à partir de ses caractéristique
	 * @param x abscisse de la case sur laquelle on souhaite créer une ressource
	 * @param y ordonnée de la case sur laquelle on souhaite créer une ressource
	 * @param name nom de l'environnement à créer
	 */
	public Environnement(int x, int y, String name) {
		super(x, y, name);
		this.object = null;
	}

	/** Obtenir l'état d'une case pour les LiveObject 
	 * @return True si la case est occupée, False sinon
	 */
	public boolean estOccupee(){
		if (this.object == null){
			return false;
		} else {
			return true;
		}
	}
	
	/** Définir un LiveObject sur ce composant de carte 
	 * @param object le liveobject à définir
	 */
	public void setLiveObject(LiveObject object) {
		this.object = object;
	}
	
	/** Retourne le LiveObject de l'environnement
	  * @return le liveobject
	  */
	public LiveObject getLiveObject() {
		return this.object;
	}
	
	/** Retourne l'abscisse de l'environnement
	  * @return abscisse de l'environnement
	  */
	public int getX() {
		return super.getX();
	}
	
	/** Retourne l'ordonnée de l'environnement
	  * @return ordonnée de l'environnement
	  */
	public int getY() {
		return super.getY(); 
	}
}

package com.mygdx.game.model;

/** Classe représentant les GameObject.
 * Représente tous les objects présents dans notre jeu.
 */
abstract public class GameObject {
	
	/** La coordonnée en abscisse de l'objet*/
	protected int x;
	/** La coordonnée en ordonnée de l'objet*/
	protected int y;
	/** Le nom de l'objet*/
	private String name;
	
	/** Construire un objet du jeu à partir de ses coordonnées (x,y) et de son nom.
	 * @param x abscisse
	 * @param y ordonnée
	 * @param name nom de l'objet
	 */
	public GameObject(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	/** Obtenir l'abscisse x de l'objet.
	 * @return abscisse x de l'objet
	 */
	public int getX() {
		return this.x;
	}
	
	/** Obtenir l'ordonnée y de l'objet.
	 * @return ordonnée y de l'objet
	 */
	public int getY() {
		return this.y;
	}
	
	/** Changer l'abscisse x de l'objet.
	  * @param x nouvelle abscisse
	  */
	public void setX(int x) {
		this.x = x;
	}
	
	/** Changer l'ordonnée y de l'objet.
	  * @param y nouvelle ordonnée
	  */
	public void setY(int y) {
		this.y = y;
	}
	
	/**Obtenir le nom de l'objet
	 * @return nom nomObjet
	 */
	public String getName() {
		return this.name;
	}

	
}

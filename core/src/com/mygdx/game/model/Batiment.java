package com.mygdx.game.model;

abstract public class Batiment extends LiveObject {
	
	
	/** Constructeur d'un batiment initialise ses statistiques et sa position.
	 * 
	 * @param x Position en x initial de l'objet
	 * @param y Position en y initial de l'objet
	 * @param name Nom de l'objet
	 * @paraù joueur joueur a qui appartient le batiment
	 * @param vieMax Statistique de vie max
	 * @param vie Vie que l'objet a initialement
	 * @param attaque Statistique inital d'attaque de l'objet
	 * @param defense Statistique  inital de défense de l'objet
	 * @param portee Statistique initial de portée d'effet de l'objet
	 */
	public Batiment(int x, int y, String name, Joueur joueur, int vieMax, int vie, int attaque, int defense, int portee) {
		super(x, y, name, joueur, vieMax, vie, attaque, defense, portee);
	}

}
package com.mygdx.game.model;

/** Décrit les batiments spécialisé dans la récolte de ressources (mine, scierie ...) */

public class BatimentRessource extends Batiment {
	
	/** quantité de ressource que possède le batiment.	 */
	private Ressource ressource;
	/** quantité de ressource que produit le batiment par tour.	 */
	private int productionParTour;
	
	/** Constructeur d'un batiment de ressource initialise ses statistiques et sa position.
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
	public BatimentRessource(int x, int y, String name, Joueur joueur, int vieMax, int vie, int attaque, int defense, int portee, int nbderessourceinitial, int productionparTour) {
		super(x, y, name, joueur, vieMax, vie, attaque, defense, portee);
		this.ressource = new Ressource(nbderessourceinitial);
		this.productionParTour = productionparTour;
	}
	
	public int getProduction() {
		return productionParTour;
	}
	/*
	public void batimentGainRessource(){
		this.ressource.ajouter(productionParTour);
		//TODO Retirer ressource à l'environnement
	}
	
	public void joueurRecupere() {
		//TODO Ajouter toutes les ressources contenues dans le bâtiment au joueur possédant le bâtiment
		//TODO Retirer toutes les ressources contenues dans le bâtiment
	}
	
	/*static public Batiment construire(int x, int y, String name, int vieMax, int vie, int attaque, int defense, int portee, int nbderessourceinitial, int productionparTour) {
		// Enlever les ressources au joueur
		return Batiment(x, y, name, vieMax, vie, attaque, defense, portee, nbderessourceinitial, productionparTour);
	}*/	
}

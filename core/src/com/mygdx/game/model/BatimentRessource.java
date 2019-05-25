package com.mygdx.game.model;

/** Décrit les batiments spécialisé dans la récolte de ressources (mine, scierie, ferme , hotel de ville et caserne) */

public class BatimentRessource extends Batiment {

	/** quantité de ressource que possède le batiment.	 */
	private Ressource ressource;
	/** quantité de ressource que produit le batiment par tour.	 */
	private int productionParTour;

	/** Constructeur d'un batiment de ressource initialise ses statistiques et sa position.	 * 
	 * @param x Position en x initial de l'objet
	 * @param y Position en y initial de l'objet
	 * @param name Nom de l'objet
	 * @param joueur joueur a qui appartient le batiment
	 * @param res ressource que le batiment va collecter. (or, nourriture, bois...)
	 * @param vieMax Statistique de vie max
	 * @param vie Vie que l'objet a initialement
	 * @param attaque Statistique inital d'attaque de l'objet
	 * @param defense Statistique  inital de défense de l'objet
	 * @param portee Statistique initial de portée d'effet de l'objet
	 * @param productionparTour quantité de production à chaque tour
	 * @param or coût en or de l'oject
	 * @param bois coût en bois de l'objet
	 * @param nourriture coût en nourriture de l'objet
	 */
	public BatimentRessource(int x, int y, Carte carte, String name, Joueur joueur, Ressource res, int vieMax, int vie, int attaque, 
			int defense, int portee, int productionparTour, int or, int bois, int nourriture) throws CaseOccupeeException {
		super(x, y, carte, name, joueur, vieMax, vie, attaque, defense, portee, or, bois, nourriture);
		this.ressource = res;
		this.productionParTour = productionparTour;
	}

	public int getProduction() {
		return productionParTour;
	}

	public int getRessource() {
		return this.ressource.getRessources();
	}
}

package com.mygdx.game.model;

/** Classe représentant le batiment scierie, spécialisé dans la collecte de bois */
public class Scierie extends BatimentRessource {

	/** Constructeur d'une ferme initialise ses statistiques et sa position.
	 * @param x Position en x initial de l'objet
	 * @param y Position en y initial de l'objet
	 * @param carte la carte sur laquelle on joue
	 * @param Joueur a qui appartient la ferme
	 * @param res la ressource à collecter
	 */
	public Scierie(int x, int y, Carte carte, Joueur joueur, Ressource res) throws CaseOccupeeException {
		super(x,y, carte, "Scierie",joueur,res,100,100,0,20,1000,5,5, 15, 20);
	}
}


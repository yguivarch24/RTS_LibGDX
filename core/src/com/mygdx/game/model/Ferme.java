package com.mygdx.game.model;

public class Ferme extends BatimentRessource {
	

	/** Constructeur d'une ferme initialise ses statistiques et sa position.
	 * 
	 * @param x Position en x initial de l'objet
	 * @param y Position en y initial de l'objet
	 * @param Joueur a qui appartient la ferme
*/
	public Ferme(int x, int y, Carte carte, Joueur joueur, Ressource res) throws CaseOccupeeException {
		super(x,y, carte, "Ferme",joueur,res,100,100,0,20,1000,5,10,15,0);
	}
}

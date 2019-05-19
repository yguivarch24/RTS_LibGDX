package com.mygdx.game.model;

public class HotelDeVille extends Batiment {


	/** Constructeur d'un hotel de ville initialise ses statistiques et sa position.
	 * @param x Position en x initial de l'objet
	 * @param y Position en y initial de l'objet
	 * @param Joueur a qui appartient l'hotel de ville
	*/
	public HotelDeVille(int x, int y, Carte carte, Joueur joueur) throws CaseOccupeeException {
			super(x,y, carte, "Hotel de ville",joueur,1000,1000,0,20,0,0,0,0);
	}

}

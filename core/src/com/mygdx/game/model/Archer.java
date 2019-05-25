package com.mygdx.game.model;

/** Classe représentant un archer.
 * Un archer est un soldat posédant de la portée pour attaquer
 */
public class Archer extends Unite {
	
	/** Constructeur d'un archer, initialise ses statistiques et sa position.
	 * @param x coordonnée en abscisse de l'objet
	 * @param y coordonée en ordonnée de l'objet
	 * @param carte carte sur laquelle on joue
	 * @param joueur joueur qui possède l'objet
	 */
    public Archer(int x, int y, Carte carte, Joueur joueur) throws CaseOccupeeException {
        super(x, y, carte, "Archer", joueur, 7, 7, 1, 3, 1, 5, 4, 4, 5, 0, 5);
    }
}

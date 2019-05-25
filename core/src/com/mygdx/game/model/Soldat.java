package com.mygdx.game.model;

/** Classe représentant l'unité soldat */

public class Soldat extends Unite {

	/** Constructeur d'un soldat en fonction de ses caractéristiques
	 * @param x abscisse du soldat
	 * @param y ordonnée du soldat
	 * @param carte la carte sur laquelle on joue
	 * @param joueur le joueur qui possède le soldat
	 * @throws CaseOccupeeException si la case est déjà utilisée
	 */
    public Soldat(int x, int y, Carte carte, Joueur joueur) throws CaseOccupeeException {
        super(x, y, carte, "Soldat", joueur, 8, 8, 2, 4, 2, 1, 5, 5, 4, 0, 6);
    }
}

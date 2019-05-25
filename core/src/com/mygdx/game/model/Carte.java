package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

/** Classe représentant la carte du jeu sous forme de tableau.
 * Contient toutes les informations de la partie sur la carte. */

public class Carte {
	
	/** La taille de la carte */
	private int taille;
	/** La grille de la carte */
	private ComposantCarte grille [] [];

	/**Constructeur de la classe 
	 * @param n taille de la carte souhaitée
	 */
	public Carte(int n) {
		taille = n;
		grille = new ComposantCarte [n] [n];
	}
	
	/** Fonction qui retourne l'état d'une case
	 * @param x abscisse de la case
	 * @param y ordonnée de la case
	 * @return True si la carte est occupée, False sinon
	 */
	public boolean estOccupee(int x, int y) {
		return this.grille[x][y].estOccupee();
	}

	/** Obtenir la taille de la carte
	 * @return la taille de la carte
	 */
	public int getTaille() {
		return taille;
	}

	/** Obtenir la grille de la carte
	 * @return la grille de la carte
	 */
	public ComposantCarte[][] getGrille() {
		return grille;
	}
	
	/** Obtenir la Composante de la carte à une certaine position
	 * @param x abscisse de la composante qu'on veut
	 * @param y ordonnée de la composante qu'on veut
	 * @return la composante de la carte souhaitée
	 */
	public ComposantCarte getComposantCarte(int x, int y) {
		return this.grille[x][y];
	}
	
	/** Obtenir le LiveObject de la carte à une certaine position
	 * @param x abscisse du liveObject qu'on veut
	 * @param y ordonnée du liveObject qu'on veut
	 * @return la composante de la carte souhaitée
	 */
	public LiveObject getLiveObject(int x, int y) {
		return this.grille[x][y].getLiveObject();
	}

	/** Modifier la Composante de la carte à une certaine position
	 * @param x abscisse de la composante qu'on veut modifier
	 * @param y ordonnée de la composante qu'on veut modifier
	 * @param c la nouvelle composante
	 */
	public void setComposant(int x, int y, ComposantCarte c) {
		grille[x][y] = c;
	}
	
	/** Mettre un LiveObject sur une case
	 * @param x abscisse de la case
	 * @param y ordonnée de la case
	 * @param object LiveObject a ajouter à la case
	 * @throws CaseOccupeeException si la case est déjà occupée
	 */
	public void setLiveObject(int x, int y, LiveObject object) throws CaseOccupeeException {
		if (this.estOccupee(x,y)) {
			throw new CaseOccupeeException("Error setLiveObject de Carte : il y a déjà un LiveObject sur cette case");
		}
		this.grille[x][y].setLiveObject(object);
	}
	
}

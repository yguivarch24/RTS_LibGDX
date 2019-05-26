package com.mygdx.game.model;
import java.util.List;
import java.util.Observable;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/** Classe représentant une partie du jeu */

public class Partie {
	
	/** Nombre de joueurs dans la partie */ 
	private int nbJoueur;	
	
	/** Liste des joueurs dans la partie */ 
	private List<Joueur> listeJoueurs;
	
	/** Index du joueur courant dans la liste. */
	private int indexJoueurCourant;
	
	/** Joueur courant dont c'est le tour de jouer. */
	private Joueur joueurCourant;
	
	/** Carte de la partie */
	private Carte carte;
	
	/** Numéro du tour de jeu courant */
	private int nbTour;
	
	
	/** Cosntructuer de la partie. Initialise le nombre de joueurs et la lsite de joueurs.
	 * @param nbJ Nombre de joueurs de la partie.
	 * @param tailleCarte la taille de la carte
	 */
	public Partie(int nbJ, int tailleCarte) {
		nbJoueur = nbJ;
		listeJoueurs = new ArrayList<>(nbJ);
		carte = new Carte(tailleCarte);
		indexJoueurCourant = 0;
		nbTour = 1;
	}
	
	/** Permet d'initialiser la partie : hdv de chaque joueur. */
	public void initPartie() {
		/* Pour le moment on n'aura que 2 joueur, un bleu et rouge */
		Joueur j1 = new Joueur("joueur1", Color.blue);
		Joueur j2 = new Joueur("joueur2", Color.red);
		this.ajouterJoueur(j1);
		this.ajouterJoueur(j2);
		this.joueurCourant = j1;
		try {
			HotelDeVille hdv1 = new HotelDeVille(41,38, carte, j1);
			j1.ajouterBatiment(hdv1);
			HotelDeVille hdv2 = new HotelDeVille(7,8, carte, j2);
			j2.ajouterBatiment(hdv2);
			Caserne caserne1 = new Caserne(39,36, carte, j1);
			j1.ajouterBatiment(caserne1);
			Caserne caserne2 = new Caserne(9,10, carte, j2);
			j2.ajouterBatiment(caserne2);
			
		}catch(CaseOccupeeException e1) {
			System.out.println("Pas de place pour l'HDV \n");
		} 
	}
	
	/** Permet d'ajouter un joueur à la partie. 
	 * (Normalement uniquement utilisé lors de la création de la partie)
	 * @param newJoueur Le joueur à ajouter à la partie.
	 */
	public void ajouterJoueur(Joueur newJoueur) {
		listeJoueurs.add(newJoueur);
	}
	
	/** Permet de définir quel joueur doit jouer. Le tour des joueurs suit un ordre définit
	 * lors de la création de la partie par les joueurs.
	 */
	public void joueurSuivant() {
		if(indexJoueurCourant >= nbJoueur) {
			indexJoueurCourant = 0;
			nbTour ++;
		} else { indexJoueurCourant ++;}
		joueurCourant = listeJoueurs.get(indexJoueurCourant);
	}
	
	/** Permet d'obtenir le joueur courant. 
	 * @return le joueur courant
	 */
	public Joueur getJoueur() {
		return joueurCourant;
	}
	
	/** Permet d'obtenir la liste de joueurs 
	 * @return la liste des joueurs
	 */
	public List<Joueur> getJoueurs() {
		return listeJoueurs;
	}
	
	/** Permet d'obtenir le numéro de tour de jeu courant.
	 * @return le numéro de tour. 
	 */
	public int getNbTour() {
		return nbTour;
	}
	
	/** Obtenir la carte
	 * @return la carte
	 */
	public Carte getCarte() {
		return carte;
	}
	
	/** Changer la carte 
	 * @param la nouvelle carte carte
	 */
	public void setCarte(Carte c) {
		this.carte = c;
	}
	
}

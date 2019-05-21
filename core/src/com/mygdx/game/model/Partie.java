package com.mygdx.game.model;
import java.util.List;
import java.util.Observable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Partie {
	
	/** Nombre de joueurs dans la partie */ 
	private int nbJoueur;
	
	/** Liste des joueurs dans la partie */ 
	private List<Joueur> listeJoueurs;
	
	/** N° D'index du joueur courant dans la liste. */
	private int indexJoueurCourant;
	/** Joueur courant dont c'est le tour de jouer. */
	private Joueur joueurCourant;
	
	/** Carte de la partie */
	private Carte carte;
	
	/** Numéro du tour de jeu courant */
	private int nbTour;
	
	
	/** Cosntructuer de la partie. Initialise le nombre de joueurs et la lsite de joueurs.
	 * 
	 * @param nbJ Nombre de joueurs de la partie.
	 */
	public Partie(int nbJ) {
		nbJoueur = nbJ;
		listeJoueurs = new ArrayList(nbJ);
		carte = new Carte(50); 
		indexJoueurCourant = 1;
		nbTour = 1;
	}
	
	public void tourDeJeu() {
		
	}
	
	/** Permet d'initialiser la partie : hdv de chaque joueur. */
	public void initPartie() {
		listeJoueurs.forEach(j -> {
			// Création de l'hotel de ville
			try {
				HotelDeVille hdv = new HotelDeVille(1,2, carte, j);
				j.ajouterBatiment(hdv);
			} catch (CaseOccupeeException e1) {
				System.out.println("Pas de place pour l'HDV \n");
			}
		});
	}
	
	/** Permet d'ajouter un joueur à la partie. (Normalement uniquement utiliser lors de la création de la partie)
	 * 
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
			indexJoueurCourant = 1;
			nbTour ++;
		} else { indexJoueurCourant ++;}
	}
	
	/** Permet d'obtenir le joueur courant. 
	 * @return Le joueur courant
	 * */
	public Joueur getJoueur() {
		return joueurCourant;
	}
	
	/** Permet d'obtenir le numéro de tour de jeu courant.
	 * @return le numéro de tour. 
	 *  */
	public int getNbTour() {
		return nbTour;
	}
	
	/** Getter de la carte */
	public Carte getCarte() {
		return carte;
	}
	
}

package com.mygdx.game.model;

/** Classe représentant une caserne, specialisée dans la création d'archers et de soldats */

public class Caserne extends Batiment {

	/** Tableau des coordonnées relatives à la caserne,
	 * c'est à dire, les coordonnées de l'ensemble des cases entourant la caserne. */
	final static int contourBat[] = {1,0,0,1,0,1,-1,0,-1,0,0,-1,0,-1};
	
	/** Constructeur de la classe, initialisant les parmètres d'une caserne	 * 
	 * @param x abscisse de la caserne
	 * @param y ordonnée de la caserne
	 * @param carte carte sur laquelle on joue
	 * @param joueur joeur qui possède l'objet
	 * @throws CaseOccupeeException si la case est déjà occupée
	 */
	public Caserne(int x, int y, Carte carte, Joueur joueur) throws CaseOccupeeException {
		super(x, y, carte, "Caserne", joueur, 50, 50, 0, 
				1, 0, 15, 15, 5);
	}

	/** Permet aux casernes de créer des unités.	 * 
	 * @param typeUnite indique le type d'unité à créer.ex : "Soldat", "Archer"...
	 * @param carte la carte sur laquelle on joue
	 * @param joueurCourant le joueur dont c'est le tour
	 * @throws CaseOccupeeException si la case est déjà occupée
	 */
	public void creerUnite(String typeUnite, Carte carte, Joueur joueurCourant) throws CaseOccupeeException {
		int xCourant = this.x;
		int yCourant = this.y-1; // On commence à la case en dessou de la caserne.
		int i = 0;
		Unite unite;		
		/* Tant que la case autour de la caserne est occupée, on contourne le batiment.
		 * Si toutes les cases sont occupées, on remonte une caseOccupeeExeption*/
		while(carte.estOccupee(xCourant, yCourant)) {
			xCourant += contourBat[i];
			yCourant += contourBat[i+1];
			i += 2;
			if(i >= 14)
			{
				throw new CaseOccupeeException("Caserne encerclée");
			}
		}		
		switch(typeUnite) {
		case "Soldat" : 
			unite = new Soldat(xCourant, yCourant, carte, joueurCourant);
			break;
		case "Archer" :
			unite = new Archer(xCourant, yCourant, carte, joueurCourant);
			break;
		default : // On mettra par d�faut un soldat
			unite = new Soldat(xCourant, yCourant, carte, joueurCourant);
			break;
		}	
		joueurCourant.ajouterTroupe(unite);
		carte.setLiveObject(xCourant, yCourant, unite);
	}
}

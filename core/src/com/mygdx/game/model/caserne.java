package com.mygdx.game.model;

public class caserne extends Batiment {

	/** Tableau des coorodonnées relatives autout d'un batiment */
	final static int contourBat[] = {0,-1,1,-1,1,0,1,1,0,1,-1,1,-1,1,0,-1,-1};
	
	public caserne(int x, int y, Carte carte, Joueur joueur) throws CaseOccupeeException {
		super(x, y, carte, "Caserne", joueur, 50, 50, 0, 
				1, 0, 15, 15, 5);
	}

	/** Permet aux casernes de créer des unités. 
	 * 
	 * @param typeUnite Permet d'indiquer le type d'unité à créer.ex : "Soldat", "Archer"...
	 * 
	 */
	public creerUnite(String typeUnite, Carte carte) {
		int xCourant = 0;
		int yCourant = 1;
		int i = 0;
		boolean occupe = false;
		Unite unite;
		
		do {
			try {
				switch(typeUnite) {
				case "Soldat" : 
					unite = new Soldat(xCourant, yCourant, joueurCourant);
					joueurCourant.ajouterTroupe(unite);
					carte.setLiveObject(unite);
					break;
				case "Archer" :
					
					break;
				}
			}
			
		while(estOccupe);
			
		carte.setLiveObject(unite);
	}
}

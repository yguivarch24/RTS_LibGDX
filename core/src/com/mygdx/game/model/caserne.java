package com.mygdx.game.model;

public class caserne extends Batiment {

	/** Tableau des coorodonn�es relatives permettant de faire le toru d'un batiment d'un batiment */
	final static int contourBat[] = {1,0,0,1,0,1,-1,0,-1,0,0,-1,0,-1};
	
	public caserne(int x, int y, Carte carte, Joueur joueur) throws CaseOccupeeException {
		super(x, y, carte, "Caserne", joueur, 50, 50, 0, 
				1, 0, 15, 15, 5);
	}

	/** Permet aux casernes de cr�er des unit�s. 
	 * 
	 * @param typeUnite Permet d'indiquer le type d'unit� � cr�er.ex : "Soldat", "Archer"...
	 * 
	 */
	public void creerUnite(String typeUnite, Carte carte, Joueur joueurCourant) throws CaseOccupeeException {
		int xCourant = this.x;
		int yCourant = this.y-1; // On commecne � la case en dessosu de la caserne.
		int i = 0;
		Unite unite;
		
		/* Tant que la case autour de la caserne est occup�, on contourne le batiment.
		 * Si totues les cases sont occup�s, on remonte une caseOccupeeExeption*/
		while(carte.estOccupee(xCourant, yCourant)) {
			xCourant += contourBat[i];
			yCourant += contourBat[i+1];
			i += 2;
			if(i >= 14)
			{
				throw new CaseOccupeeException("Caserne encercl�e");
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

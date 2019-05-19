package com.mygdx.game.model;

public class Archer extends Unite {
	
    public Archer(int x, int y, Carte carte, Joueur joueur) throws CaseOccupeeException {
        super(x, y, carte, "Archer", joueur, 7, 7, 1, 3, 1, 5, 4, 4, 5, 0, 5);
    }

}

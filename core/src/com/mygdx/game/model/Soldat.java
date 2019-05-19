package com.mygdx.game.model;

public class Soldat extends Unite {

    public Soldat(int x, int y, Carte carte, Joueur joueur) throws CaseOccupeeException {
        super(x, y, carte, "Soldat", joueur, 8, 8, 2, 4, 2, 1, 5, 5, 4, 0, 6);
    }
}

package com.mygdx.game.model;

public class Soldat extends Unite {

    public Soldat(int x, int y, Joueur joueur, int vieMax, int vie, int attaque, int defense, int portee, int nbDeplacementMax, int nbDeplacementRestant) {
        super(x, y, "Soldat", joueur, vieMax, vie, attaque, defense, portee, nbDeplacementMax, nbDeplacementRestant);
    }
}

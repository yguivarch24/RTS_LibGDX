package com.mygdx.game.model;

public class Soldat extends Unite {

    public Soldat(int x, int y, int vieMax, int vie, int attaque, int defense, int portee, int nbDeplacementMax, int nbDeplacementRestant) {
        super(x, y, "Soldat", vieMax, vie, attaque, defense, portee, nbDeplacementMax, nbDeplacementRestant);
    }
}

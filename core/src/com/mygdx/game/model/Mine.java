package com.mygdx.game.model;

public class Mine extends Batiment {

	public Mine(int x, int y, String name, Joueur joueur, int vieMax, int vie, int attaque, int defense, int portee, int nbderessourceinitial, int productionparTour) {
		super(x, y, name, joueur, 25, 40, 0, 1, 0, nbderessourceinitial, 5);
	}
}

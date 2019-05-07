package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Carte {
	
	/**la taille de la carte */
	int taille;
	ComposantCarte grille [] [];
	List<LiveObject> liveObjectList;


	public Carte(int n) {
		taille = n;
		grille = new ComposantCarte [n] [n];
		liveObjectList = new ArrayList<LiveObject>();
	}

	public void dessinerCarte(SpriteBatch batch, Camera camera) {

	}

	public int getTaille() {
		return taille;
	}

	public ComposantCarte[][] getGrille() {
		return grille;
	}
}

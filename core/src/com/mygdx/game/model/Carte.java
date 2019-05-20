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
	
	public ComposantCarte getComposantCarte(int x, int y) {
		return this.grille[x][y];
	}
	
	public LiveObject getLiveObject(int x, int y) {
		return this.grille[x][y].getLiveObject();
	}
	
	public boolean estOccupee(int x, int y) {
		return this.grille[x][y].estOccupee();
	}
	
	public void setLiveObject(int x, int y, LiveObject object) throws CaseOccupeeException {
		if (this.estOccupee(x,y)) {
			throw new CaseOccupeeException("Error setLiveObject de Carte : il y a déjà un LiveObject sur cette case");
		}
		this.grille[x][y].setLiveObject(object);
	}
	
}

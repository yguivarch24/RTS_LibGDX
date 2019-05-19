package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface ComposantCarte {

	final int TILESize = 64;

	/** Obtenir l'état d'une case pour les LiveObject (occupée/vide) */
	public boolean estOccupee();

	/** Actions qui pourront être effectué sur cette carte*/
	public boolean action();

}

package com.mygdx.game.model;

/** Exception qui indique l'accès à une case déjà occupée. */

public class CaseOccupeeException extends Exception {

	/** Initaliser une CaseOccupeeException avec le message précisé.
	  * @param message le message explicatif
	  */
	public CaseOccupeeException(String message) {
		super(message);
	}
}

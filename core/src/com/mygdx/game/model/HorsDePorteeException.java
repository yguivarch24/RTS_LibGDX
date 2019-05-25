package com.mygdx.game.model;

/** Exception qui indique l'accès à une unité hors de portée. */

public class HorsDePorteeException extends Exception {

	/** Initaliser une HorsDePorteeException avec le message précisé.
	  * @param message le message explicatif
	  */
	public HorsDePorteeException(String message) {
		super(message);
	}
}


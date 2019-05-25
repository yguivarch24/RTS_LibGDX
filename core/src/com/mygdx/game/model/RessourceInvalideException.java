package com.mygdx.game.model;

/** Exception qui indique l'accès à une unité hors de portée. */

public class RessourceInvalideException extends Exception{
	
	/** Initaliser une RessourceInvalideException avec le message précisé.
	  * @param message le message explicatif
	  */
	public RessourceInvalideException(String message) {
		super(message);
	}

}

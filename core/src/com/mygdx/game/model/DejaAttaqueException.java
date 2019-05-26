package com.mygdx.game.model;

/** Exception qui indique que la troupe a déjà attaqué. */

public class DejaAttaqueException extends Exception {

	/** Initaliser une DejaAttaqueException avec le message précisé.
	  * @param message le message explicatif
	  */
	public DejaAttaqueException(String message) {
		super(message);
	}
}

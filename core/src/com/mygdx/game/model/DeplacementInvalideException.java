package com.mygdx.game.model;

/** Exception qui indique que le déplacement voulu n'est pas possible. */

public class DeplacementInvalideException extends Exception {

	/** Initaliser une DeplacementInvalideException avec le message précisé.
	  * @param message le message explicatif
	  */
	public DeplacementInvalideException(String message) {
		super(message);
	}
}

package com.mygdx.game.model;

public class RessourceIndisponibleException extends Exception {
	
	/** Nombre de ressources prises. */
	private int nbRessources;

	/** Initialiser RessourceIndisponibleException à partir du nombre de ressources
	 * prises.
	 * @param nb le nombre de ressources prises
	 * @param message le message qui explique pourquoi nb est invalide.
	 */
	public RessourceIndisponibleException(int nb, String message) {
		super(message);
		this.nbRessources = nb;
	}

	/** Indiquer le nombre de ressources qu'un joueur a voulu prendre.
	  * @return le nombre de ressources qu'un joueur a voulu prendre. */
	public int getNombreRessurces() {
		return this.nbRessources;
	}


}

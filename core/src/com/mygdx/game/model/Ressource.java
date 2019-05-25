package com.mygdx.game.model;

/** Classe représentant l'ensemble des ressources disponibles du jeu. */

public class Ressource {
	
	/** La quantité de ressource disponible */
	private int quantiteRessource;
	
	/** le nom de la reessource*/
	private String name;
	
	/** Constructeur de la classe 
	 * @param rsc le nombre de ressources disponible.
	 */
	public Ressource (int rsc){
		this.quantiteRessource = rsc;
	}
	
	/** Constructeur de la classe 
	 * @param name nom de la ressource
	 * @param rsc le nombre de ressources disponible.
	 */
	public Ressource (String name, int rsc){
		this.quantiteRessource = rsc;
		this.name = name;
	}
	
	/** Obtenir le nom de la ressource
	 * @return le nom de la ressource
	 */
	public String getNom() {
		return this.name;
	}
	
	/** Obtenir le nombre de ressources disponibles 
	 * @return la quantité de ressource disponible
	 */
	public int getRessources(){
		return this.quantiteRessource;
	}
	
	/** Retirer des ressources
	 * @param quantite le nombre de ressources à retirer.
	 */
	public void retirer(int quantite) throws RessourceIndisponibleException{
		if (quantiteRessource >= quantite) {
			this.quantiteRessource -= quantite; 
		} else {
			throw new RessourceIndisponibleException (quantite, "Il ne reste pas assez de ressources");
		}
	}
	
	/** Ajouter des ressources
	 * @param quantite le nombre de ressources à ajouter.
	 */
	public void ajouter(int quantite){
		this.quantiteRessource += quantite;
	}
	
}

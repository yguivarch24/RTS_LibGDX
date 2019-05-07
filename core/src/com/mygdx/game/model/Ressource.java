package com.mygdx.game.model;

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
	
	public Ressource (String name, int rsc){
		this.quantiteRessource = rsc;
		this.name = name;
	}
	
	/** Obtenir le nombre de ressources disponibles */
	public int getRessources(){
		return this.quantiteRessource;
	}
	
	/** Retirer des ressources à l'environnement
	 * @param quantite le nombre de ressources à retirer.
	 */
	public void retirer(int quantite) throws RessourceIndisponibleException{
		if (quantiteRessource >= quantite) {
			this.quantiteRessource -= quantite; 
		} else {
			throw new RessourceIndisponibleException (quantite, "Il ne reste pas assez de ressources");
		}
	}
	
	/** Ajouter des ressources à l'environnement
	 * @param quantite le nombre de ressources à ajouter.
	 */
	public void ajouter(int quantite){
		this.quantiteRessource += quantite;
	}
	

}

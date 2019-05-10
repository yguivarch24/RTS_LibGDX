package com.mygdx.game.model;

abstract public class Batiment extends LiveObject {
	
	
	/** quantité de ressource que possède le batiment.	 */
	private Ressource ressource;
	/** quantité de ressource que produit le batiment par tour.	 */
	private int productionParTour;
	
	/** Constructeur d'un batiment initialise ses statistiques et sa position.
	 * 
	 * @param x Position en x initial de l'objet
	 * @param y Position en y initial de l'objet
	 * @param name Nom de l'objet
	 * @param joueur joueur a qui appartient le batiment
	 * @param vieMax Statistique de vie max
	 * @param vie Vie que l'objet a initialement
	 * @param attaque Statistique inital d'attaque de l'objet
	 * @param defense Statistique  inital de défense de l'objet
	 * @param portee Statistique initial de portée d'effet de l'objet
	 * @param nbderessourceinitial : quantité de ressource que possède initialement le batiment.
	 * @param productionparTour : quantité de ressource que produit le batiment par tour
	 */
	public Batiment(int x, int y, String name, Joueur joueur, int vieMax, int vie, int attaque, int defense,
			int portee, int nbderessourceinitial, int productionparTour) {
		super(x, y, name, joueur, vieMax, vie, attaque, defense, portee);
		this.ressource = new Ressource(nbderessourceinitial);
		this.productionParTour = productionparTour;
	}
	
	
	
	/* TODO Faire un constructeur qui ajoute un batiment à un joueur en lui retirant les ressources de coût.*/
	
	
	
	
	/** Le batiment puise des ressources dans l'environnement et se les approprie.
	 * A faire en début de tour automatiquement. */
	public void batimentGainRessource(){
		//this.ressource.ajouter(this.environnement.collecter(productionParTour));
		
		// ! environnement à ajouter en attribut des LiveObjects et à retirer dans environnement
		
	}
	
	/** Le joueur récupère les ressources du batiment.
	 * A faire lors d'un clic sur le batiment dans son tour de jeu. */
	public void joueurRecupere() {
		try {
			// Ajoute toutes les ressources contenues dans le bâtiment au joueur possédant le bâtiment :
			this.joueur.addRessource(this.ressource.getNom(), this.ressource.getRessources());
			// Retire toutes les ressources contenues dans le bâtiment :
			this.ressource.retirer(this.ressource.getRessources());
		} catch (RessourceInvalideException e) {
			e.getMessage();
		} catch (RessourceIndisponibleException e) {
			e.getMessage();
		}
	}
	
	public void creerUnite() {
		// TODO
	}
}
package com.mygdx.game.model;

abstract public class Unite extends LiveObject {
	
	/** Le nombre de points de mouvement que poss�de l'objet.	 */
	private int nbDeplacementMax;
	/** Le nombre de points de mouvement restants durant un tour. */
	private int nbDeplacementRestant;
	/** Le nombre de points de vie reg�n�r� en d�but de tour. */
	private int regenVieTour;

	/** Constructeur d'un objet vivant, initialise ses statistiques et sa position.
	 * @param nbDeplacementMax Le nombre de points de mouvement de l'objet.
	 * @param nbDeplacementRestant Le nb de point de mouvement initial durant le tour de l'objet.
	 */
	public Unite(int x, int y, String name, Joueur joueur, int vieMax, int vie, int regen, int attaque, int defense, int portee, int nbDeplacementMax, int nbDeplacementRestant) {
		super(x, y, name, joueur, vieMax, vie, attaque, defense, portee);
		this.nbDeplacementMax = nbDeplacementMax;
		this.nbDeplacementRestant = nbDeplacementRestant;
		this.regenVieTour = regen;
	}
	
	
	// Faut-il d�placer par rapport � des valeurs de x et y � ajouter � la pos,
	// Ou faut t'il donner une cellule de la map et se d�placer vers cette cellule ?
	// Il faut encore v�rifier que la case n'est pas occup�, et lever l'exception sinon.
	public void deplacer(int dx, int dy) throws DeplacementInvalideException, CaseOccupeeException {
		if((dx + dy) <= nbDeplacementRestant) {
			this.x += dx;
			this.y -= dy;
		} else {
			throw new DeplacementInvalideException("Pas assez de points de mouvement");
		}
	}
	
	public void initTourUnite() {
		// Reset des points de mouvements
		this.nbDeplacementRestant = this.nbDeplacementMax;
		// Regeneration de vie de d�but de tour.
		if(this.vie <= regenVieTour) {
			this.vie += this.vieMax - this.vie;
		} else { this.regenVieTour += regenVieTour;}
	}

}

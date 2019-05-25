package com.mygdx.game.model;

/** Classe abstraite représentant une unité.
 * Une unité est un LiveObject mobile. */

abstract public class Unite extends LiveObject {
	
	/** Le nombre de points de mouvement que possède l'objet.	 */
	private int nbDeplacementMax;
	/** Le nombre de points de mouvement restants durant un tour. */
	private int nbDeplacementRestant;
	/** Le nombre de points de vie regénéré en début de tour. */
	private int regenVieTour;
	/** Si l'unité a déjà attaqué pour ce tour*/
	private boolean dejaAttaque;

	/** Constructeur d'un objet vivant, initialise ses statistiques et sa position.
	 * @param x coordonnée en abscisse de l'objet
	 * @param y coordonée en ordonnée de l'objet
	 * @param carte carte sur laquelle on joue
	 * @param name nom de l'objet
	 * @param joueur joueur qui possède l'objet
	 * @param vieMax Statistique de vie max
	 * @param vie Vie que l'objet a initialement
	 * @param regen
	 * @param attaque Statistique inital d'attaque de l'objet
	 * @param defense Statistique  inital de défense de l'objet
	 * @param portee Statistique initial de portée d'effet de l'objet
	 * @param nbDeplacementMax Le nombre de points de mouvement de l'objet.
	 * @param nbDeplacementRestant Le nb de point de mouvement initial durant le tour de l'objet.
	 * @param or coût en or de l'oject
	 * @param bois coût en bois de l'objet
	 * @param nourriture coût en nourriture de l'objet
	 */
	public Unite(int x, int y, Carte carte, String name, Joueur joueur, int vieMax, int vie, int regen, int attaque, 
			int defense, int portee, int nbDeplacementMax, int nbDeplacementRestant, int or, int bois,
			int nourriture) throws CaseOccupeeException {
		super(x, y, carte, name, joueur, vieMax, vie, attaque, defense, portee, or, bois, nourriture);
		this.nbDeplacementMax = nbDeplacementMax;
		this.nbDeplacementRestant = nbDeplacementRestant;
		this.regenVieTour = regen;
		this.dejaAttaque = false;
	}

	/** Le LiveObjet attaque un autre. 
	 * @param defenseur : l'attaqué
	 * @throws HorsDePorteeException si la cible est hors de portée
	 * @throws DejaAttaqueException si l'unité a déjà attaqué pendant le tour
	 */
	@Override 
	public void attaquer(LiveObject defenseur) throws HorsDePorteeException, DejaAttaqueException {
		if(this.estAPorte(defenseur)) {
			if (dejaAttaque) {
				throw new DejaAttaqueException("Cette unité a déjà attaqué pendant ce tour.");
			}
			// mort du défenseur
			if (defenseur.getVie() + defenseur.getDefense() - this.attaque < 0){
				defenseur.retirerVie(defenseur.getVie());
			}
			//pas assez de points d'attaque
			if (defenseur.getDefense()-this.attaque>=0){}
			// dernier cas : on enlève les points d'attaque au défenceur
			else{
				defenseur.retirerVie(defenseur.getDefense()-this.attaque); 
				}
		} else {
			throw new HorsDePorteeException("La cible est hors de portée");
		}
	}

	/** Fonction permettant de déplacer un objet.
	 * @param dx déplacement selon les absisses
	 * @param dy déplacement selon les ordonnées
	 * @throws DeplacementInvalideExecption si l'unité ne possède pas assez de points de mouvements
	 * @throws CaseOccupeeException si la case est occupée
	 */
	public void deplacer(int dx, int dy) throws DeplacementInvalideException, CaseOccupeeException {
		if((dx + dy) <= nbDeplacementRestant) {
			this.x += dx;
			this.y -= dy;
		} else {
			throw new DeplacementInvalideException("Pas assez de points de mouvement");
		}
	}
	
	/** Fonction permettant d'initialiser le tour d'un joueur, après un changement de main
	 * 
	 */
	public void initTourUnite() {
		// Reset des points de mouvements
		this.nbDeplacementRestant = this.nbDeplacementMax;
		// Reset de dejaAttaque
		this.dejaAttaque = false;
		// Regeneration de vie de début de tour.
		if(this.vie < this.vieMax) {
			if (this.vie + regenVieTour >= this.vieMax) {
				this.vie = this.vieMax;
			} else {
				this.vie += regenVieTour;
			}
		}
	}

}


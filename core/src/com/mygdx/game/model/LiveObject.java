package com.mygdx.game.model;
import java.lang.Math;

/** La classe model.LiveObject définie les caractéristiques générales d'un objet
 * "vivant" de notre jeu tel qu'une unité ou un batiment. Elle hérite donc 
 * de model.GameObject qui généralise l'ensemble des objets du jeu.
 */
 
public class LiveObject extends GameObject {

	/** Le joueur qui possède l'objet */
	private Joueur joueur;
	/** La vie maximal de l'objet */ 
	protected int vieMax;
	/** La vie courante de l'objet */ 
	protected int vie;
	/** La statistique de dégat de l'objet */ 
	protected int attaque;
	/** La statistique de défense de l'objet */ 
	private int defense;
	/** La statistique de portée d'attaque d'un objet */ 
	private int portee;
	/** Cout à payer en or pour obtenir l'objet */
	private int coutOr;
	/** Cout à payer en Bois pour obtenir l'objet */
	private int coutBois;
	/** Cout à payer en Nourriture pour obtenir l'objet */
	private int coutNourriture;

	/** Constructeur d'un objet vivant, initialise ses statistiques et sa position.
	 *
	 * @param x coordonnée en abscisse de l'objet
	 * @param y coordonée en ordonnée de l'objet
	 * @param carte carte sur laquelle on joue
	 * @param name nom de l'objet
	 * @param joueur joueur qui possède l'objet
	 * @param vieMax Statistique de vie max
	 * @param vie Vie que l'objet a initialement
	 * @param attaque Statistique inital d'attaque de l'objet
	 * @param defense Statistique  inital de défense de l'objet
	 * @param portee Statistique initial de portée d'effet de l'objet
	 * @param or coût en or de l'oject
	 * @param bois coût en bois de l'objet
	 * @param nourriture coût en nourriture de l'objet
	 */
    public LiveObject(int x, int y, Carte carte, String name, Joueur joueur, int vieMax, int vie, int attaque, int defense, 
    		int portee, int or, int bois, int nourriture) throws CaseOccupeeException {
        super(x, y, name);
        this.joueur = joueur;
        this.vieMax = vieMax;
        this.vie = vie;
        this.attaque = attaque;
        this.defense = defense;
        this.portee = portee;
        this.coutOr = or;
        this.coutBois = bois;
        this.coutNourriture = nourriture;
        carte.setLiveObject(x, y, this);
    }

	/** Fonction permettant de retirer les points de vie d'un objet.
	 * @param viePerdu Nombre de points de vie à retirer
	 */
	public void retirerVie(int viePerdu) {
		this.vie -= viePerdu;
	}

	/** Fonction permettant d'ajouter des points de vie à un objet.
	 * @param vieGagne Nombre de point de vie à ajouter
	 */
	public void ajouterVie(int vieGagne) {
		// On ne peut pas aller au dessus de la vie maximal.
		if (this.vie + vieGagne >= this.vieMax) {
			this.vie = vieMax;
		} else {
			this.vie += vieGagne; 
		}
	}

	 /** Informe si notre LiveObject à la portée pour attaquer une certaine cible.
	  * 
	  * @param cible La cible à attaquer
	  * @return True si notre objet est à portée, Flase sinon
	  */
	public boolean estAPorte(LiveObject cible)	{
		return((Math.abs(this.x - cible.getX()) + Math.abs(this.y - cible.getY())) <= this.portee);
	}


	/** Obtenir l'état de vie d'un objet. 
	 * @return True si la cible est morte, False sinon
	 */
	public boolean estMort() {
		if (this.vie == 0){
			return true;
		}
		else {
			return false;
		}
	}

	/** Obtenir la vieMax de l'objet. 
	 * @return vie max de l'objet
	 */
	public int getVieMax() {
		return this.vieMax;
	}

	/** Obtenir la vie actuelle de l'objet. 
	 * @ return vie actuelle de l'objet
	 */
	public int getVie() {
		return this.vie;
	}

	/** Obtenir la défense de l'objet
	 * @return defense de l'objet
	 */
	public int getDefense(){
		return this.defense;
	}

	/**Obtenir la portée de l'objet 
	 * @return portée de l'objet
	 */
	 public int getPortee(){
		 return this.portee;
	 }

	 /** Obtenir le coût en or d'un objet.
	  * @return valeur du coût en or.
	  */
	 public int getCoutOr() {
		 return coutOr;
	 }

	 /** Obtenir le coût en bois d'un objet.
	  * @return valeur du coût en bois.
	  */
	 public int getCoutBois() {
		 return coutBois;
	 }

	 /** Obtenir le coût en nourriture d'un objet.
	  * @return valeur du coût en nourriture.
	  */
	 public int getCoutNourriture() {
		 return coutNourriture;
	 }

	 /** Obtenir le joueur associer à l'objet.	  * 
	  * @return le Joueur
	  */
	 public Joueur getJoueur() {
		 return this.joueur;
	 }
	 
	 public void attaquer(LiveObject defenseur) throws HorsDePorteeException, DejaAttaqueException {
		 
	 }
}

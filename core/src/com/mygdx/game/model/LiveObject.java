package com.mygdx.game.model;
import java.lang.Math;

/** La classe model.LiveObject définie les caractéristiques général d'un objet
 * "vivant" de notre jeu tel qu'une unité ou un batiment. Elle hérite donc 
 * de model.GameObject qui généralise l'ensemble des objets du jeu.
 * 
 * @author jdides
 *
 */
 
public class LiveObject extends GameObject {

	/** Le joueur qui possède le bâtiment */
	private Joueur joueur;
	/** La vie maximal de l'objet */ 
	protected int vieMax;
	/** La vie courante de l'objet */ 
	protected int vie;
	/** La statistique de dégat de l'objet */ 
	private int attaque;
	/** La statistique de défense de l'objet */ 
	private int defense;
	/** La statistique de portée d'attaque d'un objet */ 
	private int portee;
	/** Cout � payer en or pour obtenir l'objet */
	private int coutOr;
	/** Cout � payer en Bois pour obtenir l'objet */
	private int coutBois;
	/** Cout � payer en Nourriture pour obtenir l'objet */
	private int coutNourriture;
	
	/** Constructeur d'un objet vivant, initialise ses statistiques et sa position.
	 *
	 * @param vieMax Statistique de vie max
	 * @param vie Vie que l'objet a initialement
	 * @param attaque Statistique inital d'attaque de l'objet
	 * @param defense Statistique  inital de défense de l'objet
	 * @param portee Statistique initial de portée d'effet de l'objet
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
	 * 
	 * @param viePerdu Nombre de points de vie à retirer
	 */
	public void retirerVie(int viePerdu) {
		this.vie -= viePerdu;
	}
	
	/** Fonction permettant d'ajouter des points de vie à un objet.
	 * 
	 * @param vieGagne Nombre de point de vie à ajouter
	 */
	public void ajouterVie(int vieGagne) {
		// One ne peut pas aller au dessus de la vie maximal.
		if (this.vie + vieGagne >= this.vieMax) {
			this.vie = vieMax;
		} else {
			this.vie += vieGagne; 
		}
	}
	
	/** Renvoie la vieMax de l'objet. */
	public int getVieMax() {
		return this.vieMax;
	}
	
	/** Renvoie la vie actuel de l'objet. */
	public int getVie() {
		return this.vie;
	}
	
	/** Renvoie la défense actuelle de l'objet */
	public int getDefense(){
		return this.defense;
	}
	
	/**Renvoie la portée actuelle de l'objet */
	 public int getPortee(){
		 return this.portee;
	 }
	 
	 /** Permet d'obtenir le cout en or d'un objet.
	  * @return La valeur du cout en or.
	  */
	 public int getCoutOr() {
		 return coutOr;
	 }
	 
	 /** Permet d'obtenir le cout en bois d'un objet.
	  * @return La valeur du cout en bois.
	  */
	 public int getCoutBois() {
		 return coutBois;
	 }
	 
	 /** Permet d'obtenir le cout en nourriture d'un objet.
	  * @return La valeur du cout en nourriture.
	  */
	 public int getCoutNourriture() {
		 return coutNourriture;
	 }
	 

	 /** Informe si notre � la port�e pour attaqu� une certaine cible.
	  * 
	  * @param cible La cible � attaquer
	  * @return True si notre objet est � port�e, Flase sinon
	  */
	public boolean estAPorte(LiveObject cible)
	{
		return((Math.abs(this.x - cible.getX()) + Math.abs(this.y - cible.getY())) <= this.portee);
	}
	 
	 
	/** Le LiveObjet attaque un autre.
	 * 
	 * @param defenseur : l'attaqué
	 */
	public void attaquer(LiveObject defenseur) throws HorsDePorteeException {
		if(this.estAPorte(defenseur)) {
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
			throw new HorsDePorteeException("La cible est hors de port�e");
		}
	}
	
	public boolean estMort() {
		if (this.vie == 0){
			return true;
		}
		else {
			return false;
		}
	}
	// PAS EXHAUSTIF
}

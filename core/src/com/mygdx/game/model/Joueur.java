package com.mygdx.game.model;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Joueur {
	
	/** Le nom du joueur */
	private String pseudo;
	
	/** La Stratégie du joueur */
	//private Strategie strategie;
	
	/** La 1e ressource et son montant associées au joueur */
	private Ressource or;
	/** La 2e ressource et son montant associées au joueur */
	private Ressource bois;
	/** La 3e ressource et son montant associées au joueur */
	private Ressource nourriture;
	
	/** Liste des troupes appartenant aux joueur. Chaque types d'unit� est associ�e � 
	 * une cl�e (un nombre entier) comme ceci :
	 * 1 - Soldat 
	 * 2 - Archer */
	private Map<Integer, List<Unite>> troupes;
	/** Liste des batiments appartenant aux joueur. */
	private List<Batiment> batiments;
	
	/** Coleur du joueur */
	private Color couleur;
 
	
	public Joueur(String pseudo, Color coul) {
		this.pseudo = pseudo;
		this.or = new Or(100);
		this.bois = new Bois(50);
		this.nourriture = new Nourriture(50);
		this.troupes = new HashMap();
		this.batiments = new ArrayList();
		this.couleur = coul;
	}
	
	/** Permet d'initaliser le tour d'un joueur. (initialise les unite, les ressources etc...) */
	public void initTourJoueur() {
		// Reg�n�ration des pdv des unit�s en d�but de tour.
		troupes.forEach((t, listeUnite) ->  {
			listeUnite.forEach(unite -> {
				unite.initTourUnite();
			});
		});
		
		// Ajout des ressources en d�but de tour pour chaque batiment de r�colte.
		batiments.forEach(bat -> {
			if(bat instanceof Mine) {
				this.or.ajouter(((Mine) bat).getProduction());
			} else if(bat instanceof Scierie) {
				this.bois.ajouter(((Scierie) bat).getProduction());
			} else if(bat instanceof Ferme) {
				this.nourriture.ajouter(((Ferme) bat).getProduction());
			}
		});
	}
	
	public void payer(int coutNourriture, int coutBois, int coutOr) throws RessourceIndisponibleException {
		this.nourriture.retirer(coutNourriture);
		this.bois.retirer(coutBois);
		this.or.retirer(coutOr);
	}
	
	
	
	public String getPseudo() {
		return this.pseudo;
	}
	
	private Ressource Str2Ressource(String nomRes) throws RessourceInvalideException {
		if (nomRes == this.nourriture.getNom()) {
			return this.nourriture;
		} else if (nomRes == this.bois.getNom()) {
			return this.bois;
		} else if (nomRes == this.or.getNom()) {
			return this.or;
		} else {
			throw new RessourceInvalideException("Le joueur ne possède pas cette ressource.");
		}
	}
	
	public int getRessources(String nomRes) throws RessourceInvalideException {
		
		return Str2Ressource(nomRes).getRessources();
		
	}
	
	public void addRessource(String nomRes, int quantite) throws RessourceInvalideException {
		
		Str2Ressource(nomRes).ajouter(quantite);
		
	}
	
	public void rmRessource(String nomRes, int quantite) throws RessourceInvalideException, RessourceIndisponibleException {

		Str2Ressource(nomRes).retirer(quantite);
		
	}
	
	/** Accesseur de la liste des batiments du joueur.
	 * 
	 * @return La liste de batimetns que poss�de un joueur.
	 */
	public List<Batiment> getBatiments() {
		return batiments;
	}
	
	/** Permet d'jaouter un batiment dans la liste des batiments du joueur.
	 * 
	 * @param nouveauBat Le batiment � ajouter.
	 */
	public void ajouterBatiment(Batiment nouveauBat) {
		this.batiments.add(nouveauBat);
	}
	
	/** Permet de supprimer un batiment dans la liste des batiments du joueur.
	 * 
	 * @param bat Le batiment � supprimer.
	 */
	public void supprimerBatiment(Batiment bat) {
		this.batiments.remove(bat);
	}
	
	/** Renvoi la map de toutes les troupes du joueur/
	 * 
	 * @return La map des troupes : Map<Integer, List<Unite>>
	 */
	public Map<Integer, List<Unite>> getTroupes() {
		return troupes;
	}
	
	/** Renvoi la lsite de tous les soldats du joueurs.
	 * 
	 * @return Liste des soldats.
	 */
	public List<Unite> getSoldat(){
		return troupes.get(1);
	}
	
	/** Renvoi la lsite de tous les soldats du joueurs.
	 * 
	 * @return Liste des soldats.
	 */
	public List<Unite> getArcher() {
		return troupes.get(2);
	}
	
	/** Permet d'jaouter une troupe � la liste des troupes du joueur. 
	 * Quelque soit le type de troupe.
	 * 
	 * @param newUnite La troupe � ajouter au joueur.
	 */
	public void ajouterTroupe(Unite newUnite) {
		/*On ajoute l'unit� � la liste correspondante au type d'unit� (soldat, archer...).
		On cherche donc d'abord quel type d'unit� c'est, puis on l'ajoute � la liste de la 
		map correspondante. cl�e : 1 pour la liste des soldats, 2 poru les archers. */
		switch(newUnite.getClass().getName()) {
		case "Soldat":
			this.troupes.get(1).add(newUnite);
			System.out.println("Ajout d'un soldat au joueur " + this.pseudo);
			break;
		case "Archer":
			this.troupes.get(2).add(newUnite);
			System.out.println("Ajout d'un archer au joueur " + this.pseudo);
		break;
		default : 
			System.out.println("Erreur dans l'ajout de troupe, l'unit� n'a pas un type conforme.");
			break;
		}
	}
	
	/** Renvoi la couleur associer au joueur 
	 * @return la couleur du joueur
	 * */
	public Color getCouleur() {
		return this.couleur;
	}
	
	/** Change la couleur associer au joueur 
	 * @param coul la nouvelle couleur du joueur
	 * */
	public void setCouleur(Color coul) {
		this.couleur = coul;
	}
}

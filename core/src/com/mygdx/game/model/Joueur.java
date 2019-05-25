package com.mygdx.game.model;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Classe représentant un joueur du jeu */

public class Joueur {
	
	/** Le nom du joueur */
	private String pseudo;	
	/** La 1e ressource et le montant associé au joueur */
	private Ressource or;
	/** La 2e ressource et le montant associé au joueur */
	private Ressource bois;
	/** La 3e ressource et le montant associé au joueur */
	private Ressource nourriture;
	
	/** Liste des troupes appartenant aux joueurs. Chaque type d'unité est associé à 
	 * une clée (un nombre entier) comme ceci :
	 * 1 - Soldat 
	 * 2 - Archer */
	private Map<Integer, List<Unite>> troupes;
	/** Liste des batiments appartenant aux joueur. */
	private List<Batiment> batiments;
	
	/** Coleur du joueur */
	private Color couleur;
 
	/** Constructeur d'un joueur en fonction de ses caractéristiques
	 * @param pseudo pseudo du joueur
	 * @param coul couleur du joueur
	 */
	public Joueur(String pseudo, Color coul) {
		this.pseudo = pseudo;
		this.or = new Or(100);
		this.bois = new Bois(50);
		this.nourriture = new Nourriture(50);
		this.troupes = new HashMap<>();
		troupes.put(1, new ArrayList<Unite>());
		troupes.put(2, new ArrayList<Unite>());
		this.batiments = new ArrayList<>();
		this.couleur = coul;
	}
	
	/** Permet d'initaliser le tour d'un joueur. (initialise les unite, les ressources etc...) */
	public void initTourJoueur() {
		// Regénération des pdv des unités en début de tour.
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
	
	/** Fonction qui dépense les ressources d'un joueur
	 * @param coutNourriture quantité de nourriture dépensée
	 * @param coutBois quantité de bois dépensée
	 * @param coutOr quantité d'or dépensée
	 * @throws RessourceIndisponibleException si la ressource n'est plus disponible
	 */
	public void payer(int coutNourriture, int coutBois, int coutOr) throws RessourceIndisponibleException {
		this.nourriture.retirer(coutNourriture);
		this.bois.retirer(coutBois);
		this.or.retirer(coutOr);
	}

	/** Fonction pour transformer un string en ressource
	 * @param nomRes nom de la ressource sous forme de string
	 * @return la ressource
	 * @throws RessourceInvalideException si la ressource n'existe pas
	 */
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
	
	/** Ajouter une quantité de ressource
	 * @param nomRes ressource considérée
	 * @param quantite quantité à ajouter
	 * @throws RessourceInvalideException si la ressource n'existe pas
	 */
	public void addRessource(String nomRes, int quantite) throws RessourceInvalideException {
		Str2Ressource(nomRes).ajouter(quantite);
	}
	
	/** Retirer une quantité de ressource
	 * @param nomRes ressource considérée
	 * @param quantite quantité à retirer
	 * @throws RessourceInvalideException si la ressource n'existe pas
	 * @throws RessourceIndisponibleException si la ressource n'est pas disponible
	 */
	public void rmRessource(String nomRes, int quantite) throws RessourceInvalideException, RessourceIndisponibleException {
		Str2Ressource(nomRes).retirer(quantite);
	}
	
	/** Accesseur de la liste des batiments du joueur.
	 * @return La liste de batimetns que possède un joueur.
	 */
	public List<Batiment> getBatiments() {
		return batiments;
	}
	
	/** Permet d'jaouter un batiment dans la liste des batiments du joueur.
	 * @param nouveauBat Le batiment à ajouter.
	 */
	public void ajouterBatiment(Batiment nouveauBat) {
		this.batiments.add(nouveauBat);
	}
	
	/** Permet de supprimer un batiment dans la liste des batiments du joueur.
	 * @param bat Le batiment à supprimer.
	 */
	public void supprimerBatiment(Batiment bat) {
		this.batiments.remove(bat);
	}
	
	/** Renvoi la map de toutes les troupes du joueur/
	 * @return La map des troupes : Map<Integer, List<Unite>>
	 */
	public Map<Integer, List<Unite>> getTroupes() {
		return troupes;
	}
	
	/** Renvoi la liste de tous les soldats du joueurs.
	 * @return Liste des soldats.
	 */
	public List<Unite> getSoldat(){
		return troupes.get(1);
	}
	
	/** Renvoi la liste de tous les soldats du joueurs.
	 * @return Liste des soldats.
	 */
	public List<Unite> getArcher() {
		return troupes.get(2);
	}
	
	/** Permet d'jaouter une troupe à la liste des troupes du joueur. 
	 * Quelque soit le type de troupe.
	 * @param newUnite La troupe à ajouter au joueur.
	 */
	public void ajouterTroupe(Unite newUnite) {
		/*On ajoute l'unité à la liste correspondante au type d'unité (soldat, archer...).
		On cherche donc d'abord quel type d'unité c'est, puis on l'ajoute à la liste de la 
		map correspondante. clée : 1 pour la liste des soldats, 2 pour les archers. */
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
	
	/** Renvoi la couleur associée au joueur 
	 * @return la couleur du joueur
	 * */
	public Color getCouleur() {
		return this.couleur;
	}
	
	/** Change la couleur associée au joueur 
	 * @param coul la nouvelle couleur du joueur
	 * */
	public void setCouleur(Color coul) {
		this.couleur = coul;
	}
	
	/** Obtenir le pseudo d'un joueur
	 * @return le pseudo du joueur dont c'est le tour
	 */
	public String getPseudo() {
		return this.pseudo;
	}
	
	/** Obtenir la quantité d'une ressource
	 * @param nomRes ressource dont on veut la quantité
	 * @return la quantité
	 * @throws RessourceInvalideException si la ressource n'existe pas
	 */
	public int getRessources(String nomRes) throws RessourceInvalideException {		
		return Str2Ressource(nomRes).getRessources();	
	}
}
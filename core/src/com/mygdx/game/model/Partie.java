package com.mygdx.game.model;
import java.util.List;
import java.util.Observable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Partie {
	
	int nbJoueur;
	
	/** Liste des joueurs dans la partie */ 
	List<Joueur> listeJoueurs;
	
	Map<Joueur, Batiment> listeBatiment; 
	
	Map<Joueur, Unite> listeUnite; 
	
	public Partie(int nbJ) {
		nbJoueur = nbJ;
		listeJoueurs = new ArrayList<Joueur>(nbJ);
		listeBatiment = new HashMap<Joueur, Batiment>();
		listeUnite = new HashMap<Joueur, Unite>();
	}
}

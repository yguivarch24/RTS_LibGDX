package com.mygdx.game.vue.vue_carte;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.model.*;

public class TiledMapClickListener extends GlobalClickListener {

    private TiledMapActor actor;
    
    public TiledMapClickListener(TiledMapActor actor) {
        this.actor = actor;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        System.out.println(actor.cellule + " has been clicked.");
        action();
    }
    
    public void action() {
    	if (!actor.cellule.estOccupee()) {
    		int x = actor.cellule.getX();
    		int y = actor.cellule.getY();
    		if (GlobalClickListener.objetSelec instanceof Unite) {
	    		Unite unite_courante = (Unite)GlobalClickListener.objetSelec;
	    		try {
	    			unite_courante.deplacer(x,y);
	    		} catch (DeplacementInvalideException e1) {
	    			GlobalClickListener.objetSelec = null;
	    		} catch (CaseOccupeeException e2) { 
	    			GlobalClickListener.objetSelec = null;
	    		}
	    	} else if (actor.cellule instanceof Ressource) {
	    		Ressource ressource_courante = (Ressource)actor.cellule;
	    		if (ressource_courante.getNom() == "Bois") {
	    			try {
	    				partie.getJoueur().payer(0, 1, 0);
	    			} catch (RessourceIndisponibleException e) {
	    				GlobalClickListener.objetSelec = null;
	    			}
		    		try {
		    			Scierie scierie_courante = new Scierie(x,y,partie.getCarte(), partie.getJoueur(),ressource_courante); 
		    			partie.getJoueur().ajouterBatiment(scierie_courante);
		    		} catch (CaseOccupeeException e) {
		    			GlobalClickListener.objetSelec = null;
		    		}
	    			
	    		} else if (ressource_courante.getNom() == "Or") {
	    			try {
	    				partie.getJoueur().payer(0, 1, 0);
	    			} catch (RessourceIndisponibleException e) {
	    				GlobalClickListener.objetSelec = null;
	    			}
		    		try {
		    			Mine mine_courante = new Mine(x,y,partie.getCarte(), partie.getJoueur(),ressource_courante); 
		    			partie.getJoueur().ajouterBatiment(mine_courante);
		    		} catch (CaseOccupeeException e) {
		    			GlobalClickListener.objetSelec = null;
		    		}
	    			
	    		} else if (ressource_courante.getNom() == "Nourriture") {
	    			try {
	    				partie.getJoueur().payer(0, 1, 0);
	    			} catch (RessourceIndisponibleException e) {
	    				GlobalClickListener.objetSelec = null;
	    			}
		    		try {
		    			Ferme ferme_courante = new Ferme(x,y,partie.getCarte(), partie.getJoueur(),ressource_courante); 
		    			partie.getJoueur().ajouterBatiment(ferme_courante);
		    		} catch (CaseOccupeeException e) {
		    			GlobalClickListener.objetSelec = null;
		    		}
	    			
	    		} 
	    	}  	
	    	
    	} else {
    		GlobalClickListener.objetSelec = null;
    	}
    	
    }
    
}

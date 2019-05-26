package com.mygdx.game.vue.vue_carte;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.model.*;

public class TiledMapClickListener extends GlobalClickListener {

	private TiledMapStage stage;
    private TiledMapActor actor;
    
    
    public TiledMapClickListener(TiledMapActor actor, TiledMapStage st) {
    	this.stage = st;
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
	    	} else if (actor.cellule instanceof EnvironnementCollectable) {
	    	    EnvironnementCollectable env = (EnvironnementCollectable)actor.cellule;
	    		
	    	    if ( env instanceof Foret) {
	    			try {
	    				GlobalClickListener.partie.getJoueur().payer(0, 15, 10);
	    				try {
			    			Scierie scierie_courante = new Scierie(x,y,partie.getCarte(), partie.getJoueur(),env.getRessource()); 
			    			partie.getJoueur().ajouterBatiment(scierie_courante);
			        		LiveObjectActor batActor = new LiveObjectActor(scierie_courante, this.stage);
			        		LiveObjectClickListener batListener = new LiveObjectClickListener(batActor);
			        		batListener.actor.stage.addActor(batActor);
			    		} catch (CaseOccupeeException e) {
			    			GlobalClickListener.objetSelec = null;
			    		}
	    			} catch (RessourceIndisponibleException e) {
	    				GlobalClickListener.objetSelec = null;
	    			}
		    		
		    	} else if (env instanceof GisementOr) {
		    		System.out.println("or");
	    		try {
	    			GlobalClickListener.partie.getJoueur().payer(0, 15, 10);
	    			try {
		    			Mine mine_courante = new Mine(x,y,partie.getCarte(), partie.getJoueur(),env.getRessource()); 
		    			GlobalClickListener.partie.getJoueur().ajouterBatiment(mine_courante);
		        		LiveObjectActor batActor = new LiveObjectActor(mine_courante, this.stage);
		        		LiveObjectClickListener batListener = new LiveObjectClickListener(batActor);
		        		batListener.actor.stage.addActor(batActor);
		    			
		    		} catch (CaseOccupeeException e) {
		    			GlobalClickListener.objetSelec = null;
		    		}
    				
    			} catch (RessourceIndisponibleException e) {
    				GlobalClickListener.objetSelec = null;
    			}
	    		
		    	} else if (env instanceof Buisson) {
	    		try {
	    			GlobalClickListener.partie.getJoueur().payer(0, 15, 10);
	    			
	    			try {
		    			Ferme ferme_courante = new Ferme(x,y,partie.getCarte(), partie.getJoueur(), env.getRessource()); 
		    			GlobalClickListener.partie.getJoueur().ajouterBatiment(ferme_courante);
		    			LiveObjectActor batActor = new LiveObjectActor(ferme_courante, this.stage);
		        		LiveObjectClickListener batListener = new LiveObjectClickListener(batActor);
		        		batListener.actor.stage.addActor(batActor);
		    		} catch (CaseOccupeeException e) {
		    			GlobalClickListener.objetSelec = null;
		    		}
    			} catch (RessourceIndisponibleException e) {
    				GlobalClickListener.objetSelec = null;
    			}
	    		try {
	    			Ferme ferme_courante = new Ferme(x,y,partie.getCarte(), partie.getJoueur(), env.getRessource()); 
	    			GlobalClickListener.partie.getJoueur().ajouterBatiment(ferme_courante);
	    			LiveObjectActor batActor = new LiveObjectActor(ferme_courante, this.stage);
	        		LiveObjectClickListener batListener = new LiveObjectClickListener(batActor);
	        		batListener.actor.stage.addActor(batActor);
	    		} catch (CaseOccupeeException e) {
	    			GlobalClickListener.objetSelec = null;
	    		}
	    	}
    	} else if (actor.cellule instanceof Environnement) {
	    	Environnement env = (Environnement)actor.cellule;
	    	if (env instanceof  Plaine) {		    	
	    		try {
	    			Caserne caserne_courante = new Caserne(x,y,partie.getCarte(), partie.getJoueur()); 
	    			GlobalClickListener.partie.getJoueur().ajouterBatiment(caserne_courante);
	    			LiveObjectActor batActor = new LiveObjectActor(caserne_courante, this.stage);
	        		LiveObjectClickListener batListener = new LiveObjectClickListener(batActor);
	        		batListener.actor.stage.addActor(batActor);
	    		} catch (CaseOccupeeException e) {
	    			GlobalClickListener.objetSelec = null;
	    		}
	    	}
    	} else {
    		GlobalClickListener.objetSelec = null;
    	}
    	
    }
    
}
    
}

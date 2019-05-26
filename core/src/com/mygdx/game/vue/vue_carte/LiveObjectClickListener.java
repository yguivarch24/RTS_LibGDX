package com.mygdx.game.vue.vue_carte;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.mygdx.game.model.*;

public class LiveObjectClickListener extends GlobalClickListener {

    protected LiveObjectActor actor;

    public LiveObjectClickListener(LiveObjectActor actor) {
        this.actor = actor;
    }
    
    @Override
    public void clicked(InputEvent event, float x, float y) {
        System.out.println(actor.liveObject + " has been clicked.");
        
        // Si on a cliqué sur une unité
        if (this.actor.liveObject instanceof Unite) {
        	
        	// Si rien n'était sélectionné auparavant
        	if (GlobalClickListener.objetSelec == null) {
        		// Si on a cliqué sur une unité du joueur courant
        		if (this.actor.liveObject.getJoueur() == GlobalClickListener.partie.getJoueur()) {
        			GlobalClickListener.objetSelec = this.actor.liveObject;
        		// Si on a cliqué sur une unité de l'autre joueur
        		} else {
        			//afficher caractéristiques
        		}
        		
        	// Si une unité était sélectionné auparavant
        	} else if (GlobalClickListener.objetSelec instanceof Unite) {
        		// Si on a cliqué sur une unité du joueur courant
        		if (this.actor.liveObject.getJoueur() == GlobalClickListener.partie.getJoueur()) {
        			// Il ne se passe rien car on ne s'attaque pas soi-même
        		// Si on a cliqué sur une unité de l'autre joueur
        		} else {
        			try {
        				GlobalClickListener.objetSelec.attaquer(this.actor.liveObject);
        				GlobalClickListener.objetSelec = null;
        			}catch (HorsDePorteeException e){
        				e.getMessage();
        			} catch (DejaAttaqueException e) {
        				e.getMessage();        			}	
        		}
        	}
        	/*// Si un batiment était sélectionné auparavant
        	} else if (GlobalClickListener.objetSelec instanceof Batiment) {
        		// Si on a cliqué sur une unité du joueur courant
        		if (this.actor.liveObject.getJoueur() == GlobalClickListener.partie.getJoueur()) {
        			
        		// Si on a cliqué sur une unité de l'autre joueur
        		} else {
        			
        		}
        
        	*/
        	
        // Si on clique sur un batiment
        } else if (this.actor.liveObject instanceof Batiment) {
        	if (GlobalClickListener.objetSelec == null) {
        		// afficher caractéristique batiment
        		System.out.println(this.actor.liveObject.getJoueur());
        		System.out.println(GlobalClickListener.partie.getJoueur());
        		if (this.actor.liveObject.getJoueur().equals(GlobalClickListener.partie.getJoueur())) {
        			System.out.println("C'est ma caserne");
        			if(this.actor.liveObject instanceof Caserne) {
            			GlobalClickListener.objetSelec = this.actor.liveObject;
            			actor.stage.uiStage.soldat.setVisible(true);
            			actor.stage.uiStage.archer.setVisible(true);
            		}
            		else {
            			
            		}
        		}
        	} else if (GlobalClickListener.objetSelec instanceof Unite) {
            		// Si on a cliqué sur un batiment du joueur courant
            		if (this.actor.liveObject.getJoueur() == GlobalClickListener.partie.getJoueur()) {
            			// On change d'unit� selctionn�
            			GlobalClickListener.objetSelec = this.actor.liveObject;
            		} else { // Si on a cliqué sur un batiment de l'autre joueur
            			try {
            				GlobalClickListener.objetSelec.attaquer(this.actor.liveObject);
            				GlobalClickListener.objetSelec = null;
            			}catch (HorsDePorteeException e){
            				e.getMessage();
            			} catch (DejaAttaqueException e) {
            				e.getMessage();        			}	
            		}
            	}
        	}
        
        if(!(this.actor.liveObject instanceof Caserne)) {
        	System.out.println("On efface les boutons");
			actor.stage.uiStage.soldat.setVisible(false);
			actor.stage.uiStage.archer.setVisible(false);
		}
   }
    
}

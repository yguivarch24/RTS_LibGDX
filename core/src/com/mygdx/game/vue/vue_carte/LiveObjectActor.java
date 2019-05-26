package com.mygdx.game.vue.vue_carte;

import java.awt.Color;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.mygdx.game.model.LiveObject;

public class LiveObjectActor extends Actor {

    LiveObject liveObject;
    Sprite sprite;
    TiledMapStage stage;

    public LiveObjectActor(LiveObject liveObject, TiledMapStage st) {
    	this.stage = st;
    	this.liveObject = liveObject;
        setSprite();
        EventListener eventListener = new LiveObjectClickListener(this);
        addListener(eventListener);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        setBounds(liveObject.getX()*sprite.getHeight(), liveObject.getY()*sprite.getHeight(), sprite.getWidth(), sprite.getHeight());
        batch.draw(sprite, liveObject.getX()*sprite.getWidth(), liveObject.getY()*sprite.getHeight());
    }
    
    /** Cette méthode permettra de set le sprite correspondant à l'objet. 
     * Onregardera donc quelle est l'instance de cette objet (soldat, hdv, caserne...) afin 
     * de lui donner la bonne apparence. 
	*/
    public void setSprite() {
    	switch(this.liveObject.getClass().getName()) {
    	case "com.mygdx.game.model.HotelDeVille" :
    		if(this.liveObject.getJoueur().getCouleur() == Color.blue) {
    			this.sprite = new Sprite(new Texture(Gdx.files.internal("Tiles/HVBleu.png")));
    		} else {
    			this.sprite = new Sprite(new Texture(Gdx.files.internal("Tiles/HVRouge.png")));
    		}
    		break;	
    	case "com.mygdx.game.model.Caserne" : /* -------------PAS ENCORE DE SKIN PORU CASERNE --------*/
    		if(this.liveObject.getJoueur().getCouleur() == Color.blue) {
    			this.sprite = new Sprite(new Texture(Gdx.files.internal("Tiles/caserne_bleu.png")));
    		} else {
    			this.sprite = new Sprite(new Texture(Gdx.files.internal("Tiles/caserne_rouge.png")));
    		}
    		break;
    	case "com.mygdx.game.model.Scierie" :
    		if(this.liveObject.getJoueur().getCouleur() == Color.blue) {
    			this.sprite = new Sprite(new Texture(Gdx.files.internal("Tiles/scierie_bleu.png")));
    		} else {
    			this.sprite = new Sprite(new Texture(Gdx.files.internal("Tiles/scierie_rouge.png")));
    		}
    		break;
    	case "com.mygdx.game.model.Mine" :
    		if(this.liveObject.getJoueur().getCouleur() == Color.blue) {
    			this.sprite = new Sprite(new Texture(Gdx.files.internal("Tiles/mine_bleu.png")));
    		} else {
    			this.sprite = new Sprite(new Texture(Gdx.files.internal("Tiles/mine_rouge.png")));
    		}
    		break;
    	case "com.mygdx.game.model.Ferme" :
    		if(this.liveObject.getJoueur().getCouleur() == Color.blue) {
    			this.sprite = new Sprite(new Texture(Gdx.files.internal("Tiles/fermeBleu.png")));
    		} else {
    			this.sprite = new Sprite(new Texture(Gdx.files.internal("Tiles/fermeRouge.png")));
    		}
    		break;
    	case "com.mygdx.game.model.Soldat" :
    		if(this.liveObject.getJoueur().getCouleur() == Color.blue) {
    			this.sprite = new Sprite(new Texture(Gdx.files.internal("Tiles/SoldatBleu.png")));
    		} else {
    			this.sprite = new Sprite(new Texture(Gdx.files.internal("Tiles/SoldatRouge.png")));
    		}
    		break;
    	case "com.mygdx.game.model.Archer" : 
    		if(this.liveObject.getJoueur().getCouleur() == Color.blue) {
    			this.sprite = new Sprite(new Texture(Gdx.files.internal("Tiles/archer_bleu.png")));
    		} else {
    			this.sprite = new Sprite(new Texture(Gdx.files.internal("Tiles/archer_rouge.png")));
    		}
    		break;
    /* AFFICHAGE DES RESSOURCES -> NE SONT PAS DES LIVE OBJECT */
    	
    	}

    } 
    
}
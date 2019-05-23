package com.mygdx.game.vue.vue_carte;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.model.Batiment;
import com.mygdx.game.model.Carte;
import com.mygdx.game.model.Joueur;
import com.mygdx.game.model.Partie;
import com.mygdx.game.model.Unite;


public class TiledMapStage extends Stage {

    private TiledMap tiledMap;

    private Partie partie;

    public static final int size = 16;

    public TiledMapStage(TiledMap tiledMap, Partie p) {
        partie = p;
    	
        //partie.setCarte(new Carte(((TiledMapTileLayer)tiledMap.getLayers().get(0)).getWidth()));
    	
        this.tiledMap = tiledMap;
        for (MapLayer layer : tiledMap.getLayers()) {
            TiledMapTileLayer tiledLayer = (TiledMapTileLayer)layer;
            createActorsForLayer(tiledLayer);
        }

        createLiveObjectActors();
    }

    private void createActorsForLayer(TiledMapTileLayer tiledLayer) {
        for (int x = 0; x < tiledLayer.getWidth(); x++) {
            for (int y = 0; y < tiledLayer.getHeight(); y++) {
                if(tiledLayer.getCell(x, y) != null) {
                    TiledMapActor actor = new TiledMapActor(tiledMap, tiledLayer, x, y);
                    actor.setBounds(x * tiledLayer.getTileWidth(), y * tiledLayer.getTileHeight(), tiledLayer.getTileWidth(), tiledLayer.getTileHeight());
                    addActor(actor);
                    EventListener eventListener = new TiledMapClickListener(actor);
                    actor.addListener(eventListener);
                    partie.getCarte().setComposant(x, y, actor.cellule);
                }
            }
        }
        partie.initPartie();
    }
    
    /** Nous permets de créer tous les acteurs liées à nos batiments et unités.
     * Les acteurs liée au stage pourront ensutie être déssinés et affichés.
     */
    private void createLiveObjectActors() {
    	for(Joueur j : partie.getJoueurs()) {
        	for(Batiment bat : j.getBatiments()) {
        		LiveObjectActor batActor = new LiveObjectActor(bat);
        		LiveObjectClickListener batListener = new LiveObjectClickListener(batActor);
        		this.addActor(batActor);
        	};
        	for(Unite a : j.getArcher()) {
        		LiveObjectActor archerActor = new LiveObjectActor(a);
        		LiveObjectClickListener archerListener = new LiveObjectClickListener(archerActor);
        		this.addActor(archerActor);
        	};
        	for(Unite s : j.getSoldat()) {
        		LiveObjectActor soldatActor = new LiveObjectActor(s);
        		LiveObjectClickListener soldatListener = new LiveObjectClickListener(soldatActor);
        		this.addActor(soldatActor);
        	};
    	}
    }

    @Override
    public boolean keyUp(int keycode) {
        OrthographicCamera camera = (OrthographicCamera) getViewport().getCamera();
        if(keycode == Input.Keys.LEFT)
            camera.translate(-32,0);
        if(keycode == Input.Keys.RIGHT)
            camera.translate(32,0);
        if(keycode == Input.Keys.DOWN)
            camera.translate(0,-32);
        if(keycode == Input.Keys.UP)
            camera.translate(0,32);
        if(keycode == Input.Keys.NUM_1)
            tiledMap.getLayers().get(0).setVisible(!tiledMap.getLayers().get(0).isVisible());
        if(keycode == Input.Keys.NUM_2)
            tiledMap.getLayers().get(1).setVisible(!tiledMap.getLayers().get(1).isVisible());
        return false;
    }
}

package com.mygdx.game.vue.vue_carte;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.model.Batiment;
import com.mygdx.game.model.Carte;
import com.mygdx.game.model.Joueur;
import com.mygdx.game.model.Partie;
import com.mygdx.game.model.Unite;


public class TiledMapStage extends Stage {

	protected TiledMap tiledMap;

    protected Partie partie;
    
    protected OrthographicCamera camera;
    
    protected UIMapStage uiStage;
    
    InputMultiplexer inputMultiplexer;

    public TiledMapStage(TiledMap tiledMap, Partie p) {
    	partie = p;
    	
        this.tiledMap = tiledMap;
        GlobalClickListener.partie = p;
        GlobalClickListener.objetSelec = null; 
        for (MapLayer layer : tiledMap.getLayers()) {
            TiledMapTileLayer tiledLayer = (TiledMapTileLayer)layer;
            createActorsForLayer(tiledLayer);
        }
        partie.initPartie();
       

        createLiveObjectActors();
        
        uiStage = new UIMapStage(p, this);
        
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        camera.update();
        
        getViewport().setCamera(camera);
        getViewport().setScreenX(0);
        getViewport().setScreenY(0);
        
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(uiStage);
        inputMultiplexer.addProcessor(this);
    }

    private void createActorsForLayer(TiledMapTileLayer tiledLayer) {
        for (int x = 0; x < tiledLayer.getWidth(); x++) {
            for (int y = 0; y < tiledLayer.getHeight(); y++) {
                if(tiledLayer.getCell(x, y) != null) {
                    TiledMapActor actor = new TiledMapActor(tiledMap, tiledLayer, x, y);
                    actor.setBounds(x * tiledLayer.getTileWidth(), y * tiledLayer.getTileHeight(), tiledLayer.getTileWidth(), tiledLayer.getTileHeight());
                    addActor(actor);
                    EventListener eventListener = new TiledMapClickListener(actor,this);
                    actor.addListener(eventListener);
                    partie.getCarte().setComposant(x, y, actor.cellule);
                }
            }
        }
    }
    
    /** Nous permets de crÃ©er tous les acteurs liÃ©es Ã  nos batiments et unitÃ©s.
     * Les acteurs liÃ©e au stage pourront ensutie Ãªtre dÃ©ssinÃ©s et affichÃ©s.
     */
    private void createLiveObjectActors() {
    	for(Joueur j : partie.getJoueurs()) {
        	for(Batiment bat : j.getBatiments()) {
        		LiveObjectActor batActor = new LiveObjectActor(bat,this);
        		LiveObjectClickListener batListener = new LiveObjectClickListener(batActor);
        		batActor.addListener(batListener);
        		this.addActor(batActor);
        	};
        	for(Unite a : j.getArcher()) {
        		LiveObjectActor archerActor = new LiveObjectActor(a,this);
        		LiveObjectClickListener archerListener = new LiveObjectClickListener(archerActor);
        		archerActor.addListener(archerListener);
        		this.addActor(archerActor);
        	};
        	for(Unite s : j.getSoldat()) {
        		LiveObjectActor soldatActor = new LiveObjectActor(s,this);
        		LiveObjectClickListener soldatListener = new LiveObjectClickListener(soldatActor);
        		soldatActor.addListener(soldatListener);
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
    
    

	public UIMapStage getUiStage() {
		return uiStage;
	}

	public void setUiStage(UIMapStage uiStage) {
		this.uiStage = uiStage;
	}

	public InputMultiplexer getInputMultiplexer() {
		return inputMultiplexer;
	}
    
    
}

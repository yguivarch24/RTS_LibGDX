package com.mygdx.game.vue.vue_carte;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.model.Carte;


public class TiledMapStage extends Stage {

    private TiledMap tiledMap;

    private Carte carte;

    public static final int size = 16;

    public TiledMapStage(TiledMap tiledMap) {
        this.tiledMap = tiledMap;
        for (MapLayer layer : tiledMap.getLayers()) {
            TiledMapTileLayer tiledLayer = (TiledMapTileLayer)layer;
            createActorsForLayer(tiledLayer);
        }
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
                }
            }
        }
    }

    @Override
    public boolean keyUp(int keycode) {
        OrthographicCamera camera = (OrthographicCamera) getViewport().getCamera();
        if(keycode == Input.Keys.LEFT)
            camera.translate(-32,0);
        if(keycode == Input.Keys.RIGHT)
            camera.translate(32,0);
        if(keycode == Input.Keys.UP)
            camera.translate(0,-32);
        if(keycode == Input.Keys.DOWN)
            camera.translate(0,32);
        if(keycode == Input.Keys.NUM_1)
            tiledMap.getLayers().get(0).setVisible(!tiledMap.getLayers().get(0).isVisible());
        if(keycode == Input.Keys.NUM_2)
            tiledMap.getLayers().get(1).setVisible(!tiledMap.getLayers().get(1).isVisible());
        return false;
    }
}

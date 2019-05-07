package com.mygdx.game.vue.vue_carte;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.model.ComposantCarte;
import com.mygdx.game.model.Plaine;

public class TiledMapActor extends Actor {

    TiledMap tiledMap;

    TiledMapTileLayer tiledLayer;

    ComposantCarte cellule;

    public TiledMapActor(TiledMap tiledMap, TiledMapTileLayer tiledLayer, int x, int y) {
        this.tiledMap = tiledMap;
        this.tiledLayer = tiledLayer;
        switch (tiledLayer.getCell(x, y).getTile().getId()) {
            case 1 : cellule = new Plaine(x, y);

            default: cellule = new Plaine(x, y);
        }
    }
}

package com.mygdx.game.vue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.model.Partie;
import com.mygdx.game.model.Joueur;
import com.mygdx.game.model.LiveObject;
import com.mygdx.game.model.Soldat;
import com.mygdx.game.model.Unite;
import com.mygdx.game.vue.vue_carte.GlobalClickListener;
import com.mygdx.game.vue.vue_carte.LiveObjectActor;
import com.mygdx.game.vue.vue_carte.TiledMapStage;

public class Map1 implements Screen {

    private MyGdxGameRTSLauncher game;
    private SpriteBatch batch;
   // private Joueur joueur;
    
    /** Notre partie à render */
    private Partie partie;
    

    TiledMapStage stage;
    TiledMap tiledMap;
    TiledMapRenderer tiledMapRenderer;
   

    
    /** Constructeur */
    public Map1(MyGdxGameRTSLauncher game) {

    	
        this.game = game;


        tiledMap = new TmxMapLoader().load("Tiles/grass_tileset_map.tmx");
        int tailleMap = ((TiledMapTileLayer)tiledMap.getLayers().get(0)).getWidth();
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        partie = new Partie(2, tailleMap); 
        stage = new TiledMapStage(tiledMap, partie);
    }
    
    /** Rafraichir*/
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getViewport().getCamera().update();
        tiledMapRenderer.setView((OrthographicCamera)stage.getViewport().getCamera());
        tiledMapRenderer.render();
        stage.getViewport().apply();
        stage.act();
        stage.draw();

        // now switch the viewport and activate the other one
        stage.getUiStage().getViewport().apply();
        stage.getUiStage().act();
        stage.getUiStage().draw();
    }

    @Override
    public void resize(int width, int height) {
    	stage.getViewport().update(width, height, true);
    	stage.getUiStage().getViewport().update(width, height, false);
    }


    @Override
    public void show() {
        // called when this screen is set as the screen with game.setScreen();
    }

    @Override
    public void hide() {
        // called when current screen changes from this to a different screen
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        // never called automatically
    }
}

package com.mygdx.game.vue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.model.Joueur;
import com.mygdx.game.model.LiveObject;
import com.mygdx.game.model.Soldat;
import com.mygdx.game.model.Unite;
import com.mygdx.game.vue.vue_carte.TiledMapStage;
import com.mygdx.game.vue.vue_liveobject.LiveObjectActor;

public class Map1 implements Screen {

    private MyGdxGameRTSLauncher game;
    private SpriteBatch batch;
    private Joueur joueur;

    TiledMapStage stage;
    TiledMap tiledMap;
    TiledMapRenderer tiledMapRenderer;
    OrthographicCamera camera;

    /** Constructeur */
    public Map1(MyGdxGameRTSLauncher game) {

        this.game = game;

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        camera.update();

        tiledMap = new TmxMapLoader().load("Tiles/grass_tileset_map.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        LiveObject soldat = new Soldat(0, 0, this.joueur);
        LiveObjectActor vuesoldat = new LiveObjectActor(soldat);
        stage = new TiledMapStage(tiledMap);
        stage.getViewport().setCamera(camera);
        stage.getViewport().setScreenX(0);
        stage.getViewport().setScreenY(0);
        stage.addActor(vuesoldat);
    }
    
    /** Rafraichir*/
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        stage.act(delta);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
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


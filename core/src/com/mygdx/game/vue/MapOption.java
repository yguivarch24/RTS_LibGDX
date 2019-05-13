package com.mygdx.game.vue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.model.Joueur;
import com.mygdx.game.model.LiveObject;
import com.mygdx.game.model.Soldat;
import com.mygdx.game.model.Unite;
import com.mygdx.game.vue.vue_carte.TiledMapStage;
import com.mygdx.game.vue.vue_liveobject.LiveObjectActor;

public class MapOption implements Screen {
	

	private MyGdxGameRTSLauncher game;
    private SpriteBatch spriteBatch;
    private Texture texture;
    private final Skin skin = new Skin( Gdx.files.internal( "defaultskin.json" ));
    Stage stage;
    private Table table;
    private final TextButton Sounds = new TextButton("Sound",skin);
    private final TextButton on = new TextButton("on",skin);
    private final TextButton off = new TextButton("off",skin);
    private final TextButton rtn = new TextButton("Return",skin);
    private final Music mp3Music = Gdx.audio.newMusic(Gdx.files.internal("GloriousMorning.mp3"));

	    /** Constructeur */
	    public MapOption( MyGdxGameRTSLauncher pgame) {

	        this.game = pgame;

	        /** Chargement de l'image */
	        texture = new Texture(Gdx.files.internal("backgroundMenu.jpg"));
	        /** Pour le menu */
	        stage=new Stage(new FitViewport(800,480,new OrthographicCamera())); //stage permet la gestion des fenêtres ?
	        /**Pour déssiner l'image */
	        spriteBatch = new SpriteBatch();
	        

	        table=new Table();
	        table.setSize(800,480);

	        table.add(Sounds).width(200).padTop(20).padBottom(3);
	        table.row();

	        table.add(on).width(100).padTop(10);
	        table.row();
	        
	        table.add(off).width(100).padTop(10);
	        table.row();
	        
	        table.add(rtn).width(200).padTop(10);
	        table.row();

	        stage.addActor(table);
	        mp3Music.setLooping(true);

	        on.addListener(new ClickListener(){
	            @Override
	            /** Listener sur le bouton startGame*/
	            public void clicked(InputEvent event, float x, float y) {
	                mp3Music.play();
	            }
	        });
	        
	        off.addListener(new ClickListener(){
	        	@Override
	            /** Listener sur le bouton options*/
	            public void clicked(InputEvent event, float x, float y) {
	                mp3Music.pause();
	            }
	        });

	        rtn.addListener(new ClickListener(){
	        	@Override
	            /** Listener sur le bouton options*/
	            public void clicked(InputEvent event, float x, float y) {
	        		Gdx.input.setInputProcessor(game.mainMenuScreen.stage);
	                game.setScreen(game.mainMenuScreen);
	            }
	        });
	    }
	    
	    /** Rafraichir*/
	    @Override
	    public void render(float delta) {
	    	// clear the screen
	        Gdx.gl.glClearColor(0,0,0, 1);
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	        spriteBatch.begin();
	        spriteBatch.draw(texture, 0, 0);
	        spriteBatch.end();

	        // let the stage act and draw
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


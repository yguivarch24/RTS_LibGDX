package com.mygdx.game.vue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainMenuScreen implements Screen {

    private MyGdxGameRTSLauncher game;
    private SpriteBatch spriteBatch;
    private Texture texture;
    private final Skin skin = new Skin( Gdx.files.internal( "defaultskin.json" ));
    Stage stage;
    private Table table;
    private final TextButton startGame = new TextButton("start game",skin);
    private final TextButton options = new TextButton("options",skin);
    private final TextButton quit = new TextButton("quit",skin);
    private final Music mp3Music = Gdx.audio.newMusic(Gdx.files.internal("GloriousMorning.mp3"));


    // Constructeur, permet de garder une référence sur la classe principale Game
    public MainMenuScreen(MyGdxGameRTSLauncher pgame){
        this.game = pgame;
        /** Chargement de l'image */
        texture = new Texture(Gdx.files.internal("backgroundMenu.jpg"));
        /** Pour le menu */
        stage=new Stage(new FitViewport(800,480,new OrthographicCamera())); //stage permet la gestion des fenêtres ?
        /**Pour déssiner l'image */
        spriteBatch = new SpriteBatch();

        /** Indiquer que le stage est intéractif */
        Gdx.input.setInputProcessor(stage);

        table=new Table();
        table.setSize(800,480);

        table.add(startGame).width(200).height(50);
        table.row();

        table.add(options).width(150).padTop(10).padBottom(3);
        table.row();

        table.add(quit).width(100).padTop(10);
        table.row();

        stage.addActor(table);
        mp3Music.play();
        mp3Music.setLooping(true);

        startGame.addListener(new ClickListener(){
            @Override
            /** Listener sur le bouton startGame*/
            public void clicked(InputEvent event, float x, float y) {
                startGame.addAction(Actions.fadeOut(0.7f));
                mp3Music.stop();
                Gdx.input.setInputProcessor(game.map1.stage);
                game.setScreen(game.map1);
            }
        });
        options.addListener(new ClickListener(){
        	@Override
            /** Listener sur le bouton options*/
            public void clicked(InputEvent event, float x, float y) {
                Gdx.input.setInputProcessor(game.mapOption.stage);
                game.setScreen(game.mapOption);
            }
        });

        quit.addListener(new ClickListener(){
        	/** Listener sur le bouton quit*/
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
            }
        });
    }
    
    /** Rafraichir l'image */
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
        stage.getViewport().update(width, height,true);
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
        game.dispose();
    }
}

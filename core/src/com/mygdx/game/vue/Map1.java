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
    
    /** Notre partie à render */
    private Partie partie;
    

    TiledMapStage stage;
    TiledMap tiledMap;
    TiledMapRenderer tiledMapRenderer;
   
    Skin skin;
   

    
    /** Constructeur */
    public Map1(MyGdxGameRTSLauncher game) {

    	
        this.game = game;


        tiledMap = new TmxMapLoader().load("Tiles/grass_tileset_map.tmx");
        int tailleMap = ((TiledMapTileLayer)tiledMap.getLayers().get(0)).getWidth();
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        partie = new Partie(2, tailleMap); 
        stage = new TiledMapStage(tiledMap, partie);

        


        
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		// Generate a 1x1 white texture and store it in the skin named "white".
		Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("white", new Texture(pixmap));
        
		// Store the default libgdx font under the name "default".
		skin.add("default", new BitmapFont());

		// Configure a TextButtonStyle and name it "default". Skin resources are stored by type, so this doesn't overwrite the font.
		/* TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
		textButtonStyle.font = skin.getFont("default");
		skin.add("default", textButtonStyle); */
		
		/* Affiche le joueur courant et le bouton joueur suivant */
		Table tableJ = new Table(skin);
		tableJ.setFillParent(true);
		final TextButton buttonJoueurSuivant = new TextButton("Joueur Suivant", skin);
		final Label joueurCourantTxt = new Label("Joueur courant : " + partie.getJoueur().getPseudo(), skin);
		tableJ.add(joueurCourantTxt);
		tableJ.add(buttonJoueurSuivant);

		/* Affiche les stats du joueurs 1 */
		Table tableJ1 = new Table(skin);
		tableJ1.setFillParent(true);
		final Label ressourceJ1 = new Label("Joueur1 \nOr : " + partie.getJoueurs().get(1).getOr() + "\nBois : " 
		+ partie.getJoueurs().get(1).getBois() + "\nNourriture : " + partie.getJoueurs().get(1).getNourriture(), skin);
		tableJ1.add(ressourceJ1);
		
		/* Affiche les stats du joueurs 2 */
		Table tableJ2 = new Table(skin);
		tableJ2.setFillParent(true);
		final Label ressourceJ2 = new Label("Joueur2 \nOr : " + partie.getJoueurs().get(2).getOr() + "\nBois : " 
		+ partie.getJoueurs().get(2).getBois() + "\nNourriture : " + partie.getJoueurs().get(2).getNourriture(), skin);
		tableJ2.add(ressourceJ2);

		tableJ.bottom();
		tableJ1.top();
		tableJ1.left();
		tableJ2.top();
		tableJ2.right();
		
		stage.addActor(tableJ);
		stage.addActor(tableJ1);
		stage.addActor(tableJ2);

		buttonJoueurSuivant.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				partie.joueurSuivant();
				System.out.println("Joueur courant : " + partie.getJoueur().getPseudo());
				joueurCourantTxt.setText("Joueur courant : " + partie.getJoueur().getPseudo());
			}
		});
    }
    
    /** Rafraichir*/
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getViewport().getCamera().update();
        tiledMapRenderer.setView((OrthographicCamera)stage.getViewport().getCamera());
        tiledMapRenderer.render();
        stage.act(delta);
        //Now render objects in your stage on top.
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    	stage.getViewport().update(width, height);
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

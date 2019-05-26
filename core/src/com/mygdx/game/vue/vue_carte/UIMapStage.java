package com.mygdx.game.vue.vue_carte;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.model.CaseOccupeeException;
import com.mygdx.game.model.Caserne;
import com.mygdx.game.model.LiveObject;
import com.mygdx.game.model.Partie;
import com.mygdx.game.model.RessourceIndisponibleException;
import com.mygdx.game.model.Unite;

public class UIMapStage extends Stage {
	
	Partie partie;
	TiledMapStage stage;
	
	final Skin skin = new Skin(Gdx.files.internal("golden-spiral/skin/golden-ui-skin.json"));
	final TextButton archer = new TextButton("Archer", skin);
	final TextButton soldat = new TextButton("Soldat", skin);
	List<String> ressourceJoueur = new List<>(skin);
	
	public UIMapStage(Partie partie, TiledMapStage stage) {
		
		this.stage = stage;
		this.partie = partie;
		
		
		// Generate a 1x1 white texture and store it in the skin named "white".
		Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("white", new Texture(pixmap));
        
		// Store the default libgdx font under the name "default".
		skin.add("default", new BitmapFont());
		
		Table tableProd = new Table(skin);
		Table tableTour = new Table(skin);
		Table tableRessource = new Table(skin);
		
		tableProd.setFillParent(true);
		tableTour.setFillParent(true);
		tableRessource.setFillParent(true);

		addActor(tableProd);
		addActor(tableTour);
		addActor(tableRessource);
		
		final TextButton button = new TextButton("Joueur Suivant", skin);

		final Label joueurCourantTxt = new Label("Joueur courant : " + partie.getJoueur().getPseudo(), skin);
	
		final List<String> ressourceJoueur = new List<>(skin);
		
		Array<String> strList = new Array<>();
		strList.add("Bois : " + partie.getJoueur().getBois());
		strList.add("Or : " + partie.getJoueur().getOr());
		strList.add("Nourriture : " + partie.getJoueur().getNourriture());
		ressourceJoueur.setItems(strList);
		
		
		soldat.setVisible(false);
		archer.setVisible(false);
		
		tableProd.pad(5.0f);
		tableTour.pad(5.0f);
		tableRessource.pad(5.0f);
		
		tableTour.bottom().right();
		tableTour.add(joueurCourantTxt);
		tableTour.add(button);
		
		tableRessource.top().right();
		tableRessource.add(ressourceJoueur);
		
		tableProd.bottom().left();
		tableProd.add(archer);
		tableProd.add(soldat);
		
		button.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				partie.joueurSuivant();
				joueurCourantTxt.setText("Joueur courant : " + partie.getJoueur().getPseudo());
				
				Array<String> strList = new Array<>();
				strList.add("Bois : " + GlobalClickListener.partie.getJoueur().getBois());
				strList.add("Or : " + GlobalClickListener.partie.getJoueur().getOr());
				strList.add("Nourriture : " + GlobalClickListener.partie.getJoueur().getNourriture());
				ressourceJoueur.setItems(strList);
				
				soldat.setVisible(false);
        		archer.setVisible(false);
			}
		});
		
		archer.addListener(new GlobalClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				
				if(objetSelec instanceof Caserne) {
					Caserne caserne = (Caserne) objetSelec;
					try {
						partie.getJoueur().payer(20,0,20);
						LiveObject u = caserne.creerUnite("Archer", partie.getCarte(), partie.getJoueur());
						LiveObjectActor archerActor = new LiveObjectActor(u, stage);
		        		LiveObjectClickListener archerListener = new LiveObjectClickListener(archerActor);
		        		archerActor.addListener(archerListener);
		        		stage.addActor(archerActor);
		        		soldat.setVisible(false);
		        		archer.setVisible(false);
		        		refreshRessource();
					}
					catch(RessourceIndisponibleException e) {
						System.out.println(e.getMessage());
					}
					catch(CaseOccupeeException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		});
		
		soldat.addListener(new GlobalClickListener() {
			public void clicked (InputEvent event, float x, float y) {
				
				if(objetSelec instanceof Caserne) {
					Caserne caserne = (Caserne) objetSelec;
					try {
						partie.getJoueur().payer(15,0,15);
						LiveObject u = caserne.creerUnite("Soldat", partie.getCarte(), partie.getJoueur());
						LiveObjectActor soldatActor = new LiveObjectActor(u, stage);
		        		LiveObjectClickListener soldatListener = new LiveObjectClickListener(soldatActor);
		        		soldatActor.addListener(soldatListener);
		        		stage.addActor(soldatActor);
		        		soldat.setVisible(false);
		        		archer.setVisible(false);
		        		Array<String> strList = new Array<>();
		        		strList.add("Bois : " + GlobalClickListener.partie.getJoueur().getBois());
		        		strList.add("Or : " + GlobalClickListener.partie.getJoueur().getOr());
		        		strList.add("Nourriture : " + GlobalClickListener.partie.getJoueur().getNourriture());
		        		ressourceJoueur.setItems(strList);
						
					}
					catch(RessourceIndisponibleException e) {
						System.out.println(e.getMessage());
					}
					catch(CaseOccupeeException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		});
	}
	
	public void refreshRessource() {
		ressourceJoueur.clearItems();
		Array<String> strList = new Array<>();
		System.out.println(partie.getJoueur());
		strList.add("Bois : " + GlobalClickListener.partie.getJoueur().getBois());
		strList.add("Or : " + GlobalClickListener.partie.getJoueur().getOr());
		strList.add("Nourriture : " + GlobalClickListener.partie.getJoueur().getNourriture());
		ressourceJoueur.setItems(strList);
	}
	
}

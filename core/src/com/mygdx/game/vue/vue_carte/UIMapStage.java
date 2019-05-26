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
	
	public UIMapStage(Partie partie, TiledMapStage stage) {
		
		this.stage = stage;
		
		
		// Generate a 1x1 white texture and store it in the skin named "white".
		Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("white", new Texture(pixmap));
        
		// Store the default libgdx font under the name "default".
		skin.add("default", new BitmapFont());

		// Configure a TextButtonStyle and name it "default". Skin resources are stored by type, so this doesn't overwrite the font.
		
		/*TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
		textButtonStyle.font = skin.getFont("default");
		skin.add("default", textButtonStyle); */
		
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
		
		/* PARTIE DE JUSTIN */
		//skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
				
		/* Affiche le joueur courant et le bouton joueur suivant */
		/*Table tableJ = new Table(skin);
		tableJ.setFillParent(true);
		final TextButton buttonJoueurSuivant = new TextButton("Joueur Suivant", skin);
		final Label joueurCourantTxt = new Label("Joueur courant : " + partie.getJoueur().getPseudo(), skin);
		tableJ.add(joueurCourantTxt);
		tableJ.add(buttonJoueurSuivant);*/

		/* Affiche les stats du joueurs 1 */
		/*Table tableJ1 = new Table(skin);
		tableJ1.setFillParent(true);
		final Label ressourceJ1 = new Label("Joueur1 \nOr : " + partie.getJoueurs().get(1).getOr() + "\nBois : " 
		+ partie.getJoueurs().get(1).getBois() + "\nNourriture : " + partie.getJoueurs().get(1).getNourriture(), skin);
		tableJ1.add(ressourceJ1);*/
		
		/* Affiche les stats du joueurs 2 */
		/*Table tableJ2 = new Table(skin);
		tableJ2.setFillParent(true);
		final Label ressourceJ2 = new Label("Joueur2 \nOr : " + partie.getJoueurs().get(2).getOr() + "\nBois : " 
		+ partie.getJoueurs().get(2).getBois() + "\nNourriture : " + partie.getJoueurs().get(2).getNourriture(), skin);
		tableJ2.add(ressourceJ2);*/

		/*tableJ.bottom();
		tableJ1.top();
		tableJ1.left();
		tableJ2.top();
		tableJ2.right();
		
		stage.addActor(tableJ);
		stage.addActor(tableJ1);
		stage.addActor(tableJ2);*/

		/*buttonJoueurSuivant.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				partie.joueurSuivant();
				System.out.println("Joueur courant : " + partie.getJoueur().getPseudo());
				joueurCourantTxt.setText("Joueur courant : " + partie.getJoueur().getPseudo());
			}
		});*/
		
		button.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				partie.joueurSuivant();
				joueurCourantTxt.setText("Joueur courant : " + partie.getJoueur().getPseudo());
				
				Array<String> strList = new Array<>();
				strList.add("Bois : " + partie.getJoueur().getBois());
				strList.add("Or : " + partie.getJoueur().getOr());
				strList.add("Nourriture : " + partie.getJoueur().getNourriture());
				ressourceJoueur.setItems(strList);
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
	
	
	
}

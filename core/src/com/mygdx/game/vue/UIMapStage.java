package com.mygdx.game.vue.vue_carte;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.Actor;
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
import com.mygdx.game.model.Partie;

public class UIMapStage extends Stage {
	
	Skin skin;
	Partie partie;
	
	public UIMapStage(Partie partie) {
		skin = new Skin(Gdx.files.internal("golden-spiral/skin/golden-ui-skin.json"));
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
		
		Table table = new Table(skin);
		table.setFillParent(true);

		addActor(table);
		table.bottom();
		
		final TextButton button = new TextButton("Joueur Suivant", skin);

		final Label joueurCourantTxt = new Label("Joueur courant : " + partie.getJoueur().getPseudo(), skin);
	
		final List<String> ressourceJoueur = new List<>(skin);
		final Label ressourceJ1 = new Label("Joueur1 bois : " + partie.getJoueur().getBois(), skin);
		
		Array<String> strList = new Array<>();
		strList.add("Bois : " + partie.getJoueur().getBois());
		strList.add("Or : " + partie.getJoueur().getOr());
		strList.add("Nourriture : " + partie.getJoueur().getNourriture());
		ressourceJoueur.setItems(strList);
		
		final TextButton archer = new TextButton("Archer", skin);
		final TextButton soldat = new TextButton("Soldat", skin);
		soldat.setVisible(false);
		archer.setVisible(false);
		
		
		
		table.add(joueurCourantTxt);
		table.add(button);
		table.add(ressourceJoueur);
		table.add(archer);
		table.add(soldat);
		
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
	}
	
	
}

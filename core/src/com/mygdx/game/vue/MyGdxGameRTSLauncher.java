package com.mygdx.game.vue;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class MyGdxGameRTSLauncher extends Game {

	protected float musicVolume;
	protected MainMenuScreen mainMenuScreen;
	protected Map1 map1;


	@Override
	public void create() {
		musicVolume = 0.5f;
		mainMenuScreen = new MainMenuScreen(this);
		map1 = new Map1(this);
		setScreen(mainMenuScreen);
	}

	@Override
	public void dispose() {
		Gdx.app.exit();
	}
}
